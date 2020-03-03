/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.LowGoal;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ControlDropper extends CommandBase {
  LowGoal dropper;
  Joystick joystick;
  public ControlDropper(LowGoal dropper, Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.dropper = dropper;
    this.joystick = joystick;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }
  @Override
  public void execute() {
    dropper.moveDropMotor(joystick.getY()*0.7);
    
  }
  @Override
  public void end(boolean interrupted) {
    dropper.moveDropMotor(0);
  }
  @Override
  public boolean isFinished() {
    return false;
  }

}
