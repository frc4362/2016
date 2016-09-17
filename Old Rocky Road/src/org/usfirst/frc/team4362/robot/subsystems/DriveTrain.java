package org.usfirst.frc.team4362.robot.subsystems;

import org.usfirst.frc.team4362.robot.Robot;
import org.usfirst.frc.team4362.robot.RobotMap;
import org.usfirst.frc.team4362.robot.commands.Drive;
import org.usfirst.frc.team4362.robot.utilities.Side;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;

public class DriveTrain extends Subsystem {
	
	public Side Left = new Side(RobotMap.CANTalon.left, RobotMap.Encoder.left, false, "Left"),
				Right = new Side(RobotMap.CANTalon.right, RobotMap.Encoder.right, true, "Right");
	
	public Compressor compressor = new Compressor();
	public DoubleSolenoid shifter = new DoubleSolenoid(RobotMap.Solenoid.shifter[0], 
													   RobotMap.Solenoid.shifter[1]);
	public AnalogInput pressureSensor = new AnalogInput(0);
	
	public boolean shiftedUp;

    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
    
    public void tankDrive(double left, double right){
    	Left.drive(left);
    	Right.drive(right);
    }
    
    public double sanitized(double input){
    	return Math.abs(input) > RobotMap.Joysticks.threshold ? input : 0.0;
    }
    
    public void sanitizedDrive(double left, double right){
    	tankDrive(sanitized(left), sanitized(right));
    }

    public void shiftUp(){
    	shifter.set(DoubleSolenoid.Value.kReverse);
    	shiftedUp = true;
    }

    public void shiftDown(){
    	shifter.set(DoubleSolenoid.Value.kForward);
    	shiftedUp = false;
    }

    public void toggleShift(){
    	if(shiftedUp){
    		shiftDown();
    	}else{
    		shiftUp();
    	}
    }
    
    public void stopMovement(){
    	Robot.driveTrain.tankDrive(0.0, 0.0);
    }
    
    public double toPSI(double input){
    	return 250.0 * (input / 5.0) - 25.0;
    }
    
    public double getPressure(){
    	return toPSI(pressureSensor.getVoltage());
    }
}