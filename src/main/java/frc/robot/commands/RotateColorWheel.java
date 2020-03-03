/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ColorWheel;
import frc.robot.subsystems.Drivetrain;

public class RotateColorWheel extends CommandBase {
  /**
   * Creates a new MoveColorWheel.
   */
  ColorWheel colorWheel;
  double numberOfRotations;
  Drivetrain drive;
  double time;
  boolean finished = false;

  
  public RotateColorWheel(ColorWheel kColorWheel, Drivetrain m_drive,  double kNumberOfRotations) {
    // Use addRequirements() here to declare subsystem dependencies.
    colorWheel = kColorWheel;
    numberOfRotations = kNumberOfRotations;
    drive = m_drive;
    finished = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    finished = false;
    colorWheel.resetEncoder();
    time = 0;
    //colorWheel.moveColorMotor(-0.1);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double error = colorWheel.moveNumberOfColors(Constants.numberOfWheelColors*numberOfRotations);
    System.out.println(error);
    if(Math.abs(error) < 0.12){
      time++;
    }
    if(time >= 7){
      finished = true;
    }

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    colorWheel.moveColorWheelMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
