package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftDown extends Command {

    public ShiftDown() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.shiftDown();
    }

    protected boolean isFinished() {
        return !Robot.driveTrain.shiftedUp;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
