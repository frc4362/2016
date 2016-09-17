package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AimDown extends Command {

	private boolean x;
	
    public AimDown() {
    	requires(Robot.head);
    }

    protected void initialize() {
    	x = true;
    }

    protected void execute() {
    	Robot.head.aimDown();
    }

    protected boolean isFinished() {
        return x;
    }

    protected void end() {
    }
    
    protected void interrupted() {
    }
}
