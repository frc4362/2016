package org.usfirst.frc.team4362.robot.utilities;

import org.usfirst.frc.team4362.robot.RobotMap;

public class TowerDistanceThread implements Runnable {

	private boolean enabled = true,
			end = false;
	private volatile double degreesFromTower;
	
	public void run(){
		while(true){
			if(enabled){
				degreesFromTower = getDegreesFromTower();
			}
			
			try {
				Thread.sleep(50);
			}
			
			catch(InterruptedException e){
				System.out.println("Failure to sleep in distance thread!");
			}
			
			if (end) break;
		}
	}

	public void enable(){
		this.enabled = true;
	}
	
	public void disable(){
		this.enabled = false;
	}
	
	public void end(){
		this.end = true;
	}
	
	public double get(){
		return degreesFromTower;
	}
	
    private static double getDegreesFromTower() {
    	int x;
    	double[] xs = GRIPOutput.getInstance().getTable().getNumberArray("centerX", new double[]{});
    	if(xs.length > 0){
	    	x = (int)xs[0];
	    	if(165 < x && x < 168){
	    		x = 0;
	    	}else{
	    		x -= 160;
	    	}

	    	double d = x * RobotMap.inchesPerPixel,
	    		   theta = Math.atan(d / 168); //168

	    	// return the degrees to turn
	    	return theta * 180 / Math.PI;
    	}else{
    		return 0;
    	}
    }
}
