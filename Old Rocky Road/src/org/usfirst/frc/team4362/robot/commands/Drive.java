package org.usfirst.frc.team4362.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4362.robot.Robot;

/**
 *
 */
public class Drive extends Command {

    public Drive() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    	Robot.driveTrain.compressor.start();
    }

    protected void execute() {
    	Robot.driveTrain.sanitizedDrive(Robot.oi.leftStick.getY(), Robot.oi.rightStick.getY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
