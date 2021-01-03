/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new drivetrain.
   */
  public final Spark rearLeft = new Spark(Constants.REAR_LEFT_WHEEL);
  public final Spark rearRight = new Spark(Constants.REAR_RIGHT_WHEEL);
  public final Spark frontLeft = new Spark(Constants.FRONT_LEFT_WHEEL);
  public final Spark frontRight = new Spark(Constants.FRONT_RIGHT_WHEEL);
  
  protected int[] leftEncoderConst = Constants.getLeftEncoder();
  protected int[] rightEncoderConst = Constants.getRightEncoder();

  public final Encoder leftEncoder = new Encoder(leftEncoderConst[0], leftEncoderConst[1]);
  public final Encoder rightEncoder = new Encoder(rightEncoderConst[0], rightEncoderConst[1]);
  public final Gyro gyro = new AnalogGyro(Constants.GYRO);
  double angleFromStart = 0;
  double currTime = 0;
  double prevTime = 0;
  protected double leftSpeed;
  protected double rightSpeed;

  public Drivetrain() {
    gyro.reset();
    rearLeft.setInverted(true);
    frontLeft.setInverted(true);
    leftEncoder.setDistancePerPulse(6 * Math.PI / Constants.DRIVE_ENCODER_PPR);
    rightEncoder.setDistancePerPulse(6 * Math.PI / Constants.DRIVE_ENCODER_PPR);
    leftSpeed = 0;
    rightSpeed = 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    prevTime = currTime;
    currTime = System.nanoTime();
    double elapsedTime = currTime - prevTime;
    angleFromStart += gyro.getRate()*elapsedTime;

    leftSpeed = -leftEncoder.getDistance();
    rightSpeed = rightEncoder.getDistance();
  }

  public void drive(double leftPower, double rightPower){
    rearLeft.set(leftPower);
    frontLeft.set(leftPower);
    rearRight.set(rightPower);
    frontRight.set(rightPower);
  }
  
  public void arcadeDrive(double speed, double turn){
    rearLeft.set(speed + turn);
    frontLeft.set(speed + turn);
    rearRight.set(speed - turn);
    frontRight.set(speed - turn);
  }
  
  public void driveForward(double speed){
    drive( speed + ( leftSpeed - rightSpeed ) * 0.01, speed - ( leftSpeed - rightSpeed ) * 0.01 );
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


