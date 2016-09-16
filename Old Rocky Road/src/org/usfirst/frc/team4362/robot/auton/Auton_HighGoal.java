package org.usfirst.frc.team4362.robot.auton;

import org.usfirst.frc.team4362.robot.commands.AbsoluteTurn;
import org.usfirst.frc.team4362.robot.commands.AimDown;
import org.usfirst.frc.team4362.robot.commands.AimUp;
import org.usfirst.frc.team4362.robot.commands.KickIn;
import org.usfirst.frc.team4362.robot.commands.ResetGyro;
import org.usfirst.frc.team4362.robot.commands.auton.DriveDistance;
import org.usfirst.frc.team4362.robot.commands.auton.IterativeAimAtHighGoal;
import org.usfirst.frc.team4362.robot.commands.auton.SafeTimedShot;
import org.usfirst.frc.team4362.robot.commands.auton.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auton_HighGoal extends CommandGroup {

	static int defaultDistance = 110;

	/**
	 * Should do everything required to perform a high goal (given the correct arguments)
	 * 
	 * @param distance The distance for it to drive forwards
	 * @param degrees The degrees it should dead reckon to to cross
	 * @param lift Whether or not to lift the head after it crosses
	 */
    public Auton_HighGoal(int distance, double degrees, boolean lift) {

    	SmartDashboard.putString("path", "doing the auton");

    	addSequential(new ResetGyro());

    	addSequential(new KickIn());

    	if(lift){
    		addSequential(new AimUp());
    	}else{
    		addSequential(new AimDown());
    	}

    	//addSequential(new Wait(500));

    	if(distance > 15){
    		SmartDashboard.putString("path", "wait");
    		addSequential(new DriveDistance(10, 1.0));
    		addSequential(new DriveDistance(5, 0.25));
    		addSequential(new DriveDistance(distance - 15, 1.0));
    	}else{
    		SmartDashboard.putString("path", "just drive");
        	addSequential(new DriveDistance(distance, 1.0));
    	}

    	addSequential(new Wait(200));

    	// dead reckons
    	addSequential(new AbsoluteTurn(degrees));

    	// detect how far you need to turn to point at a high goal
    	//addSequential(new AimAtTowerHighGoal());

    	addSequential(new Wait(200));

    	addSequential(new AimUp());

    	addSequential(new Wait(200));
    	/*
    	addSequential(new AimAtTowerHighGoal());

    	addSequential(new Wait(1000));

    	addSequential(new AimAtTowerHighGoal());
		*/

    	addSequential(new IterativeAimAtHighGoal());

    	addSequential(new Wait(200));

    	addSequential(new SafeTimedShot(1000, 11000));

    	addSequential(new Wait(200));

    	addSequential(new KickIn());

    }
}
