/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
  TalonSRX cim1 = new TalonSRX(Constants.CIM_1);
  TalonSRX cim2 = new TalonSRX(Constants.CIM_2);
  TalonSRX lightSaberMotor = new TalonSRX(Constants.LIGHTSABER_MOTOR);
  public Climber() {
    /*
      Defined for future use
     */
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setLightSaberMotor(double speed){
    lightSaberMotor.set(ControlMode.PercentOutput, speed);
  }
  public void setClimbMotors(double speed){
    cim1.set(ControlMode.PercentOutput, speed);
    cim2.set(ControlMode.PercentOutput, speed);
  }
}
