/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Motor Ports
    public static int rearLeftWheel = 0;
    public static int frontLeftWheel = 1;
    public static int rearRightWheel = 2;
    public static int frontRightWheel = 3;
    public static int colorMotor = 9;

    //PID Constants
    public static double kPColorMotor = 1.5;


    
    //Gyro port
    public static int gyro = 0;
    
    //Encoder Ports
    public static int[] colorEncoder = {0, 1};
    public static int[] leftEncoder = {2, 3};
    public static int[] rightEncoder = {4, 5};

    //Encoder Pulse Per Revolution
    public static double colorEncoderPPR = 500;

    //Joystick Ports
    public static int Joystick1 = 0;
    public static int Joystick2 = 1;
    


    //Color Positions for order of color wheel
    public static int redPos = 1;
    public static int yellowPos = 2;
    public static int bluePos = 3;
    public static int greenPos = 4;
    
    //Number of Turns
    public static int numberOfWheelColors = 8;


}
