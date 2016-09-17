package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;
import org.usfirst.frc.team4362.robot.RobotMap;
import org.usfirst.frc.team4362.robot.subsystems.Head;
//import org.usfirst.frc.team4362.robot.utilities.Logger;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {

	boolean isShooting, lastAimedUp;
	
	int loops;
	
	Head head = Robot.head;
	CANTalon talon1 = head.shooter1,
			 talon2 = head.shooter2,
			 intake = head.intake;

    public Shoot() {
    	requires(Robot.head);
    }

    protected void initialize() {

    	talon2.changeControlMode(TalonControlMode.Speed);
		talon2.set(0);
		talon2.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        talon2.reverseSensor(true);
        talon2.configEncoderCodesPerRev(4096);
        talon1.changeControlMode(TalonControlMode.Speed);
		talon1.set(0);
		talon1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        talon1.reverseSensor(true);
        talon1.configEncoderCodesPerRev(4096);
        talon1.setInverted(true);
        
        talon1.setP(0.08);
        talon1.setI(0);
        talon1.setD(0);
        talon1.setF(0.014); 
        
        talon2.setP(0.08);
        talon2.setI(0);
        talon2.setD(0);
        talon2.setF(0.014);
        
    }

    protected void execute() {
    	double targetSpeed = RobotMap.Calibration.targetRPM 
    				* (Robot.oi.controller.getRawAxis(3) - Robot.oi.controller.getRawAxis(2)),
    		   intakeSpeed = 0;
    	if(targetSpeed < 0){
    		intakeSpeed = -1;
    	}else if(targetSpeed > 0){
    		intakeSpeed = 1;
    	}
    	talon1.set(targetSpeed);
    	talon2.set(targetSpeed);
    	intake.set(-intakeSpeed);
    	
    	/*Logger.getInstance().put("rightRPM", talon1.getSpeed()); //TODO maybe reversed? test
    	Logger.getInstance().put("leftRPM", talon2.getSpeed());*/
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
