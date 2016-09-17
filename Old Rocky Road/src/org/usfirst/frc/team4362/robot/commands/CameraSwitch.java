package org.usfirst.frc.team4362.robot.commands; 

import com.ni.vision.NIVision; 
import com.ni.vision.NIVision.Image; 
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command; 
 
 
public class CameraSwitch extends Command {

 	private final int camChase;
 	private int curCam;
 	private Image frame;
 	private CameraServer server;
 	
 	public CameraSwitch() {
 		camChase = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
 	}
 	
 	public void initialize() {
        curCam = camChase;
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        
        server = CameraServer.getInstance();
        server.setQuality(50);
 		NIVision.IMAQdxStopAcquisition(curCam);
		NIVision.IMAQdxConfigureGrab(curCam);
		NIVision.IMAQdxStartAcquisition(curCam);
 	}
 	
 	public void execute() {
 		updateCam();
 	}
 	
	public void end() { 
		NIVision.IMAQdxStopAcquisition(curCam); 
	}

	public void updateCam() {
		NIVision.IMAQdxGrab(curCam, frame, 1);
	    server.setImage(frame);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void interrupted() {
	}
}

