/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.*;

public class ColorWheel extends SubsystemBase {
  /**
   * Creates a new ColorWheel.
   */
  private Encoder colorEncoder;
  private VictorSPX colorWheelMotor;
  private VictorSPX colorMotor;
  private ColorSensorV3 wheelSensor;
  private PIDController colorPid;


  public ColorWheel() {
    int[] colorEncoderConst = Constants.getColorEncoder();

    colorEncoder = new Encoder(colorEncoderConst[0], colorEncoderConst[1]);
    colorEncoder.setDistancePerPulse(1/(Constants.COLOR_ENCODER_PPR * Constants.COLOR_WHEEL_FRICTION));
    colorWheelMotor = new VictorSPX(Constants.COLOR_WHEEL_MOTOR);
    colorMotor = new VictorSPX(Constants.COLOR_MOTOR);
    wheelSensor = new ColorSensorV3(I2C.Port.kOnboard);
    colorPid = new PIDController(Constants.K_PCOLOR_MOTOR, Constants.K_ICOLOR_MOTOR, Constants.K_DCOLOR_MOTOR);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.println("R: " + wheelSensor.getRed() + " G: " + wheelSensor.getGreen() + " B: " +  wheelSensor.getBlue());
    
    System.out.println(getColor());
  }

  public void resetEncoder(){
    colorEncoder.reset();
  }
  private double getMaxRatio(int a, int b){
    if ( a == 0 || b == 0 ) {
      return 0;      
    }

    if ( ( a /b ) > ( b / a ) ){
      return a / b;
    } else {
      return b / a;
    }
  }
  
  //Feedback PID Control 
  public double moveNumberOfColors(double numberOfColors){
    double error = colorPid.calculate(colorEncoder.getDistance(), numberOfColors);
    
    colorWheelMotor.set(ControlMode.PercentOutput, error);
    return error;
  }

  public void moveColorWheelMotor(double power){
    colorWheelMotor.set(ControlMode.PercentOutput, power);
  }
  public void turnColorMotor(double power){
    colorMotor.set(ControlMode.PercentOutput, power);
  }
  public int getColor(){
    int r = wheelSensor.getRed();
    int g = wheelSensor.getGreen();
    int b = wheelSensor.getBlue();
    double rgRatio = getMaxRatio(r, g);
    double rbRatio = getMaxRatio(r, b);
    double gbRatio = getMaxRatio(g, b);
    
    //if senses blue
    if (gbRatio < rbRatio && gbRatio < rgRatio) {
      return Constants.YELLOW_POS;
    //if senses red
    } else if (rgRatio < gbRatio && rgRatio < rbRatio && r > g) {
      return Constants.GREEN_POS;
    //if senses yellow
    } else if (rgRatio < gbRatio && rgRatio < rbRatio && r < g) {
      return Constants.RED_POS;
    //if senses green
    } else if (g > r && g > b && rbRatio  < rgRatio && rbRatio < gbRatio) {
      return Constants.BLUE_POS;
    } else {
      return 0;
    }
  }
  
}
