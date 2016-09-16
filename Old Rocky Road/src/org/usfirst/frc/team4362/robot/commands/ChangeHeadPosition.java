package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ChangeHeadPosition extends Command {

	boolean startingPosition;
	
    public ChangeHeadPosition() {
    	requires(Robot.head);
    }

    protected void initialize() {
    }

    protected void execute() {
    	startingPosition = Robot.head.aimedUp;
    	Robot.head.toggleAim();
    }

    protected boolean isFinished() {
        return Robot.head.aimedUp != startingPosition;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
