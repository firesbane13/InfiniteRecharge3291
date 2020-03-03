/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Autonomous.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Autonomous.*;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LowGoal;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Auto3 extends SequentialCommandGroup {
  /**
   * Creates a new Auto3.
   */
  public Auto3(Drivetrain drive, LowGoal dropper) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      new DriveForward(drive, 55, 0.75),
      new DriveTimed(drive, 2),
      new AutoDropper(dropper),
      new DriveForward(drive, -80, 0.75)
    );
    
  }
}
