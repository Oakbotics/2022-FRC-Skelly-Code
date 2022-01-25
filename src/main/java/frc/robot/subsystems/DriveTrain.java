package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.GroupMotorControllers;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;




public class DriveTrain extends SubsystemBase {
    

    private WPI_TalonFX leftSecondaryMotor; 
    private WPI_TalonFX leftPrimaryMotor; 
    private WPI_TalonFX rightSecondaryMotor;
    private WPI_TalonFX rightPrimaryMotor; 
    
    SpeedControllerGroup leftMotorGroup; 
    SpeedControllerGroup rightMotorGroup;
    
    SpeedControllerGroup allMotorGroup;
    
    ArrayList<WPI_TalonFX> motors = new ArrayList<WPI_TalonFX>();

    public DriveTrain() {
        super();

        leftSecondaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_LEFT_SECONDARY_MOTOR);
        leftPrimaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_LEFT_PRIMARY_MOTOR);
        rightSecondaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_RIGHT_SECONDARY_MOTOR);
        rightPrimaryMotor = new WPI_TalonFX(Constants.DriveConstants.CAN_ADDRESS_RIGHT_PRIMARY_MOTOR);

        leftSecondaryMotor.follow(leftPrimaryMotor);
        rightSecondaryMotor.follow(rightPrimaryMotor);        

        allMotorGroup = new SpeedControllerGroup(leftSecondaryMotor, leftPrimaryMotor, rightSecondaryMotor, rightPrimaryMotor);

        for (WPI_TalonFX wpi_TalonFX : motors) {
            wpi_TalonFX.configFactoryDefault();
            wpi_TalonFX.setSensorPhase(false);
            wpi_TalonFX.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
        }

        
    }



    public void goForwardFt(Double distance){
        leftPrimaryMotor.set(TalonFXControlMode.Position,  1);
        rightPrimaryMotor.set(TalonFXControlMode.Position, distance*Constants.DriveConstants.ENCODER_TICKS_PER_INCH);
    }

    public void turnDegrees(Double degrees){
        //Make this asynchronous
        double testingCoeffecientForDegrees = 30;
        leftPrimaryMotor.set(TalonFXControlMode.Position, testingCoeffecientForDegrees * degrees);
        rightPrimaryMotor.set(TalonFXControlMode.Position, -(testingCoeffecientForDegrees*degrees));
    }

    public void goFowardPerc(float distance){
        leftPrimaryMotor.set(distance);
    }


    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
