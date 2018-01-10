package org.usfirst.frc.team6995.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotMap;

/**
 *
 */
public class DrivingCom extends Command {

    public DrivingCom() {
    	requires(Robot.DRIVE_MOTORS_SUB);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.DRIVE_MOTORS_SUB.encoderInit();
    	Robot.DRIVE_MOTORS_SUB.encoderCreate();
    	Robot.DRIVE_MOTORS_SUB.motorInit();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double Y = Robot.CONTROLLS.driverController.getRawAxis(RobotMap.JOYSTICK_Y_AXIS);
    	double X = Robot.CONTROLLS.driverController.getRawAxis(RobotMap.JOYSTICK_X_AXIS);
    	double slow = Robot.CONTROLLS.driverController.getThrottle();
    	
    	
    	double moveSpeed = Y*slow;
    	double rotSpeed = X*slow;
    	
    	Robot.DRIVE_MOTORS_SUB.arcadeDrive(moveSpeed, rotSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DRIVE_MOTORS_SUB.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
