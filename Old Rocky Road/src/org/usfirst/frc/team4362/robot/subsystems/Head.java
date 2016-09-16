package org.usfirst.frc.team4362.robot.subsystems;

import org.usfirst.frc.team4362.robot.Robot;
import org.usfirst.frc.team4362.robot.RobotMap;
import org.usfirst.frc.team4362.robot.commands.Shoot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Head extends Subsystem {

	DoubleSolenoid lift = new DoubleSolenoid(RobotMap.Solenoid.lifter[0],
											 RobotMap.Solenoid.lifter[1]),
				   kicker = new DoubleSolenoid(RobotMap.Solenoid.kicker[0],
				   							   RobotMap.Solenoid.kicker[1]);
	
	public CANTalon shooter1 = new CANTalon(RobotMap.CANTalon.shooter[0]),
					shooter2 = new CANTalon(RobotMap.CANTalon.shooter[1]),
					intake   = new CANTalon(RobotMap.CANTalon.intake);
	
	public boolean aimedUp;

	public int shootingSpeed = 11000;

    public void initDefaultCommand() {
    	setDefaultCommand(new Shoot());
    }

    public void aimUp(){
    	this.lift.set(DoubleSolenoid.Value.kForward);
    	Robot.light.setTRIGGERED(true);
    	Robot.rearCam = true;
    	aimedUp = true;
    }

    public void aimDown(){
    	this.lift.set(DoubleSolenoid.Value.kReverse);
    	Robot.light.setTRIGGERED(false);
    	Robot.rearCam = false;
    	aimedUp = false;
    }

    public void toggleAim(){
    	if(aimedUp){
    		aimDown();
    	}else{
    		aimUp();
    	}
    }
    
    public void setShooter(int speed){
    	shooter1.set(speed);
    	shooter2.set(-speed);
    }
    
    public void setSanitizedShooter(int input){
    	double newInput = Math.min(input, RobotMap.maxShootSpeed);
    	shooter1.set(newInput);
    	shooter2.set(-newInput);
    }
    
    public void toggleKick(){
    	if(kicker.get().equals(DoubleSolenoid.Value.kReverse)){
    		kickIn();
    	}else{
    		kickOut();
    	}
    }
    
    public void kickOut(){
    	kicker.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void kickIn(){
    	kicker.set(DoubleSolenoid.Value.kForward);
    }
}
