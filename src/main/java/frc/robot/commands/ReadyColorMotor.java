/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ColorWheel;

public class ReadyColorMotor extends InstantCommand {
  /**
   * Creates a new ReadyColorMotor.
   */
  ColorWheel color;
  public ReadyColorMotor(ColorWheel color) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.color = color;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    color.turnColorMotor(-0.75);
    Timer.delay(1.5);
    color.turnColorMotor(0);
  }


}
