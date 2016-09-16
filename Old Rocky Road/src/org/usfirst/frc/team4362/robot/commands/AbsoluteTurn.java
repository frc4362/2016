package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;
import org.usfirst.frc.team4362.robot.commands.auton.DriveTurn;

public class AbsoluteTurn extends DriveTurn {

	double destination;
	
    public AbsoluteTurn(double destination) {
    	super(0, 0.25);
    	this.destination = destination;
    }

    protected void initialize() {
    	this.startpoint = Robot.gyro.getRawAngle();
    	this.endpoint = destination;
    	this.degrees = endpoint - startpoint;
    	this.setBase(degrees);
    }
}
