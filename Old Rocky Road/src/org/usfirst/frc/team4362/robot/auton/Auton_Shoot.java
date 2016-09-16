package org.usfirst.frc.team4362.robot.auton;

import org.usfirst.frc.team4362.robot.commands.AimUp;
import org.usfirst.frc.team4362.robot.commands.KickIn;
import org.usfirst.frc.team4362.robot.commands.TimedShoot;
import org.usfirst.frc.team4362.robot.commands.auton.AimAtHighGoal;
import org.usfirst.frc.team4362.robot.commands.auton.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auton_Shoot extends CommandGroup {
    
    public Auton_Shoot(int delay, boolean find) {

    	addSequential(new AimUp());
    	
    	if(find){
        	addSequential(new AimAtHighGoal());
    	}
    	
    	addSequential(new Wait(1000));
    	
    	addSequential(new TimedShoot(delay));
    	
    	addSequential(new Wait(1000));
    	
    	addSequential(new KickIn());
    	
    }
}
