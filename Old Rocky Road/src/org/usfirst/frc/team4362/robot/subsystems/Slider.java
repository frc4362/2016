package org.usfirst.frc.team4362.robot.subsystems;

import org.usfirst.frc.team4362.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Slider extends Subsystem {
    
	DoubleSolenoid arm = new DoubleSolenoid(RobotMap.Solenoid.slider[0],
											RobotMap.Solenoid.slider[1]);
	
    public void initDefaultCommand() {
    }
    
    public void up(){
    	this.arm.set(DoubleSolenoid.Value.kForward);
    }
    
    public void down(){
    	this.arm.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void toggle(){
    	if(this.arm.get().equals(DoubleSolenoid.Value.kForward)){
    		down();
    	}else{
    		up();
    	}
    }
}

