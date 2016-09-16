package org.usfirst.frc.team4362.robot.auton;

import org.usfirst.frc.team4362.robot.commands.auton.DriveTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton_Turn extends CommandGroup {
    
    public  Auton_Turn(int degrees) {
        
    	addSequential(new DriveTurn(degrees));
    	
    }
}
