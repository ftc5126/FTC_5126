package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.ftcrobotcontroller.opmodes.CommonRobotInfo;


/**
 * Created by InDenProCom on 9/24/2015.
 */
public class DiceAutonomous extends LinearOpMode
{
    CommonRobotInfo robot = new CommonRobotInfo();
    DcMotor motorLeft = robot.getMotorLeft();
    DcMotor motorRight = robot.getMotorRight();
    //ColorSensor cSensor = robot.getColorSensor();
    DcMotor buttonLeft = robot.getButtonRight();
    DcMotor buttonRight = robot.getButtonLeft();

    public void runOpMode() throws InterruptedException
    {
        waitForStart();

        while(opModeIsActive())
        {
            robot.moveForward(.5, 5000);
            robot.turn(.3, .8, 5000);
            robot.moveForward(.5, 5000);
            robot.turn(.3, .8, 5000);
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
                motorRight.setPower(0);
                motorLeft.setPower(0);
            }
        }

    }
}
