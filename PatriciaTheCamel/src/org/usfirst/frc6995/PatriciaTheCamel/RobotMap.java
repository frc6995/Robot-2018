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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Servo;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int JOYSTICK_X_AXIS = 0;
	public static final int JOYSTICK_Y_AXIS = 1;
	public static final int JOYSTICK_R_AXIS = 2;
	public static final int JOYSTICK_SLIDER = 3;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //public static DoubleSolenoid grabberGrabberCylinder;
    public static WPI_TalonSRX conveyorConveyorMotor;
    public static DigitalInput conveyorConveyorSwitch;
    public static Servo cameraShuttleCameraServo;
    //public static DoubleSolenoid clampPunterPunter;
    //public static DoubleSolenoid clampPunterClamp;
    public static Encoder lifterLifterEncoder;
    //public static WPI_TalonSRX lifterLifterMotorA;
    //public static WPI_TalonSRX lifterLifterMotorB;
    public static DigitalInput lifterLifterTopSwitch;
    public static DigitalInput lifterLifterBottomSwitch;
    //public static WPI_TalonSRX lifterLifterRotatorMotor;
    public static Encoder lifterLifterRotatorEncoder;
    public static WPI_TalonSRX drivebaseDriveLeft;
    public static WPI_TalonSRX drivebaseDriveRight;
    public static Encoder drivebaseLeftEncoder;
    public static Encoder drivebaseRightEncoder;
	
    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @SuppressWarnings("deprecation")
	public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        //grabberGrabberCylinder = new DoubleSolenoid(0, 0, 1);
        //LiveWindow.addActuator("Grabber", "GrabberCylinder", grabberGrabberCylinder);
        
        conveyorConveyorMotor = new WPI_TalonSRX(4);
        
        
        conveyorConveyorSwitch = new DigitalInput(0);
        LiveWindow.addSensor("Conveyor", "ConveyorSwitch", conveyorConveyorSwitch);
        
        cameraShuttleCameraServo = new Servo(0);
        LiveWindow.addActuator("CameraShuttle", "CameraServo", cameraShuttleCameraServo);
        
        //clampPunterPunter = new DoubleSolenoid(0, 2, 3);
        //LiveWindow.addActuator("ClampPunter", "Punter", clampPunterPunter);
        
        //clampPunterClamp = new DoubleSolenoid(0, 4, 5);
        //LiveWindow.addActuator("ClampPunter", "Clamp", clampPunterClamp);
        
        lifterLifterEncoder = new Encoder(1, 2, false, EncodingType.k4X);
        LiveWindow.addSensor("Lifter", "LifterEncoder", lifterLifterEncoder);
        lifterLifterEncoder.setDistancePerPulse(1.0);
        lifterLifterEncoder.setPIDSourceType(PIDSourceType.kRate);
        //lifterLifterMotorA = new WPI_TalonSRX(5);
        
        
        //lifterLifterMotorB = new WPI_TalonSRX(6);
        
        
        lifterLifterTopSwitch = new DigitalInput(3);
        LiveWindow.addSensor("Lifter", "LifterTopSwitch", lifterLifterTopSwitch);
        
        lifterLifterBottomSwitch = new DigitalInput(4);
        LiveWindow.addSensor("Lifter", "LifterBottomSwitch", lifterLifterBottomSwitch);
        
        //lifterLifterRotatorMotor = new WPI_TalonSRX(7);
        
        
        lifterLifterRotatorEncoder = new Encoder(5, 6, false, EncodingType.k4X);
        LiveWindow.addSensor("Lifter", "LifterRotatorEncoder", lifterLifterRotatorEncoder);
        lifterLifterRotatorEncoder.setDistancePerPulse(1.0);
        lifterLifterRotatorEncoder.setPIDSourceType(PIDSourceType.kRate);
        
        drivebaseDriveLeft = new WPI_TalonSRX(2);
        drivebaseLeftEncoder = new Encoder(7, 8, false, EncodingType.k4X);
        drivebaseLeftEncoder.setDistancePerPulse(1.0);
        drivebaseLeftEncoder.setPIDSourceType(PIDSourceType.kRate);
              		
        drivebaseDriveRight = new WPI_TalonSRX(3);
        drivebaseRightEncoder = new Encoder(9, 10, false, EncodingType.k4X);
        drivebaseRightEncoder.setDistancePerPulse(1.0);
        drivebaseRightEncoder.setPIDSourceType(PIDSourceType.kRate);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    //    
    }
}
