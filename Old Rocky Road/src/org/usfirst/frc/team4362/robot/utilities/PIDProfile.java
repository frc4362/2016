package org.usfirst.frc.team4362.robot.utilities;

import edu.wpi.first.wpilibj.CANTalon;

public class PIDProfile {
	
	public double kP, kI, kD, kF;
	
	public PIDProfile(double p, double i, double d, double f){
		kP = p;
		kI = i;
		kD = d;
		kF = f;
	}

	public void apply(CANTalon talon){
		talon.setP(kP);
		talon.setI(kI);
		talon.setD(kD);
		talon.setF(kF);
	}
}
