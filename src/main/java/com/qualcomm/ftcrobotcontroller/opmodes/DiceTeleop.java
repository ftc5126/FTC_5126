package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
/**
 * Created by InDenProCom on 10/13/2015.
 */
public class DiceTeleop extends OpMode {

    DcMotor left;
    DcMotor right;
    DcMotor lift;
    DcMotor drum;
    double leftPower;
    double rightPower;

    public void init()
    {
        left = hardwareMap.dcMotor.get("motorLeft");
        right = hardwareMap.dcMotor.get("motorRight");
        left.setDirection(DcMotor.Direction.REVERSE);
    }

    public void loop()
    {
        leftPower = Range.clip(gamepad1.left_stick_y, -1, 1);
        rightPower = Range.clip(gamepad1.right_stick_y, -1, 1);

        left.setPower(leftPower);
        right.setPower(rightPower);
    }
}
