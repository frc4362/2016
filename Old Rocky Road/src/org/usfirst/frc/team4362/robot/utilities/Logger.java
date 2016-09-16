package org.usfirst.frc.team4362.robot.utilities;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * To use this subsystem: 
 *       Smartdashboard.putNumber(String key, int value);
 * or
 *       Smartdashboard.putString(String key, String value);
 * becomes
 *       Logger.put(String key, Object value);
 *       
 * This works for all primitive data types plus strings and will not display until Logger.displayLog(); is called.
 */

public class Logger extends Subsystem {
	
	private static final Logger INSTANCE = new Logger();
	
	DecimalFormat rounder;
    Map<String, Object> data;
    
    private Logger(){
    	rounder = new DecimalFormat("#,#0.0#");
    	data = new HashMap<String, Object>();
    }
    
    public static Logger getInstance(){
    	return INSTANCE;
    }
    
    public void put(String key, Object value){
    	data.put(key, value);
    	displayLog();
    }
    
    /**
     * Updates the display for every put() value
     */
    public void displayLog(){
    	for(String key: this.data.keySet()){
    		this.display(key);
    	}
    }
    
    /**
     * Displays a single, specific value from the hashmap, since... Why not?
     * @param key The value to display
     */
    public void display(String key){
    	System.out.println(key + ": " + data.get(key));
		SmartDashboard.putString(key, data.get(key).toString());
    }
    
    public void initDefaultCommand(){
    }
}

