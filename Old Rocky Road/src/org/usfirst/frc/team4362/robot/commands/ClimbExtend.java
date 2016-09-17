package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;
import org.usfirst.frc.team4362.robot.RobotMap;
import org.usfirst.frc.team4362.robot.subsystems.Climber;
//import org.usfirst.frc.team4362.robot.utilities.Logger;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class ClimbExtend extends Command {

	private boolean triggered;
	
	Climber climber = Robot.climber;
	CANTalon climbMotor1 = climber.climbMotor1;
	CANTalon climbMotor2 = climber.climbMotor2;

	double targetPos, currentPos;

    public ClimbExtend() {
    	requires(Robot.climber);
        triggered = false;
    }

    protected void initialize() {
    	climbMotor1.changeControlMode(TalonControlMode.PercentVbus);
		climbMotor1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        climbMotor1.reverseSensor(true);
        climbMotor1.configEncoderCodesPerRev(4096);

        climbMotor2.changeControlMode(TalonControlMode.Follower);
        climbMotor2.set(27);

        targetPos = climbMotor1.getEncPosition() - RobotMap.newClimbExtendDist;
        currentPos = climbMotor1.getEncPosition();
    }

    protected void execute() {
    	if (this.triggered) {
    		this.cancel();
    	}else{
	    	currentPos = climbMotor1.getEncPosition();
	    	if(currentPos > targetPos){
	    		climbMotor1.set(-1);
	    	}else if(currentPos <= targetPos){
	    		climbMotor1.set(0);
	    	}
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	this.triggered = true;
    }

    protected void interrupted() {
    }
}
