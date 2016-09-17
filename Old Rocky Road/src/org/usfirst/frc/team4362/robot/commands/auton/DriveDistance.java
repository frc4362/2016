package org.usfirst.frc.team4362.robot.commands.auton;

import org.usfirst.frc.team4362.robot.Robot;
import org.usfirst.frc.team4362.robot.utilities.Side;

import edu.wpi.first.wpilibj.command.Command;


public class DriveDistance extends Command {

	boolean execState;
	int distance;
	double speed;
	
	Side left = Robot.driveTrain.Left,
		 right = Robot.driveTrain.Right;
	
    public DriveDistance(int distance) {
    	this(distance, 0.25);
    }
    
    public DriveDistance(int distance, double speed){
    	requires(Robot.driveTrain);
    	this.distance = distance;
    	this.speed = speed;
    }

    protected void initialize() {
    }

    protected void execute() {
    	execState = true; 
    	int parity = distance > 0 ? 1 : -1;
    	distance = Math.abs(distance);
    	left.encoder.reset();
    	right.encoder.reset();
    	while(left.encoder.getDistance() * parity < distance
    		  && right.encoder.getDistance() * parity < distance){
    		Robot.driveTrain.tankDrive(-parity * speed, -parity * speed);
    	}
    }

    protected boolean isFinished() {
        return execState;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}