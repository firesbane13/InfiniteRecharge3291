/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.autonomous.*;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LowGoal;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Auto2 extends SequentialCommandGroup {
  /**
   * Creates a new Auto2.
   */
  public Auto2(Drivetrain drive, LowGoal dropper) {
    // Add your commands in the super() call, e.g.
    super(new DriveForward(drive, 90, 0.75), 
    new TurnRobotDegrees(drive, 90, 0.75), 
    new DriveForward(drive, 67.75, 0.75),
    new TurnRobotDegrees(drive, -90, 0.75),
    new DriveForward(drive, 30, 0.75),
    new AutoDropper(dropper),
    new TurnRobotDegrees(drive, -45, 0.75),
    new DriveForward(drive, -170, 0.75));
  }
}
