package com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes.AutonomousRobotInfo;


/**
 * Created by Emmy on 9/24/2015.
 */
public class DiceAutonomous extends AutonomousRobotInfo
{
    //curently this is set up for going up the mountain
    public void runOpMode() throws InterruptedException
    {
        waitForStart();

        while(opModeIsActive())
        {
            moveUsingEncoders(5,.5 );
            turn(.4, .6);
            moveUsingEncoders(5, .5);
        }


    }
}
