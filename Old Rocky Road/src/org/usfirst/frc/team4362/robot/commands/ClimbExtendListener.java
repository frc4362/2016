package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;
import org.usfirst.frc.team4362.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbExtendListener extends Command {

    public ClimbExtendListener() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(Robot.oi.controller.getRawButton(RobotMap.ControllerButton.X)
    		&& Robot.oi.controller.getRawButton(RobotMap.ControllerButton.SELECT)){
    		new ClimbExtend().start();
    		this.cancel();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
