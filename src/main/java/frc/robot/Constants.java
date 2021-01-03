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
        public static final int REAR_LEFT_WHEEL = 3;
        public static final int FRONT_LEFT_WHEEL = 2;
        public static final int REAR_RIGHT_WHEEL = 0;
        public static final int FRONT_RIGHT_WHEEL = 1;
        //color wheel
        public static final int COLOR_WHEEL_MOTOR = 2;
        public static final int COLOR_MOTOR = 1;
        //climber
        public static final int CIM_1 = 0;
        public static final int LIGHTSABER_MOTOR = 1;
        public static final int CIM_2 = 2;

        //low goal
        public static final int LOW_GOAL = 0;

    /*PID Constants*/
        //Color Motor
        public static final double K_PCOLOR_MOTOR = 5;
        public static final double K_ICOLOR_MOTOR = 0;
        public static final double K_DCOLOR_MOTOR = 0;
        //Gyro
        public static final double K_PGYRO = 17.5;
        public static final double K_IGYRO = 0.0;
        public static final double K_DGYRO = 3.0;
        //Encoder
        public static final double K_PDRIVE = 1;
        public static final double K_IDRIVE = 1.0;
        public static final double K_DDRIVE = 0;
        //Camera
        public static final double K_PCAMERA = 1;
        public static final double K_ICAMERA = 0;
        public static final double K_DCAMERA = 0;

    /*Sensor Ports*/
        //Gyro port
        public static final int GYRO = 0;
        
        //Encoder Ports
        protected static final int[] COLOR_ENCODER = {4, 5};
        protected static final int[] LEFT_ENCODER = {0, 1};
        protected static final int[] RIGHT_ENCODER = {2, 3};

    /*Joystick Ports*/
        public static final int JOYSTICK_1 = 1;
        public static final int JOYSTICK_2 = 0;
        public static final int JOYSTICK_3 = 2;

    /*Sensor Constants*/
        //Color Positions for order of color wheel
        public static final int RED_POS = 1;
        public static final int YELLOW_POS = 2;
        public static final int BLUE_POS = 3;
        public static final int GREEN_POS = 4;
        public static final int NUM_OF_COLORS = 4;
        
        //Number of colors on the color wheel
        public static final int NUMBER_OF_WHEEL_COLORS = 8;
        
        //Friction Constants
        public static final double COLOR_WHEEL_FRICTION = 1;
        
        //Encoder Pulse Per Revolution
        public static final double COLOR_ENCODER_PPR = 500;
        public static final double DRIVE_ENCODER_PPR = 360;
        //Camera Image Dimensions
        public static final double WIDTH = 640;
        public static final double HEIGHT = 480;

    public static int[] getColorEncoder() {
        return COLOR_ENCODER;
    }

    public static int[] getLeftEncoder() {
        return LEFT_ENCODER;
    }

    public static int[] getRightEncoder() {
        return RIGHT_ENCODER;
    }
}
