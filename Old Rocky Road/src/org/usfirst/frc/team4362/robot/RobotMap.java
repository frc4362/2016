package org.usfirst.frc.team4362.robot;

import edu.wpi.first.wpilibj.SPI.Port;

public final class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static boolean haveCam = true;
	
	public static final int waitDelay = 975;

	public static final double threshold = 0.2;

	public static final double spinUpDuration = 2.0;

	public static final int tickRate = 50;

	public static final double maxShootSpeed = 0.50;

	public static final double distancePerPulse = 0.04052181328125;

	public static final double degreesPerSecond = 217.5;

	public static final int startDistance = 140;

	public static final double maxCurrent = 40.0;

	public static final double climbExtendDist = 30720, //4096 is one turn, one turn is ~4 inches, this is 7.5
			climbRetractDist = 31744,       // 7.75 
			newClimbRetractDist = 33792 - 1024,    // 8.25
			newNewClimbRetractDist = 34816, // 8.5
			newClimbExtendDist = 30720 + 2048;

	/**
	 * 16 inch goal @ ~14 feet away is 25 pixels @ 320x240 resolution
	 * 
	 * 		16
	 * 		-- = 0.64
	 * 		25
	 */
	public static final double inchesPerPixel = 0.64;

	public static final class Encoder {
		public static final int[] left = { 0, 1 };
		public static final int[] right = { 2, 3 };
	}

	public static final class Relay {
		public static final int light = 1;
	}

	public static final class Auton {
		public static final int shootDelay = 5000,
				crossDistance = 110;
	}

	public static class CANTalon {
		public static final int[] left = { 19, 15 },
				right = { 25, 21 },
				shooter = { 17, 23 };
		public static final int[] climber = { 27, 13 };
		public static final int intake = 31;
	}

	public static class Joysticks {
		public static final int left = 0,
				right = 1,
				controller = 2;
		public static final double threshold = 0.1;
	}

	public static class Solenoid {
		public static final int[] shifter = { 2, 5 },
				kicker = { 0, 7 },
				lifter = { 1, 6 },
				slider = { 3, 4 };
	}

	public static class Calibration {
		public static final double turnSpeed = 0.2,
				targetRPM = 11000;
	}

	public static class ControllerButton {
		public static final int A = 1,
				B = 2,
				X = 3,
				Y = 4,
				LT = 5,
				RT = 6,
				START = 8,
				SELECT = 7,
				L3 = 9,
				R3 = 10;
	}
}
