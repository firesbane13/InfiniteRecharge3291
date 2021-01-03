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
  private final Drivetrain mDrive;

  private final Joystick j1;
  private final Joystick j2;

  public TankDrive(Drivetrain drive, Joystick mJ1, Joystick mJ2) {
    // Use addRequirements() here to declare subsystem dependencies.
    mDrive = drive;
    j1 = mJ1;
    j2 = mJ2;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    /*
      Defined for future use
     */
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mDrive.drive( j1.getY() * 1, j2.getY() * 1 );
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mDrive.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
