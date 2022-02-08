package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DriveTrain extends SubsystemBase {
    
    private WPI_TalonFX leftSecondaryMotor; 
    private WPI_TalonFX leftPrimaryMotor; 
    private WPI_TalonFX rightSecondaryMotor;
    private WPI_TalonFX rightPrimaryMotor; 
    
    SpeedControllerGroup leftMotorGroup; 
    SpeedControllerGroup rightMotorGroup;
    
    public DriveTrain() {
        super();

        leftSecondaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_LEFT_SECONDARY_MOTOR);
        leftPrimaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_LEFT_PRIMARY_MOTOR);
        rightSecondaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_RIGHT_SECONDARY_MOTOR);
        rightPrimaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_RIGHT_PRIMARY_MOTOR);

        leftMotorGroup = new SpeedControllerGroup(leftPrimaryMotor, leftSecondaryMotor);
        rightMotorGroup = new SpeedControllerGroup(rightPrimaryMotor, rightSecondaryMotor);
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
