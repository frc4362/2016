package org.usfirst.frc.team4362.robot.commands.auton;

import org.usfirst.frc.team4362.robot.Robot;
//import org.usfirst.frc.team4362.robot.utilities.Logger;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTurn extends Command {

	protected double startpoint, endpoint, currentAngle, 
		   speed, degrees, base;

    public DriveTurn(double degrees, double speed) {
    	
    	requires(Robot.driveTrain);
    	requires(Robot.gyro);
    	
    	this.degrees = degrees;
    	setBase(degrees);
    	this.speed = speed;
    	
    }
    
    public DriveTurn(double degrees){
    	this(degrees, 0.25);
    }

    protected void initialize() {
    	setBase(this.degrees);
    	this.startpoint = Robot.gyro.getRawAngle();
    	this.endpoint = startpoint + degrees;
    	
    	/*Logger.getInstance().put("THIS IS THE STARTPOINT", startpoint);
    	Logger.getInstance().put("THIS IS THE ENDPOINT", endpoint);
    	Logger.getInstance().put("THIS IS THE DEGREES", degrees);
    	Logger.getInstance().put("THIS IS THE BASE", base);*/
    }

    protected void execute() {
    	this.currentAngle = Robot.gyro.getRawAngle();
    	Robot.driveTrain.tankDrive(base * speed * -1, base * speed * 0);
    }

    protected boolean isFinished() {
    	// Checks if direction of turn is right
        return base == 1 ? currentAngle >= endpoint : currentAngle <= endpoint;
    }

    protected void end(){
    	Robot.driveTrain.tankDrive(0.0, 0.0);
    }

    protected void interrupted() {
    }
    
    protected void setBase(double degrees){
    	this.base = degrees >= 0 ? 1 : -1;
    }
}
