/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DriveForward extends CommandBase {
  /**
   * Creates a new DriveForward.
   */
  Drivetrain drive;
  double distance;
  PIDController pidDrive;
  PIDController pidTurn;
  double maxPower;
  boolean finished = false;
  double time = 0;
  
  public DriveForward(Drivetrain drive, double distance, double maxPower) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = drive;
    this.distance = distance;
    this.maxPower = maxPower;
    pidDrive = new PIDController(Constants.kPDrive, Constants.kIDrive, Constants.kDDrive);
    pidTurn = new PIDController(11, 2, 0);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.resetEncoders();
    drive.getGyro().reset();
    time = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double turnSpeed = pidTurn.calculate(drive.getGyro().getAngle(), 0)/360;
    double driveSpeed = -pidDrive.calculate(drive.getDistance(), distance)/50;
    if(Math.abs(driveSpeed) > maxPower){
      driveSpeed = (Math.abs(driveSpeed)/ driveSpeed) * maxPower;
    }
    drive.drive(driveSpeed - turnSpeed, driveSpeed + turnSpeed);
    if(Math.abs(driveSpeed) < 0.12){
      time++;
    }
    if(time >= 15){
      finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.drive(0, 0);
    Timer.delay(0.25);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
