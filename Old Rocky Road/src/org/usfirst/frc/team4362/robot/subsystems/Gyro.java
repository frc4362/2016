package org.usfirst.frc.team4362.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyro extends Subsystem {
    
    public ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    public void initDefaultCommand() {
    }

    public double getRawAngle(){
    	return this.gyro.getAngle();
    }

    /**
     * A normalized angle method
     * @return the raw angle % 360
     */
    public double getAngle(){
    	return this.gyro.getAngle() % 360;
    }

    public void calibrate(){
    	this.gyro.calibrate();
    }
    
    public void reset(){
    	this.gyro.reset();
    }
    
}
