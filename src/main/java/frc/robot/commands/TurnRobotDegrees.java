/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class TurnRobotDegrees extends CommandBase {
  /**
   * Creates a new AutoTest.
   */
  private final Drivetrain m_drive;
  double desiredAngle;
  PIDController pidTurn;
  boolean finished = false;
  double maxPower;
  int time = 0;
  public TurnRobotDegrees(Drivetrain drive, double degrees, double maxPower) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    desiredAngle = degrees;
    pidTurn = new PIDController(Constants.kPGyro, Constants.kIGyro, Constants.kDGyro);
    this.maxPower = maxPower;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.getGyro().reset();
    time = 0;
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double turnSpeed = pidTurn.calculate(m_drive.getGyro().getAngle(), desiredAngle)/360;
    if(Math.abs(turnSpeed) > maxPower){
      turnSpeed = (Math.abs(turnSpeed)/turnSpeed)*maxPower;
    }
    System.out.println(turnSpeed);
    m_drive.drive(-turnSpeed, turnSpeed);
    
    if(Math.abs(turnSpeed) < 0.12){
      time++;
    }
    if(time >= 7){
      finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.drive(0, 0); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
