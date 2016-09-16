package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnOff extends Command {

	boolean finished;
	
    public TurnOff() {
        requires(Robot.light);
    }

    protected void initialize() {
    	finished = true;
    }

    protected void execute() {
    	Robot.light.setTRIGGERED(false);
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
