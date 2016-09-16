package org.usfirst.frc.team4362.robot.subsystems;

import org.usfirst.frc.team4362.robot.commands.ClimbExtendListener;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	public CANTalon climbMotor1 = new CANTalon(27);
	public CANTalon climbMotor2 = new CANTalon(13);

	/*public void set(double speed){
		climbMotor1.set(speed);
		climbMotor2.set(speed);
	}*/

    public void initDefaultCommand() {
    	setDefaultCommand(new ClimbExtendListener());
    }
}
