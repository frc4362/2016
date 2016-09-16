package org.usfirst.frc.team4362.robot.auton;

import org.usfirst.frc.team4362.robot.commands.auton.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton_DoNothing extends CommandGroup {
    
    public  Auton_DoNothing() {
        
    	addSequential(new Wait(1000));
    	
    }
}
