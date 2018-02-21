package org.usfirst.frc6995.PatriciaTheCamel.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6995.PatriciaTheCamel.Robot;
import org.usfirst.frc6995.PatriciaTheCamel.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

/**
 *
 */
public class LifterComPercentage extends Command {
	
	private RiserReqMonitor riserReq;
	static int destAngleEnc;
	int cycles = 50;
	
	public LifterComPercentage(RiserReqMonitor riserReqMonitor) {
		this.riserReq = riserReqMonitor;
		this.setInterruptible(false);
		requires(Robot.lifter);
	}
	
    private LifterComPercentage() {
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	final int currAngleEnc = RobotMap.lifterLifterRotatorMotor.getSensorCollection().getQuadraturePosition();
    	
		int rotatorAdjustDirection = Math.max(-1, Math.min(this.riserReq.rotatorZeroAdjustRequest(), 1)) * -5;
		//System.out.print("LifterComPercentage: rotatorAdjustDirection = ");
		//System.out.print(currAngleEnc);
		//System.out.print(" by ");
		//System.out.println(rotatorAdjustDirection);
		if (0 != rotatorAdjustDirection) {
			RobotMap.lifterLifterRotatorMotor.getSensorCollection().setQuadraturePosition(currAngleEnc - rotatorAdjustDirection, 10);	
		}
		
    	int riserDirection = this.riserReq.riserRequest();
    	
    	if (riserDirection > 0) {
        	RobotMap.lifterLifterMotorA.set(ControlMode.PercentOutput, 1.0/3);
		} else if (riserDirection < 0) {
        	RobotMap.lifterLifterMotorA.set(ControlMode.PercentOutput, -0.125);
		} else {
        	RobotMap.lifterLifterMotorA.set(ControlMode.PercentOutput, 0);
		}
    	
    	RobotMap.lifterLifterRotatorMotor.set(ControlMode.MotionMagic, destAngleEnc);
    	if (cycles == 0) {
    		System.out.println(RobotMap.lifterLifterMotorA.getSensorCollection().getQuadraturePosition());
    		cycles = 50;
    	}
    	cycles -= 1;
    	

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
    
    public static void setAngle(double Angle) {
    	destAngleEnc = (int) ((4096/360) * Angle);
    }
}