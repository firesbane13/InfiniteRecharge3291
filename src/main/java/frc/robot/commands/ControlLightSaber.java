/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ControlLightSaber extends CommandBase {
  /**
   * Creates a new ExtendLightSaber.
   */
  Climber climb;
  Joystick joystick;
  double minSpeed =0;
  double maxSpeed = 0;
  double stallSpeed = 0.1;
  public ControlLightSaber(Climber climb, Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.climb = climb;
    this.joystick = joystick;
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
    double speed = joystick.getY()*0.8;

    climb.setLightSaberMotor(stallSpeed + speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climb.setLightSaberMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
