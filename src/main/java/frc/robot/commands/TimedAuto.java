package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;
import java.util.function.DoubleSupplier;

public class TimedAuto extends CommandBase {
    private final DriveTrain m_driveTrain;
    double startTime = Timer.getFPGATimestamp();
    double time;

    public void drive10s (DriveTrain driveTrain) {
        time = Timer.getFPGATimestamp();
        m_driveTrain = driveTrain;
        if (time - startTime < 5)   {
            m_driveTrain.arcadeDrive(0.5, 0);
        }else{
            m_driveTrain.arcadeDrive(0, 0);

        }
    }




}
