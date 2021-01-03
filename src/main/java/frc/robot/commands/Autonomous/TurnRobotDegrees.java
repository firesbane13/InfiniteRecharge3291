/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class TurnRobotDegrees extends CommandBase {
  /**
   * Creates a new AutoTest.
   */
  private final Drivetrain mDrive;
  double desiredAngle;
  PIDController pidTurn;
  boolean finished = false;
  double maxPower;
  int time = 0;

  public TurnRobotDegrees(Drivetrain drive, double degrees, double maxPower) {
    // Use addRequirements() here to declare subsystem dependencies.
    mDrive = drive;
    desiredAngle = degrees;
    pidTurn = new PIDController(Constants.K_PGYRO, Constants.K_IGYRO, Constants.K_DGYRO);
    this.maxPower = maxPower;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mDrive.getGyro().reset();
    time = 0;
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //
    double turnSpeed = pidTurn.calculate(mDrive.getGyro().getAngle(), desiredAngle) / 360;

    //Limits the max speed of the motor
    if ( Math.abs(turnSpeed) > maxPower ){
      turnSpeed = (Math.abs(turnSpeed)/turnSpeed)*maxPower;
    }

    System.out.println(turnSpeed);
    
    mDrive.drive(-turnSpeed, turnSpeed);

    //Handles canceling the command when the error i
    if ( Math.abs(turnSpeed) < 0.12 ) {
      time++;
    }

    if ( time >= 8 ) {
      finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mDrive.drive(0, 0); 
    finished = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
