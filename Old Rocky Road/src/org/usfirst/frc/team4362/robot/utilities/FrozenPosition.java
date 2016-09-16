package org.usfirst.frc.team4362.robot.utilities;

public class FrozenPosition {

	double angle;
	
	long lastCensorTimestamp;
	
	float altitude, barometricPressure, compassHeading, 
		displacementX, displacementY, displacementZ,
		fusedHeading, pitch, pressure, quaternionW, 
		quaternionX, quaternionY, quaternionZ, rawAccelX,
		rawAccelY, rawAccelZ, rawGyroX, rawGyroY, rawGyroZ, 
		rawMagX, rawMagY, rawMagZ, roll, tempC, velocityX, 
		velocityY, velocityZ, worldLinearAccelX, worldLinearAccelY,
		worldLinearAccelZ, yaw;
	
	public FrozenPosition(GemMXP nav) {
		//nav.
	}
	
}
