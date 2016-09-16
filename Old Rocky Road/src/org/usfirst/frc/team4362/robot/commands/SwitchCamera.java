package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchCamera extends Command {

    public SwitchCamera() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.rearCam = !Robot.rearCam;
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
