package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.ftcrobotcontroller.opmodes.CommonRobotInfo;


/**
 * Created by Emmy on 9/24/2015.
 */
public class DiceAutonomous extends LinearOpMode
{
    CommonRobotInfo robot = new CommonRobotInfo();
    DcMotor motorLeft = robot.getMotorLeft();
    DcMotor motorRight = robot.getMotorRight();

    public void runOpMode() throws InterruptedException
    {
        waitForStart();

        while(opModeIsActive())
        {

        }


    }
}
