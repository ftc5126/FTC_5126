package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by InDenProCom on 11/17/2015.
 */
public class PushBeacon extends LinearOpMode
{
    public void runOpMode() throws InterruptedException
    {
        waitForStart();

        while (opModeIsActive())
        {
            CommonRobotInfo robot = new CommonRobotInfo();
            DcMotor motorLeft = robot.getMotorLeft();
            DcMotor motorRight = robot.getMotorRight();
            ColorSensor cSensor = robot.getColorSensor();
            DcMotor buttonLeft = robot.getButtonRight();
            DcMotor buttonRight = robot.getButtonLeft();

            robot.moveForward(.5, 5000);
            robot.turn(.3, .8);
            robot.moveForward(.5, 5000);
            double bValue = robot.getColorBlue();
            double rValue = robot.getColorRed();
            telemetry.addData("Color Sensor Blue value:" ,Double.toString(bValue));
            telemetry.addData("Color Sensor Red value:" ,Double.toString(rValue));
            if (bValue > 0)
            {
                buttonLeft.setPower(1);

            }
            else if (rValue > 0)
            {
                buttonRight.setPower(1);
            }
            else
            {
                motorLeft.setPower(0);
                motorRight.setPower(0);

            }

        }
    }
}
