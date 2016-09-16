package org.usfirst.frc.team4362.robot.utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class GRIPOutput {
	
	private static GRIPOutput INSTANCE = new GRIPOutput("GRIP/myContoursReport2");

	NetworkTable table;
	Set<String> keys;
	
	private GRIPOutput(String location){
    	
		this.table = NetworkTable.getTable(location);
    	this.keys = table.getKeys();
    	
	}
	
	public static GRIPOutput getInstance(){
		return INSTANCE;
	}
	
    public void initDefaultCommand() {
    }
    
    public Object getProperty(String property){
    	return table.getValue(property, new Integer(-1));
    }
    
    public Map<String, Object> getProperties(){
    	Map<String, Object> ret = new HashMap<String, Object>();
    	
    	for (String key : keys) {
    		ret.put(key, getProperty(key));
    	}
    	
    	return ret;
    }
    
    public NetworkTable getTable(){
    	return table;
    }
}