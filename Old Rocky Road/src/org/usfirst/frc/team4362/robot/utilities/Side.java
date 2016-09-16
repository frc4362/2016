package org.usfirst.frc.team4362.robot.utilities;

import org.usfirst.frc.team4362.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Side {

	CANTalon motor1, motor2;
	
	public Encoder encoder;
	
	boolean inverted;
	String motorName, encoderName;
	
	int multiplier;
	
	public Side(int[] motors, int[] encoders, boolean inverted, String name){
		
		this.motor1 = new CANTalon(motors[0]);
		this.motor2 = new CANTalon(motors[1]);
		
		this.encoder = new Encoder(encoders[0], encoders[1], inverted, EncodingType.k4X);
		this.encoder.setDistancePerPulse(RobotMap.distancePerPulse);
		
		if(inverted){
			motor1.setInverted(true);
			motor2.setInverted(true);
		}
		
		this.inverted = inverted;
		this.motorName = name.concat(" Motor");
		this.encoderName = name.concat(" Encoder");
	}
	
	public void drive(double value){
		SmartDashboard.putNumber(motorName, value);
		//SmartDashboard.putNumber(encoderName.concat(" Rate"), encoder.getRate());
		this.motor1.set(value);
		this.motor2.set(value);
	}
	
	public CANTalon getMotor1(){
		return motor1;
	}
	
	public CANTalon getMotor2(){
		return motor2;
	}
}