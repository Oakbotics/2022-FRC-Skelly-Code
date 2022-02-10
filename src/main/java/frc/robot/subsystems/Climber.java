package frc.robot.subsystems;



import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ClimbConstants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Climber extends SubsystemBase{

    //private static final int leadDeviceID = 1;
    //private static final int followDeviceID = 2;
    private static final int kJoystickPort = 0;

    //private CANSparkMax m_leadMotor;
    //private CANSparkMax m_followMotor;
    private Joystick m_joystick;
    
    CANSparkMax rightClimber = new CANSparkMax(Constants.ClimbConstants.CAN_ADDRESS_CLIMB_RIGHT, MotorType.kBrushless);    
    CANSparkMax leftClimber = new CANSparkMax(Constants.ClimbConstants.CAN_ADDRESS_CLIMB_LEFT, MotorType.kBrushless);
    
    public void run(double speed) {

        leftClimber.restoreFactoryDefaults();
        rightClimber.follow(leftClimber);
        m_joystick = new Joystick(kJoystickPort);
        
        leftClimber.set(speed);

    }

}
