package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class KickIn extends Command {

	boolean x;
	
    public KickIn() {
    	requires(Robot.head);
    }

    protected void initialize() {
    	x = true;
    }

    protected void execute() {
    	Robot.head.kickIn();
    }

    protected boolean isFinished() {
        return x;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
