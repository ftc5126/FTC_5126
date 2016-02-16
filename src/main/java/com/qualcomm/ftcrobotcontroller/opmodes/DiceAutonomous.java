package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

//
//import com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes.AutonomousRobotInfo;
//
//
///**
// * Created by Emmy on 9/24/2015.
// */
public class DiceAutonomous extends LinearOpMode {
    DcMotor motor1 = hardwareMap.dcMotor.get("motor1");
    DcMotor motor2 = hardwareMap.dcMotor.get("motor2");
    Servo arm = hardwareMap.servo.get("arm");

    final double encoderConversions = .014;

    public void runOpMode() throws InterruptedException {
        waitForStart();

        while (opModeIsActive()) {
//            motorLeft.setPower(0);
//            motorRight.setPower(0);
//            double rightInches = convertEncoders(motorRight.getCurrentPosition());
//            double leftInches = convertEncoders(motorRight.getCurrentPosition());
//            //move forward to mountain
//            moveUsingEncoders(50, .5);
//            //turn till facing mountain
//            turn(.8,.2);
//            //move up mountain
//            moveUsingEncoders(3, .5);
            arm.setPosition(1); //sets arm to distance slightly up
            sleep(500); // waits for 500 millseconds
            arm.setPosition(5); //moves arm higher
            moveUsingEncoders(12, 0.5); // move forward 12 encoder tics
        }
    }

    public double convertEncoders(double encoderValue) {
        return encoderValue * encoderConversions;
    }

    //    public void sleep(long mill)
//        {
//        ElapsedTime eTime = new ElapsedTime();
//        while(eTime.time() < mill)
//        {
//            motorLeft.setPower(0);
//            motorRight.setPower(0);
//        }
//    }
//    public void turn(double rPower, double lPower)
//    {
//        motorLeft.setPower(rPower);
//        motorRight.setPower(lPower);
//        sleep(10);
//        motorLeft.setPower(0);
//        motorRight.setPower(0);
//    }
//
    public void moveUsingEncoders(double moveValue, double power) {
        double endVal = moveValue / encoderConversions;
        motor1.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setMode(DcMotorController.RunMode.RESET_ENCODERS);

        motor1.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor1.setPower(power);
        motor2.setPower(power);
        motor1.setTargetPosition(endVal);
        motor2.setTargetPosition(endVal);

    }

    public void turnUsingEncoders(double length, double power) {
        double end = length / encoderConversions;
        motor1.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setMode(DcMotorController.RunMode.RESET_ENCODERS);

        motor1.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor1.setPower(power);
        motor2.setPower(power);
        motor1.setTargetPosition(end);
        motor2.setTargetPosition(-end);


    }


}
