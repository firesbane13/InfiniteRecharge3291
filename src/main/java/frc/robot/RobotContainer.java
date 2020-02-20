/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.Autonomous.*;
import frc.robot.commands.*;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.ColorWheel;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LowGoal;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //Subystems 
  private final Drivetrain drivetrain = new Drivetrain();
  private ColorWheel colorWheel = new ColorWheel();
  private Climber climber = new Climber();
  private LowGoal lowGoal = new LowGoal();

  //Joysticks
  public static  Joystick joystick1 = new Joystick(Constants.Joystick1);
  public static  Joystick joystick2 = new Joystick(Constants.Joystick2);
  public static  Joystick joystick3 = new Joystick(Constants.Joystick3);


  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    //Dropper Commands
    Button controlDropper = new JoystickButton(joystick3, 8);
    controlDropper.toggleWhenPressed(new ControlDropper(lowGoal, joystick3));
    
    //Climb Commands
    Button controlLightSaber = new JoystickButton(joystick3, 7);
    Button climb = new JoystickButton(joystick3, 3); 
    controlLightSaber.toggleWhenPressed(new ControlLightSaber(climber, joystick3));
    climb.whenPressed(new Climb(climber));
    
    //Color Wheel Commands
    Button readyColorMotor = new JoystickButton(joystick3, 9);
    Button unReadyColorMotor = new JoystickButton(joystick3, 10);
    Button turnToColor = new JoystickButton(joystick3, 11);
    Button rotateColorWheel = new JoystickButton(joystick3, 12); 
    readyColorMotor.whenPressed(new ReadyColorMotor(colorWheel));
    unReadyColorMotor.whenPressed(new UnReadyColorMotor(colorWheel));   
    turnToColor.whenPressed(new TurnToColor(colorWheel, drivetrain));
    rotateColorWheel.whenPressed(new RotateColorWheel(colorWheel, drivetrain, 4));   

    //Drive Commands
    Button driveToGoal = new JoystickButton(joystick1, 3);
    Button turnLeft = new JoystickButton(joystick1, 1);
    Button turnRight = new JoystickButton(joystick2, 1);
    driveToGoal.toggleWhenPressed(new DriveToGoal(drivetrain));
    turnLeft.whenPressed(new TurnRobotDegrees(drivetrain, 90, 1));
    turnRight.whenPressed(new TurnRobotDegrees(drivetrain, -90, 1));
    
    //lowerLightSaber.whenHeld(new LowerLightSaber(climber));
  }


  public Command getAutonomousCommand(int location) {

    if(location == 1){
      return new Auto1(drivetrain);
    }else if(location == 2){
      return new Auto2(drivetrain);
    }else{
      return new Auto3(drivetrain);
    }
    //return new ControlLightSaber(new Climber(), joystick3);
  }

  public Command getDriveTrain(){
    return new TankDrive(drivetrain, joystick1, joystick2);
  }
}
