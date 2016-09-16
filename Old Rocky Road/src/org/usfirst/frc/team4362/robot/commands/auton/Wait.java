package org.usfirst.frc.team4362.robot.commands.auton;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command {

	int delay;

	boolean finished;

	long endTime;

    public Wait(int milliseconds) {
    	this.finished = false;
    	this.delay = milliseconds;
    }

    protected void initialize() {
    	this.endTime = System.currentTimeMillis() + (long)this.delay;
    }

    protected void execute() {
    	this.finished = System.currentTimeMillis() > endTime;
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    	Robot.driveTrain.stopMovement();
    }

    protected void interrupted() {
    }
}
