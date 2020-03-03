/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.*;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoDropper extends InstantCommand {
  LowGoal dropper;
  public AutoDropper(LowGoal dropper) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.dropper = dropper;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Timer.delay(0.5);
    dropper.moveDropMotor(-0.75);
    Timer.delay(0.35);
    dropper.moveDropMotor(0.75);
    Timer.delay(0.75);
    dropper.moveDropMotor(0);
  }
}
