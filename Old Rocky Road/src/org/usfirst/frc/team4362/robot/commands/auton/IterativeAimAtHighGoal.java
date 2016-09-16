package org.usfirst.frc.team4362.robot.commands.auton;

import org.usfirst.frc.team4362.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IterativeAimAtHighGoal extends AimAtHighGoal {

	static double endValue;
	static long waitTimeMillis = 250;
	
	long endTime;
	int turns;
	double result;
	boolean finished;

	public IterativeAimAtHighGoal(){
		turns = 0;
	}

    protected void initialize(){
    	// get the first turn
    	super.initialize();
    	// record what it is for use later
    	this.result = degrees;
    	// record if the command is finished. 
    	// It's used later the skip execute() if it's true since it logically shouldn't run again
    	this.finished = isFinishedNoInit();
    }

    protected void execute() {
    	// If it's done but the event loop hasn't recognized that yet, don't do the thing
    	if(!finished){
        	super.execute();
    	}
    }

    protected boolean isFinishedNoInit(){
    	if(super.isFinished()){
    		if(degrees == 0){
    			return true;
    		}else{
    			return false;
    		}
    	}else{
    		return false;
    	}
    }

    protected boolean isFinished() {
		endTime = System.currentTimeMillis() + waitTimeMillis;
    	SmartDashboard.putNumber("HOW FAR IT TURNS", degrees);
    	SmartDashboard.putNumber("THE ABSOLUTE VALUE OF THE TURN", super.endpoint);
    	SmartDashboard.putNumber("THIS IS HOW MANY TURNS IT'S COMPLETED", turns);
    	// if the current turn is complete
        if(super.isFinished()){
        	// if it was a zero degree turn, then we're done
        	if(degrees == 0.0){// || Robot.isAimingAtTower
        		return true;
        	// otherwise calculate another turn, to get closer to the tower
        	}else{
        		// this will instantiate every value again
        		//super.end();
        		Robot.driveTrain.stopMovement();
        		while(System.currentTimeMillis() < endTime){	};
            	this.initialize();
            	return false;
        	}
        // if it's not, just keep going
        }else{
        	return false;
        }
    }
}
