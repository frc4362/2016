package org.usfirst.frc.team4362.robot.commands.auton;

import org.usfirst.frc.team4362.robot.Robot;
//import org.usfirst.frc.team4362.robot.utilities.Logger;

public class AimAtHighGoal extends DriveTurn {
    public AimAtHighGoal() {
    	super(0	, 0.25);
    }

    protected void initialize() {
    	this.degrees = Robot.getDegreesFromTower();
    	super.initialize();
    }
    
}
