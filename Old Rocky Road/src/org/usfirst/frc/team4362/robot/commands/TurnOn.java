package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnOn extends Command {

	public boolean triggered;
	
    public TurnOn() {
        requires(Robot.light);
    }

    protected void initialize() {
    	triggered = true;
    }

    protected void execute() {
    	Robot.light.setTRIGGERED(true);
    }

    protected boolean isFinished() {
        return this.triggered;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
