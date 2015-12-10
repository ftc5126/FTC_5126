package com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes;

import com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes.AutonomousRobotInfo;

/**
 * Created by InDenProCom on 11/17/2015.
 */
public class PushBeacon extends AutonomousRobotInfo
{
    public void runOpMode() throws InterruptedException
    {
        waitForStart();

        while (opModeIsActive())
        {

            moveForward(.5, 5000);
            turn(.3, .8);
            moveForward(.5, 5000);
//            double bValue = cSensor.blue();
//            double rValue = cSensor.red();
//            telemetry.addData("Color Sensor Blue value:" ,Double.toString(bValue));
//            telemetry.addData("Color Sensor Red value:" ,Double.toString(rValue));
//            if (bValue > 0)
//            {
////                buttonLeft.setPower(1);
//
//            }
//            else if (rValue > 0)
//            {
////                buttonRight.setPower(1);
//            }
//            else
//            {
//                motorLeft.setPower(0);
//                motorRight.setPower(0);
//
//            }

        }
    }
}
