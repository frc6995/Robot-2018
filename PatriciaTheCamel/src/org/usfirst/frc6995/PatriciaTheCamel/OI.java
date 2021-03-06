// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6995.PatriciaTheCamel;

import org.usfirst.frc6995.PatriciaTheCamel.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//100th commit ;)
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    
    public JoystickButton grab1;
    public JoystickButton release2;
    //public JoystickButton rotatorIn3;
    public JoystickButton intakeIn4;
    //public JoystickButton rotatorOut5;
    public JoystickButton intakeOut6;
    //public JoystickButton lifterSwitchStack7;
    //public JoystickButton lifterTurboCombo8;
    public JoystickButton lifterTurboCombo9;
    public JoystickButton lifterTurboCombo10;
    public JoystickButton lifterDown11;
    public JoystickButton lifterUp12;
    public Joystick joystick;
    public LifterComPercentage lifterComPercentage;
    
    /*class RiserButtonMonitor implements RiserReqMonitor {

    	final Joystick joystick;
    	final int upButton;
    	final int dnButton;
    	final int inButton;
    	final int outButton;
    	final int zeroButton;
    	
    	RiserButtonMonitor(Joystick joystick, int upButton, int dnButton, int inButton, int outButton, int zeroButton) {
    		this.joystick = joystick;
    		this.upButton = upButton;
    		this.dnButton = dnButton;
    		this.inButton = inButton;
    		this.outButton = outButton;
    		this.zeroButton = zeroButton;
    	}
    	
		@Override
		public int riserRequest() {
			
			if ( true ) {
				//System.out.println("riserRequest");
				boolean riserUp = this.joystick.getRawButton(this.upButton);
				boolean riserDn = this.joystick.getRawButton(this.dnButton);
				
				if (riserUp && !riserDn) {
					System.out.println("lifterUp");
					return 1;
					
				}
				else if ( ! riserUp && riserDn) {
					System.out.println("lifterDown");
					return -1;
				}
			}
			
			return 0;
		}
		//REMOVED CODE BELOW BECAUSE IT INVOLVED Rotator

		@Override
		public boolean rotatorConveyorStopZero() {
			return this.joystick.getRawButtonReleased(this.zeroButton);
			
		}
		
		@Override
		public int rotatorMoveRequest() {
			return 0;
		}

		@Override
		public boolean isClimbing() {
			if (joystick.getRawButton(9)) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public double powerIncrement(double prevPower) { // cycles between 1/4,1/3,1/2.
			double prevpowerRecip = 1.0 / prevPower;
			double newPowerRecip;
			
			if (prevpowerRecip == 2) { 
				newPowerRecip = 4;
			} else {
				newPowerRecip = prevpowerRecip - 1;
			}
			
			return 1.0 / newPowerRecip;
			
		}
    	
    }*/

    public OI() {

        joystick = new Joystick(0);

    	//LifterManual lifterManual = new LifterManual(new RiserButtonMonitor(joystick, 5, 3));
    	lifterComPercentage= new LifterComPercentage();
        //lifterComPercentage = new LifterComPercentage(new RiserButtonMonitor(joystick, 12, 11, 3, 5, 7));
    	
        lifterUp12 = new JoystickButton(joystick, 12);
        lifterUp12.whenPressed(lifterComPercentage);
        lifterDown11 = new JoystickButton(joystick, 11); // This 
        lifterDown11.whenPressed(lifterComPercentage);
        lifterTurboCombo10 = new JoystickButton(joystick, 10);
        //lifterConveyorGrab10.whenPressed(new LifterConveyorGrab());
        lifterTurboCombo9 = new JoystickButton(joystick, 9);
        //lifterFenceClear9.whenPressed(new LifterFenceClear());
        //lifterTurboCombo8 = new JoystickButton(joystick, 8);
        //lifterScale8.whenPressed(new LifterScale());
        //lifterSwitchStack7 = new JoystickButton(joystick, 7);
        //lifterSwitchStack7.whenPressed(new LifterSwitchStack());
        //rotatorOut5 = new JoystickButton(joystick, 5);
        //rotatorOut5.whileHeld(lifterComPercentage);
        //rotatorIn3 = new JoystickButton(joystick, 3);
        //rotatorIn3.whenPressed(lifterComPercentage);
        intakeOut6 = new JoystickButton(joystick, 6);
        intakeOut6.whileHeld(new IntakeOut());
        intakeIn4 = new JoystickButton(joystick, 4);
        intakeIn4.whileHeld(new IntakeIn());
        release2=new JoystickButton(joystick, 2);
        release2.whenPressed(new GrabRelease());
        grab1 = new JoystickButton(joystick, 1);
        grab1.whenPressed(new GrabRelease());
        

        // SmartDashboard Buttons
        SmartDashboard.putData("LIFTER_PERCENTAGE", lifterComPercentage);
        
        SmartDashboard.putData("DriveCom", new DriveCom());
        SmartDashboard.putData("GrabRelease", new GrabRelease());
        //SmartDashboard.putData("LifterReset", new LifterReset());
        //SmartDashboard.putData("LifterManual", lifterManual);
        SmartDashboard.putData("LifterManual", lifterComPercentage);
        
        //SmartDashboard.putData("LifterSwitchStack", new LifterSwitchStack());
        //SmartDashboard.putData("LifterScale", new LifterScale());
        //SmartDashboard.putData("LifterFenceClear", new LifterFenceClear());
        //SmartDashboard.putData("LifterConveyorGrab", new LifterConveyorGrab());
        //SmartDashboard.putData("LifterGroundGrab", new LifterGroundGrab());

    }

    public Joystick getJoystick() {
        return joystick;
    }
}

