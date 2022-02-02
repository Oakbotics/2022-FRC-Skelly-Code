package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.IntakeConstants;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Intake extends SubsystemBase{
    CANSparkMax IntakeMotor = new CANSparkMax(Constants.IntakeConstants.CAN_ADDRESS_INTAKEMOTOR,MotorType.kBrushless);

    
    public void run(double speed) {
        IntakeMotor.set(speed);
        
    }







}
