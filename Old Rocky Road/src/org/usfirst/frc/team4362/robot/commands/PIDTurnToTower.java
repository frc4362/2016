package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;
import org.usfirst.frc.team4362.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

public class PIDTurnToTower extends Command {

	DriveTrain driveTrain = Robot.driveTrain;
	CANTalon left1 = driveTrain.Left.getMotor1(),
			 left2 = driveTrain.Left.getMotor2(),
			 right1 = driveTrain.Right.getMotor1(),
			 right2 = driveTrain.Right.getMotor2();
	
    public PIDTurnToTower() {
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
