/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new drivetrain.
   */
  public final Spark rearLeft = new Spark(Constants.rearLeftWheel);
  public final Spark rearRight = new Spark(Constants.rearRightWheel);
  public final Spark frontLeft = new Spark(Constants.frontLeftWheel);
  public final Spark frontRight = new Spark(Constants.frontRightWheel);
  //public final Gyro gyro = new AnalogGyro(Constants.gyro);

  
  public Drivetrain() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void drive(double leftPower, double rightPower){
    rearLeft.set(-leftPower*0.25);
    frontLeft.set(-leftPower*0.25);
    rearRight.set(rightPower*0.25);
    frontRight.set(rightPower*0.25);
  }
}


