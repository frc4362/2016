package org.usfirst.frc.team4362.robot.commands.auton;

import org.usfirst.frc.team4362.robot.commands.KickIn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CorrectAndShoot extends CommandGroup {

    public CorrectAndShoot() {

    	addSequential(new AimAtHighGoal());

    	addSequential(new Wait(200));

    	addSequential(new AimAtHighGoal());

    	addSequential(new Wait(200));

    	addSequential(new AimAtHighGoal());

    	addSequential(new Wait(200));

    	addSequential(new SafeTimedShot(1000, 11000));

    	addSequential(new Wait(200));

    	addSequential(new KickIn());

    }
}
