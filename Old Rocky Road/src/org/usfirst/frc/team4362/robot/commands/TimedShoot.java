package org.usfirst.frc.team4362.robot.commands;

import org.usfirst.frc.team4362.robot.Robot;
import org.usfirst.frc.team4362.robot.subsystems.Head;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

public class TimedShoot extends Command {

	int RPM;
	long delay, startTime, endTime;
	boolean kicked;
	
	Head head = Robot.head;
	CANTalon talon1 = head.shooter1,
			 talon2 = head.shooter2,
			 intake = head.intake;

    public TimedShoot(long delay, int RPM) {
    	requires(Robot.head);
    	this.delay = delay + 334;
    	this.RPM = RPM;
    }
    
    public TimedShoot(long delay) {
    	this(delay, 11000);
    }

    protected void initialize() {
    	this.startTime = System.currentTimeMillis();
    	this.endTime = startTime + delay;
    	
    	talon2.changeControlMode(TalonControlMode.Speed);
		talon2.set(0);
		talon2.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        talon2.reverseSensor(true);
        talon2.configEncoderCodesPerRev(4096);
        talon1.changeControlMode(TalonControlMode.Speed);
		talon1.set(0);
		talon1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        talon1.reverseSensor(true);
        talon1.configEncoderCodesPerRev(4096);
        talon1.setInverted(true);
        
        talon1.setP(0.08);
        talon1.setI(0);
        talon1.setD(0);
        talon1.setF(0.014); 
        
        talon2.setP(0.08);
        talon2.setI(0);
        talon2.setD(0);
        talon2.setF(0.014);
    }

    protected void execute() {
    	talon1.set(RPM);
    	talon2.set(RPM);
    	intake.set(-1.0);
    	if(System.currentTimeMillis() >= (endTime - 334)){
    		head.kickOut();
    	}
    }

    protected boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
