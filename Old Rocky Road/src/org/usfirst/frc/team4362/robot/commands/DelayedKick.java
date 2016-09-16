package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DelayedKick extends Command {

	long delay, startTime, endTime;
	
    public DelayedKick(long delay) {
    	this.delay = delay;
    }

    protected void initialize() {
    	this.startTime = System.currentTimeMillis();
    	this.endTime = startTime + delay;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return System.currentTimeMillis() > endTime;
    }

    protected void end() {
    	Robot.head.kickIn();
    }

    protected void interrupted() {
    }
}
