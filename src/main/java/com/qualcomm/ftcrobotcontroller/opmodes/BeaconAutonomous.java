package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robocol.Telemetry;

//
//import com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes.AutonomousRobotInfo;
//
//
///**
// * Created by Emmy on 9/24/2015.
// */
public class BeaconAutonomous extends LinearOpMode {
    DcMotor motor1;
    DcMotor motor2;
    Servo arm1;
    Servo arm2;
    Servo hook;

    final double HOOK_DOWN = .23;
    final double HOOK_UP = 1;
    final double ARM1_UP = 55 / 255.0;
    final double ARM1_DOWN = 1.0;
    final double ARM2_UP = 205 / 255.0;
    final double ARM2_DOWN = 0;

    //    Servo arm = hardwareMap.servo.get("arm");

    final double encoderConversions = .004;
    final double turnConversions = .027;

    public void runOpMode() throws InterruptedException {
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor1.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor2.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor1.setDirection(DcMotor.Direction.REVERSE);

        hook = hardwareMap.servo.get("hook");
        arm1 = hardwareMap.servo.get("arm1");
        arm2 = hardwareMap.servo.get("arm2");
        waitForStart();

        hook.setPosition(HOOK_UP);
        arm1.setPosition(ARM1_DOWN);
        arm2.setPosition(ARM2_DOWN);

        moveUsingEncoders(20, .5);
        sleep(100);
        turnUsingEncoders(55, .5);
        sleep(100);
        moveUsingEncoders(70, .5);
        sleep(100);
    }

    public void moveUsingEncoders(double moveValue, double power) {
        double endVal = (moveValue / encoderConversions) + motor1.getCurrentPosition();
        telemetry.addData("Encoder value", motor1.getCurrentPosition());
        motor1.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motor2.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motor1.setPower(power * Math.signum(endVal - motor1.getCurrentPosition()));
        motor2.setPower(power * 0.8);
        while (Math.abs(motor1.getCurrentPosition() - endVal) > 50) {
            if (!opModeIsActive()) {
                break;
            }
        }
        motor1.setPower(0);
        motor2.setPower(0);
    }

    public void turnUsingEncoders(double length, double power) {
        double end = (length / turnConversions) + motor1.getCurrentPosition();
        telemetry.addData("Encoder value", motor1.getCurrentPosition());
        motor1.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motor2.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motor1.setPower(power * Math.signum(end - motor1.getCurrentPosition()));
        motor2.setPower(-power * Math.signum(end - motor1.getCurrentPosition()));
        while (Math.abs(motor1.getCurrentPosition() - end) > 50) {
            if (!opModeIsActive()) {
                break;
            }
        }
        motor1.setPower(0);
        motor2.setPower(0);


    }


}