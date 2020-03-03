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
    /*Motor Ports*/
        //drivetrain
        public static int rearLeftWheel = 3;
        public static int frontLeftWheel = 2;
        public static int rearRightWheel = 0;
        public static int frontRightWheel = 1;
        //color wheel
        public static int colorWheelMotor = 2;
        public static int colorMotor = 1;
        //climber
        public static int cim1 = 0;
        public static int lightSaberMotor = 1;
        public static int cim2 = 2;

        //low goal
        public static int lowGoal = 0;

    /*PID Constants*/
        //Color Motor
        public static double kPColorMotor = 5;
        public static double kIColorMotor = 0;
        public static double kDColorMotor = 0;
        //Gyro
        public static double kPGyro = 17.5;
        public static double kIGyro = 0.0;
        public static double kDGyro = 3.0;
        //Encoder
        public static double kPDrive = 1;
        public static double kIDrive = 1.0;
        public static double kDDrive = 0;
        //Camera
        public static double kPCamera = 1;
        public static double kICamera = 0;
        public static double kDCamera = 0;


    /*Sensor Ports*/
        //Gyro port
        public static int gyro = 0;
        
        //Encoder Ports
        public static int[] colorEncoder = {4, 5};
        public static int[] leftEncoder = {0, 1};
        public static int[] rightEncoder = {2, 3};


    /*Joystick Ports*/
        public static int Joystick1 = 1;
        public static int Joystick2 = 0;
        public static int Joystick3 = 2;
        

    /*Sensor Constants*/
        //Color Positions for order of color wheel
        public static int redPos = 1;
        public static int yellowPos = 2;
        public static int bluePos = 3;
        public static int greenPos = 4;
        public static int numOfColors = 4;
        
        //Number of colors on the color wheel
        public static int numberOfWheelColors = 8;
        
        //Friction Constants
        public static double colorWheelFriction = 1;
        
        //Encoder Pulse Per Revolution
        public static double colorEncoderPPR = 500;
        public static double driveEncoderPPR = 360;
        //Camera Image Dimensions
        public static double width = 640;
        public static double height = 480;


}
