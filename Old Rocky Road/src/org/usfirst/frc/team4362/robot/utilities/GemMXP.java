package org.usfirst.frc.team4362.robot.utilities;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI.Port;

public class GemMXP extends AHRS {

	public GemMXP(Port spi_port_id) {
		super(spi_port_id);
	}

	
	
}
