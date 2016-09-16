package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftUp extends Command {

	boolean startValue;
	
    public ShiftUp() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.shiftUp();
    }

    protected boolean isFinished() {
        return Robot.driveTrain.shiftedUp;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
