package org.usfirst.frc.team4362.robot.commands.auton;

import org.usfirst.frc.team4362.robot.commands.TimedShoot;
import org.usfirst.frc.team4362.robot.utilities.GRIPOutput;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Won't shoot if you're not looking at the tower
 */
public class SafeTimedShot extends TimedShoot {

	boolean run;
	
    public SafeTimedShot(long delay, int RPM) {
        super(delay, RPM);
    }

    protected void initialize() {
    	SmartDashboard.putBoolean("has tried to shoot", true);
    	super.initialize();
    	double[] shootValues = GRIPOutput.getInstance().getTable().getNumberArray("centerX", new double[]{});
    	run = shootValues.length > 0;
    	SmartDashboard.putBoolean("should shoot", run);
    }

    protected void execute() {
    	if(run){
    		super.execute();
    	}
    }

    protected boolean isFinished() {
        return super.isFinished() || !run;
    }
    
	public static String arrayToString(double[] shootValues){
		StringBuilder ret = new StringBuilder();
		ret.append('[');

		if(shootValues.length == 0){
			return "[]";
		}

		for(double elem : shootValues){
			ret.append(String.valueOf(elem));
			ret.append(", ");
		}

		ret.deleteCharAt(ret.length() - 1);
		ret.deleteCharAt(ret.length() - 1);
		ret.append(']');
		
		return ret.toString();
	}
	
}
