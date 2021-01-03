/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

/**
 * Add your docs here.
 */
public enum AutoEnum {
    FLEX_AUTO(1),
    STRAIGHT_AUTO(2);
    int value;
    
    private AutoEnum(int value){
        this.value = value;
    }
}
