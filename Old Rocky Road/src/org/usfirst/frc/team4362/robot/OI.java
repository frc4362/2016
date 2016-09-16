package org.usfirst.frc.team4362.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4362.robot.commands.AimDown;
import org.usfirst.frc.team4362.robot.commands.AimUp;
import org.usfirst.frc.team4362.robot.commands.ArmDown;
import org.usfirst.frc.team4362.robot.commands.ArmUp;
import org.usfirst.frc.team4362.robot.commands.ClimbExtend;
import org.usfirst.frc.team4362.robot.commands.ClimbRetract;
import org.usfirst.frc.team4362.robot.commands.KickIn;
import org.usfirst.frc.team4362.robot.commands.KickOut;
import org.usfirst.frc.team4362.robot.commands.ShiftDown;
import org.usfirst.frc.team4362.robot.commands.ShiftUp;
import org.usfirst.frc.team4362.robot.commands.Shoot;
import org.usfirst.frc.team4362.robot.commands.SwitchCamera;
import org.usfirst.frc.team4362.robot.commands.TimedShoot;
import org.usfirst.frc.team4362.robot.commands.TurnToStart;
import org.usfirst.frc.team4362.robot.commands.auton.CorrectAndShoot;
import org.usfirst.frc.team4362.robot.commands.auton.DelayedShoot;

@SuppressWarnings("unused")
public class OI {

	public Joystick leftStick;
	public Joystick rightStick;
	public Joystick controller;

	public Button shiftUpButton;
	public Button shiftDownButton;

	public Button aimUpButton;
	public Button aimDownButton;

	public Button slideUpButton;
	public Button slideDownButton;

	public Button kickButton;

	public Button armButton;

	public Button extendClimbButton;
	public Button retractClimbButton;

	public Button highGoalShotButton;
	public Button lowGoalShotButton;

	public Button aimBotButton;

	public Button switchCameraButton;

	public OI(){
		leftStick = new Joystick(RobotMap.Joysticks.left);
		rightStick = new Joystick(RobotMap.Joysticks.right);
		controller = new Joystick(RobotMap.Joysticks.controller);

		// bottom left on the right stick
		shiftUpButton = new JoystickButton(rightStick, 1);
		shiftDownButton = new JoystickButton(rightStick, 2);

		aimUpButton = new JoystickButton(controller, RobotMap.ControllerButton.RT);
		aimDownButton = new JoystickButton(controller, RobotMap.ControllerButton.LT);

		kickButton = new JoystickButton(controller, RobotMap.ControllerButton.A);

		armButton = new JoystickButton(controller, RobotMap.ControllerButton.Y);

		retractClimbButton = new JoystickButton(controller, RobotMap.ControllerButton.B);
		extendClimbButton = new JoystickButton(controller, RobotMap.ControllerButton.X);

		highGoalShotButton = new JoystickButton(controller, RobotMap.ControllerButton.R3);
		lowGoalShotButton = new JoystickButton(controller, RobotMap.ControllerButton.L3);

		switchCameraButton = new JoystickButton(controller, RobotMap.ControllerButton.START);

		aimBotButton = new JoystickButton(controller, 8);

		shiftUpButton.whenPressed(new ShiftUp());
		shiftDownButton.whenPressed(new ShiftDown());

		aimUpButton.whenPressed(new AimUp());
		aimDownButton.whenPressed(new AimDown());

		kickButton.whenPressed(new KickOut());
		kickButton.whenReleased(new KickIn());

		armButton.whenPressed(new ArmUp());
		armButton.whenReleased(new ArmDown());

		retractClimbButton.whenPressed(new ClimbRetract());
		//extendClimbButton.whenPressed(new ClimbExtend());

		aimBotButton.whenPressed(new CorrectAndShoot());

		highGoalShotButton.whenPressed(new DelayedShoot(1000, 11000));
		lowGoalShotButton.whenPressed(new DelayedShoot(500, 5000));
	}
}
