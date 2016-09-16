package org.usfirst.frc.team4362.robot.auton;

import org.usfirst.frc.team4362.robot.RobotMap;
import org.usfirst.frc.team4362.robot.commands.AimUp;
import org.usfirst.frc.team4362.robot.commands.KickIn;
import org.usfirst.frc.team4362.robot.commands.TimedShoot;
import org.usfirst.frc.team4362.robot.commands.auton.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auton_SpyBox extends CommandGroup {
    
    public Auton_SpyBox(int delay) {
    	
    	addSequential(new AimUp());
    	
    	addSequential(new TimedShoot(delay));
    	
    	addSequential(new Wait(1000));
    	
    	addSequential(new KickIn());
    	
    	addSequential(new Wait(1000));
    	
    }
    
    public Auton_SpyBox() {
    	this(RobotMap.Auton.shootDelay);
    }
}
