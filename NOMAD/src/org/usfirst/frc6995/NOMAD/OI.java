package org.usfirst.frc6995.NOMAD;

import org.usfirst.frc6995.NOMAD.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//Declaring controllers
    public Joystick joystick;

    public OI() {
    	//creating joystick
        joystick = new Joystick(0);
        
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DriveCom: power", new DriveCom());
    }

    //Function to get the joystick
    public Joystick getJoystick() {
        return joystick;
    }
}

