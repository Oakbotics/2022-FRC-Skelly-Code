package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TimedAuto extends CommandBase {
    private final DriveTrain m_driveTrain;
    double startTime;
    double time;

    public TimedAuto (DriveTrain driveTrain) {
        m_driveTrain = driveTrain;
        addRequirements(m_driveTrain);
    }
        
    @Override
    public void initialize() {
        startTime  = Timer.getFPGATimestamp();
        time = Timer.getFPGATimestamp();
    }

    @Override
    public void execute() {
        
        if (time - startTime < 3)   {
            m_driveTrain.setSpeed(0.5);
            time = Timer.getFPGATimestamp();
        }
        // else if (time - startTime) {
        //     m_driveTrain.setSpeed(0);
        // }
        else{
            m_driveTrain.setSpeed(0);
        }
        SmartDashboard.putNumber("Start Time", startTime);
        SmartDashboard.putNumber("Time", time);
    }





}
