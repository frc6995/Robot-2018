package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class AutonomousCom extends Command {
	
	String alliance;
	int station;
	
    public AutonomousCom() {
    	requires(Robot.DRIVE_MOTORS_SUB);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.DRIVE_MOTORS_SUB.motorInit();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (DriverStation.getInstance().getAlliance() == Alliance.Red) {
			alliance = "RED";
			if (DriverStation.getInstance().getLocation() == 1) {
	    		station = 1;
	    		
	    	}
			else if (DriverStation.getInstance().getLocation() == 2) {
				station = 2;
				
			}
	    	else if (DriverStation.getInstance().getLocation() == 3) {
				station = 3;
				
			}
    	}
    	else if (DriverStation.getInstance().getAlliance() == Alliance.Blue) {
			alliance = "BLUE";
			if (DriverStation.getInstance().getLocation() == 1) {
	    		station = 1;
	    		
	    	}
	    	else if (DriverStation.getInstance().getLocation() == 2) {
				station = 2;
				
			}
	    	else if (DriverStation.getInstance().getLocation() == 3) {
				station = 3;
				
	    	}
    	}
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
