package org.usfirst.frc.team4362.robot.commands.auton;

import org.usfirst.frc.team4362.robot.commands.KickIn;
import org.usfirst.frc.team4362.robot.commands.TimedShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DelayedShoot extends CommandGroup {
    
    public  DelayedShoot(int delay, int RPM) {
        
    	addSequential(new TimedShoot(delay, RPM));
    	
    	addSequential(new Wait(500));
    	
    	addSequential(new KickIn());
    	
    }
}
