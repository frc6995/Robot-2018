package org.usfirst.frc.team6995.robot.subsystems;

import org.usfirst.frc.team6995.robot.RobotMap;
import org.usfirst.frc.team6995.robot.commands.DrivingCom;
import org.usfirst.frc.team6995.robot.definitions.Ramp;
import org.usfirst.frc.team6995.robot.definitions.Range;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveMotorsSub extends Subsystem {

    Talon driveMotorRight = null;
    Talon driveMotorLeft = null;
    
    PIDController drivePIDRight = null;
    PIDController drivePIDLeft = null;
    
    Encoder driveEncoderRight = null;
    Encoder driveEncoderLeft = null;
    
    public DriveMotorsSub() {
    	driveMotorRight = new Talon(RobotMap.RIGHT_DRIVE_MOTOR);
    	driveMotorLeft = new Talon(RobotMap.LEFT_DRIVE_MOTOR);
    }
	
    public void arcadeDrive(double moveSpeed, double rotSpeed) {
    	
    	double drive = Range.clip(Ramp.ramp(moveSpeed, 1, 1), -1, 1);
    	double rot = Range.clip(Ramp.ramp(rotSpeed, 1, 1), -1, 1);
    	
    	driveMotorRight.set(drive+rot);
    	driveMotorLeft.set(-drive+rot);
    }
    public void tankDrive(double moveSpeedRight, double moveSpeedLeft) {
    	
    	double driveR = Range.clip(Ramp.ramp(moveSpeedRight, 1,1), -1, 1);
    	double driveL = Range.clip(Ramp.ramp(moveSpeedLeft, 1,1), -1, 1);
    	
    	driveMotorRight.set(driveR);
    	driveMotorLeft.set(driveL);
    }

    public void encoderInit() {
    	driveEncoderRight.setMaxPeriod(1);
    	driveEncoderLeft.setMaxPeriod(1);
    	
    	driveEncoderRight.setMinRate(10);
    	driveEncoderLeft.setMinRate(10);
    	
    	driveEncoderRight.setDistancePerPulse(10.71); //set according to gear ratio.
    	driveEncoderLeft.setDistancePerPulse(10.71);
    	
    	driveEncoderRight.setReverseDirection(false);
    	driveEncoderLeft.setReverseDirection(true);
    	
    	driveEncoderRight.setSamplesToAverage(4);
    	driveEncoderLeft.setSamplesToAverage(4);
    }

    public void encoderCreate() {
    	driveEncoderRight = new Encoder(0,1,false,Encoder.EncodingType.k4X);
    	driveEncoderLeft = new Encoder(2,3,false,Encoder.EncodingType.k4X);
    }
    
    public void motorInit() {
    	boolean init = false;
    	double speed = 0;
    	double time = System.currentTimeMillis();
    	while (!init) {
			if (drivePIDRight.getError() < 10 || drivePIDLeft.getError() < 10) {
				speed = speed + 0.002;
				driveMotorLeft.set(speed);
				driveMotorRight.set(speed);
			}
			else if (drivePIDLeft.getError() >= 10 && drivePIDRight.getError() >= 10) {
				speed = 0;
				init = true;
			}
			
			if (System.currentTimeMillis()-time == 4000) {
				System.out.print("Unable to find exact location of motor, resetting encoders to aproximate position.");
				break;
			}
		}
    	driveEncoderLeft.reset();
    	driveEncoderRight.reset();
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new DrivingCom());
    }
}

