package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmDown extends Command {

	boolean IveGivenUpOnUsefulNames;
	
    public ArmDown() {
    	requires(Robot.slider);
    }

    protected void initialize() {
    	IveGivenUpOnUsefulNames = true;
    }

    protected void execute() {
    	Robot.slider.down();
    }

    protected boolean isFinished() {
        return IveGivenUpOnUsefulNames;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
