/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.*;

public class ColorWheel extends SubsystemBase {
  /**
   * Creates a new ColorWheel.
   */
  private Encoder colorEncoder;
  private VictorSP colorMotor;
  private ColorSensorV3 wheelSensor;

  public ColorWheel() {
    colorEncoder = new Encoder(Constants.colorEncoder[0], Constants.colorEncoder[1]);
    colorEncoder.setDistancePerPulse(1/Constants.colorEncoderPPR);
    colorMotor = new VictorSP(Constants.colorMotor);
    wheelSensor = new ColorSensorV3(I2C.Port.kOnboard);
  }

  private double getMaxRatio(int a, int b){
    if(a/b > b/a){
      return a/b;
    }else{
      return b/a;
    }
  }
  
  //Feedback PID Control (Need to figure out Feed Forward)
  public void moveNumberOfColors(int numberOfColors){
    double error = numberOfColors - colorEncoder.getDistance();
    while(error > 0){
      colorMotor.set(Constants.kPColorMotor*error);
    }
  }

  public Integer getColor(){
    int r = wheelSensor.getRed();
    int g = wheelSensor.getGreen();
    int b = wheelSensor.getBlue();
    double rgRatio = getMaxRatio(r, g);
    double rbRatio = getMaxRatio(r, b);
    double gbRatio = getMaxRatio(g, b);
     if(gbRatio < rbRatio && gbRatio < rgRatio){
      return Constants.bluePos;
    }else if(rgRatio < gbRatio && rgRatio < rbRatio && r > g){
      return Constants.redPos;
    }else if(rgRatio < gbRatio && rgRatio < rbRatio && r < g){
      return Constants.yellowPos;
    }if(g > r && g > b && rbRatio  < rgRatio && rbRatio < gbRatio){
      return Constants.greenPos;
    }
    else return null;
  }
}
