package org.usfirst.frc.team4362.robot.subsystems;

import org.usfirst.frc.team4362.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Light extends Subsystem {
    
	public Relay relay;
	
	public Light(){
		this.relay = new Relay(RobotMap.Relay.light);
	}
	
    public void initDefaultCommand(){
    }
    
    public void trigger(){
    	this.relay.set(Value.kReverse);
    }
    
    public void unTrigger(){
    	this.relay.set(Value.kForward);
    }
    
    public void setTRIGGERED(boolean state){
    	this.relay.set(state ? Value.kReverse : Value.kForward);
    }
}

