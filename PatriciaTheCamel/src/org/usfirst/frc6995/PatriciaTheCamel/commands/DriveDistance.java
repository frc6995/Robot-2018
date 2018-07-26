package org.usfirst.frc6995.PatriciaTheCamel.commands;


import org.usfirst.frc6995.PatriciaTheCamel.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {

    public DriveDistance(double driveDist) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivebase);
    	//double distance = driveDist;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivebase.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivebase.arcadeDrive(0.5, 0, 0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.drivebase.CountsToDistance(Robot.drivebase.getEncoderCount()) == 120);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivebase.arcadeDrive(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
