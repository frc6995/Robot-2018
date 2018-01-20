package org.usfirst.frc6995.NOMAD.subsystems;

import org.usfirst.frc6995.NOMAD.RobotMap;
import org.usfirst.frc6995.NOMAD.commands.grabberCom;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class CubeGrabber extends Subsystem {

	//Adding the double solenoid
	DoubleSolenoid cubeGrabber = RobotMap.CUBE_GRABBER;

    public void initDefaultCommand() {
        //Setting the default command to send info to, to grabberCom
        setDefaultCommand(new grabberCom());
    }
    
    //Creating method to open the Cylinder
    public void openCylinder() {
    	cubeGrabber.set(Value.kForward);
    }
    //Creating method to close the Cylinder
    public void closeCylinder() {
    	cubeGrabber.set(Value.kReverse);
    }
}
