package com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes.TeleopRobotInfo;
/**
 * Created by InDenProCom on 10/13/2015.
 */
public class DiceTeleop extends TeleopRobotInfo {

    double leftPower;
    double rightPower;

    public void init()
    {
        motorLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    public void loop()
    {
        leftPower = Range.clip(gamepad1.left_stick_y, -1, 1);
        rightPower = Range.clip(gamepad1.right_stick_y, -1, 1);

        motorLeft.setPower(leftPower);
        motorRight.setPower(rightPower);
        moveLift(gamepad1.right_trigger - gamepad1.left_trigger);
        lowerLift((gamepad1.b ? 1 : 0) * .3);
        if (gamepad1.a && hookServo.getPosition() != 0) //when a pressed and if servo is not at bottom
        {
            hookDown();
        }
        else if(gamepad1.a && hookServo.getPosition() == 0) //when a pressed and servo is at bottom
        {
            hookOut();
        }



    }
}
