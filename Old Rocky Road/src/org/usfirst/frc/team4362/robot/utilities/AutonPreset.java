package org.usfirst.frc.team4362.robot.utilities;

import edu.wpi.first.wpilibj.command.Command;

public class AutonPreset {

	public String name, description;
	public Command command;
	
	public AutonPreset(String name, Command command){
		this(name, command, "No description. Yell at a programmer about this!");
	}

	public AutonPreset(String name, Command command, String description){
		
		this.name = name;
		this.command = command;
		this.description = description;
		
	}
	
}
