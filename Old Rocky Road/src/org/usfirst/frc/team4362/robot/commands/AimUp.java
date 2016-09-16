package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AimUp extends Command {

	boolean x;
	
    public AimUp() {
    	requires(Robot.head);
    }

    protected void initialize() {
    	x = true;
    }

    protected void execute() {
    	//Robot.light.relay.set(Value.kReverse);
    	Robot.head.aimUp();
    }

    protected boolean isFinished() {
        return x;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
