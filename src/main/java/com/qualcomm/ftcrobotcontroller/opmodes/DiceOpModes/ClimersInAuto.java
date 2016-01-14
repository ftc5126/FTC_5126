package com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by DICE on 12/12/2015.
 */
public class ClimersInAuto extends LinearOpMode {
    DcMotor motorLeft = hardwareMap.dcMotor.get("motor1");
    DcMotor motorRight = hardwareMap.dcMotor.get("motor2");

    public void runOpMode() throws InterruptedException {
        waitForStart();
        motorLeft.setPower(.5);
        motorRight.setPower(.5);
    }

}
