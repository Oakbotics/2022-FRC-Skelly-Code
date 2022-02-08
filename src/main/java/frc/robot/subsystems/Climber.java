package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ClimbConstants;

import com.revrobotics.CANSparkMax.IdleMode;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Climber extends SubsystemBase{
    
    CANSparkMax rightClimber = new CANSparkMax(Constants.ClimbConstants.CAN_ADDRESS_CLIMB_RIGHT, MotorType.kBrushless);    
    CANSparkMax leftClimber = new CANSparkMax(Constants.ClimbConstants.CAN_ADDRESS_CLIMB_LEFT, MotorType.kBrushless);

    public Climber(){
        super();
        
        leftClimber.setInverted(true);

        rightClimber.follow(leftClimber);
        
    }
}
