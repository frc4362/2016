package org.usfirst.frc.team4362.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.util.HashMap;
import java.util.Map;

import org.usfirst.frc.team4362.robot.auton.Auton_DoNothing;
import org.usfirst.frc.team4362.robot.auton.Auton_DriveForward;
import org.usfirst.frc.team4362.robot.auton.Auton_HighGoal;
import org.usfirst.frc.team4362.robot.auton.Auton_Shoot;
import org.usfirst.frc.team4362.robot.auton.Auton_SpyBox;
import org.usfirst.frc.team4362.robot.auton.Auton_Turn;
import org.usfirst.frc.team4362.robot.subsystems.Climber;
import org.usfirst.frc.team4362.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4362.robot.subsystems.Gyro;
import org.usfirst.frc.team4362.robot.subsystems.Head;
import org.usfirst.frc.team4362.robot.subsystems.Light;
import org.usfirst.frc.team4362.robot.subsystems.Slider;
import org.usfirst.frc.team4362.robot.utilities.AutonPreset;
import org.usfirst.frc.team4362.robot.utilities.GRIPOutput;
import org.usfirst.frc.team4362.robot.utilities.REVDigitBoard;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;


@SuppressWarnings("unused")
public class Robot extends IterativeRobot {

    int selectedAutonIndex = 0,
    	change = 0,
	lastChange = 0;

    public static final PowerDistributionPanel PDP = new PowerDistributionPanel();
    public static final REVDigitBoard digitBoard = new REVDigitBoard();
    public static final DriveTrain driveTrain = new DriveTrain();
    public static final Climber climber = new Climber();
    public static final Slider slider = new Slider();
    public static final Light light = new Light();
    public static final Head head = new Head();
    public static final Gyro gyro = new Gyro();

    public static boolean rearCam = true;
    public static USBCamera camFront, camBack;

    public static boolean isAimingAtTower;
    public static OI oi;

    AutonPreset selectedAuton;
    Command autonomousCommand = null;
    SendableChooser chooser;
    
    public static Thread cstThread;
    CameraStreamingThread cst;

    // angles are 40 35 20 -15 -20
    // new angles are 30 20 0 0 -10

    AutonPreset[] autonPresets = new AutonPreset[]{
        new AutonPreset("work", new Auton_HighGoal(0, 0, true)),
    	new AutonPreset("dead", new Auton_DoNothing(), "does nothing"),
    	new AutonPreset("pos1", new Auton_HighGoal(120, 30, false)),
    	new AutonPreset("pos2", new Auton_HighGoal(120, 20, true)),
    	new AutonPreset("pos3", new Auton_HighGoal(120, 0, true)),
    	new AutonPreset("pos4", new Auton_HighGoal(120, 0, true)),
    	new AutonPreset("pos5", new Auton_HighGoal(120, -10, true)),
    	new AutonPreset("rise", new Auton_DriveForward(165, true), "raises the head and drives forward"),
    	new AutonPreset("fall", new Auton_DriveForward(165, false), "lowers the head and drives forward"),
    	new AutonPreset("snek", new Auton_SpyBox(5000), "does snekky things and scores a high goal"),
    	new AutonPreset("turn", new Auton_Turn(90), "turns 90 degrees"),
    };

    public void robotInit() {
    	SmartDashboard.putBoolean("crashed", false);
    	
    	oi = new OI();

	gyro.calibrate();

	driveTrain.shiftDown();

    	Image img = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    	CameraServer camServer = CameraServer.getInstance();

    }

    public void disabledInit(){
    	//new Thread(cst).interrupt();
    }

    public void disabledPeriodic() {

	// get what it should change the selection by
	// if both buttons are pressed, it's evaluated to NOT CHANGE
	// decrement if B is pressed, increment if A is pressed
	change = (digitBoard.getButtonA() ? 1 : 0) + (digitBoard.getButtonB() ? -1 : 0);

	// change the selection if the change is not equal to what it was last cycle
	// and normalize it to a relevant value
	selectedAutonIndex += change != lastChange ? change : 0;
	selectedAuton = autonPresets[Math.abs(selectedAutonIndex % autonPresets.length)];
	digitBoard.display(selectedAuton.name);

	lastChange = change;

	Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        autonomousCommand = selectedAuton.command;
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	cst = new CameraStreamingThread(this);
    	driveTrain.compressor.setClosedLoopControl(true);
    	new Thread(cst).start();
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }

    /**
     * @return The degrees that you need to turn to look at the tower
     */
    public static double getDegreesFromTower() {
    	int x;
    	double[] xs = GRIPOutput.getInstance().getTable().getNumberArray("centerX", new double[]{});
    	if(xs.length > 0){
	    	x = (int)xs[0];
	    	if(165 < x && x < 168){
	    		x = 0;
	    	}else if(x > 160){
	    		return 1;
	    	}else if(x < 173){
	    		return -1;
	    	}else{
	    		x -= 160;
	    	}

	    	double d = x * RobotMap.inchesPerPixel,
	    		   theta = Math.atan(d / 168); //168

	    	// return the degrees to turn
	    	return theta * 180 / Math.PI;
    	}else{
    		return 0;
    	}
    }
}
