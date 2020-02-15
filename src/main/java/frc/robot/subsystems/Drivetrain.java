/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import java.time.*;
import java.time.temporal.Temporal;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.interfaces.Gyro;
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
  public final Encoder leftEncoder = new Encoder(Constants.leftEncoder[0], Constants.leftEncoder[1]);
  public final Encoder rightEncoder = new Encoder(Constants.rightEncoder[0], Constants.rightEncoder[1]);

  public final Gyro gyro = new AnalogGyro(Constants.gyro);
  double angleFromStart = 0;
  double currTime = 0;
  double prevTime = 0;
  public double leftSpeed;
  public double rightSpeed;


  
  public Drivetrain() {
    //gyro.calibrate();
    gyro.reset();
    rearLeft.setInverted(true);
    frontLeft.setInverted(true);
    leftEncoder.setDistancePerPulse(6*Math.PI/Constants.driveEncoderPPR);
    rightEncoder.setDistancePerPulse(6*Math.PI/Constants.driveEncoderPPR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    prevTime = currTime;
    currTime = System.nanoTime();
    double elapsedTime = currTime - prevTime;
    angleFromStart += gyro.getRate()*elapsedTime;
    //System.out.println(gyro.getAngle());
    leftSpeed = -leftEncoder.getDistance();
    rightSpeed = rightEncoder.getDistance();
    //System.out.println("Left: " + leftSpeed + " Right: " + rightSpeed);
  }
  public void drive(double leftPower, double rightPower){
    
    rearLeft.set(leftPower);
    frontLeft.set(leftPower);
    rearRight.set(rightPower);
    frontRight.set(rightPower);
  }
  public void goToAngle(double speed, double angle){
      double error =  (angle -  gyro.getAngle());
      rearLeft.set(speed -error*Constants.kPGyro);
      frontLeft.set(speed-error*Constants.kPGyro);
      rearRight.set(speed + error*Constants.kPGyro);
      frontRight.set(speed + error*Constants.kPGyro);
  }
  public void driveForward(double speed){
  
    drive(speed+(leftSpeed-rightSpeed)*0.01, speed-(leftSpeed-rightSpeed)*0.01);
    //drive(speed, speed);
  }
  public void resetEncoders(){
    leftEncoder.reset();
    rightEncoder.reset();
  }
  public double getDistance(){
    return (-leftEncoder.getDistance() + rightEncoder.getDistance())/2;
  }

  public Gyro getGyro(){
    return gyro;
  }

}


