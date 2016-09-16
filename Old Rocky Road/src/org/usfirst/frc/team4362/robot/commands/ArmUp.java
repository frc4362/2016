package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class ArmUp extends Command {

	boolean x;
	
    public ArmUp() {
    	requires(Robot.slider);
    }

    protected void initialize() {
    	x = true;
    }

    protected void execute() {
    	Robot.slider.up();
    }

    protected boolean isFinished() {
        return x;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
