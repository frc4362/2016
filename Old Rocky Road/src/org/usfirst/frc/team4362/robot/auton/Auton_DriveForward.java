package org.usfirst.frc.team4362.robot.auton;

import org.usfirst.frc.team4362.robot.commands.AimDown;
import org.usfirst.frc.team4362.robot.commands.AimUp;
import org.usfirst.frc.team4362.robot.commands.auton.DriveDistance;
import org.usfirst.frc.team4362.robot.commands.auton.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auton_DriveForward extends CommandGroup {

    public Auton_DriveForward(int distance, boolean raise){

    	if(raise){
    		addSequential(new AimUp());
    	}else{
    		addSequential(new AimDown());
    	}

    	addSequential(new Wait(1000));

    	addSequential(new DriveDistance(distance, 1.0));

    	addSequential(new Wait(1000));
    }
    
}
