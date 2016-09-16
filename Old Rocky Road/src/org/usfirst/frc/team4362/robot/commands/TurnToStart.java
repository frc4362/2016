package org.usfirst.frc.team4362.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnToStart extends CommandGroup {
    
    public TurnToStart() {
        
    	addSequential(new AbsoluteTurn(15));
    	
    }
}
