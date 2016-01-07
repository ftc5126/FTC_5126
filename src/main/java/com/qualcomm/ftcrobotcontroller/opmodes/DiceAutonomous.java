package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

//
//import com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes.AutonomousRobotInfo;
//
//
///**
// * Created by Emmy on 9/24/2015.
// */
public class DiceAutonomous extends LinearOpMode {
    DcMotor motorLeft = hardwareMap.dcMotor.get("motor1");
    DcMotor motorRight = hardwareMap.dcMotor.get("motor2");

    public void runOpMode() throws InterruptedException {
        waitForStart();

        while (opModeIsActive()) {
            motorLeft.setPower(-.5);
            motorRight.setPower(.5);
            sleep(5000);
            motorLeft.setPower(0);
            motorRight.setPower(0);
            sleep(5000);
            motorRight.setPower(.5);
            motorLeft.setPower(.5);
            sleep(5000);
            motorLeft.setPower(0);
            motorRight.setPower(0);
        }
//
//
    }
}
