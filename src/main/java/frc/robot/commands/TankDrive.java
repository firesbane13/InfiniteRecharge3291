/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
  /**
   * Creates a new TankDrive.
   */
  private final Drivetrain m_drive;

  private final Joystick j1;
  private final Joystick j2;

  public TankDrive(Drivetrain drive, Joystick m_j1, Joystick m_j2) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    j1 = m_j1;
    j2 = m_j2;
    //addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*double rotateSpeed = m_drive.getGyro().getAngle()/360;
    if(Math.abs(j1.getY() - j2.getY()) > 0.35){
      m_drive.getGyro().reset();
      m_drive.drive(j1.getY()*0.5, j2.getY()*0.5);
    }else{

      m_drive.drive((j1.getY() + rotateSpeed)*0.5, j2.getY() - rotateSpeed);
      
    }*/
    m_drive.drive(j1.getY()*0.5, j2.getY()*0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
