package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetGyro extends Command {

    public ResetGyro() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.gyro.reset();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
