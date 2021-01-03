/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DriveToGoal extends CommandBase {
  /**
   * Creates a new DriveToGoal.
   */
  Drivetrain drive;
  NetworkTable gripTable;
  double centerX;
  PIDController pidCamera;
  public DriveToGoal(Drivetrain drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = drive;

    CameraServer.getInstance().startAutomaticCapture();
    
    gripTable = NetworkTableInstance.getDefault().getTable("GRIP/mycontoursReport");
    pidCamera = new PIDController(Constants.K_PCAMERA, Constants.K_ICAMERA, Constants.K_DCAMERA);
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
    centerX = 0;
    double[] areaArray = gripTable.getEntry("area").getDoubleArray(new double[0]);
    double max = -1;
    int maxIndex = -1;

    for (int i = 0; i<areaArray.length; i++) {
      if (areaArray[i] > max) {
        max = areaArray[i];
        maxIndex = i;
      }
    }

    if (maxIndex > 0) {
      centerX = gripTable.getEntry("centerX").getDoubleArray(new double[0])[maxIndex];
    }
    
    double speed = -pidCamera.calculate(centerX, Constants.WIDTH/2)/Constants.WIDTH;
    drive.drive(0.25 - speed, 0.25 + speed);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    /*
      Defined for future use
     */
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
