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
    final int encoderTicsForATile = 12320;
    final int encoderTicsForHalfATile = 6160;

    final double encoderConversions = .014;

    public void runOpMode() throws InterruptedException {
        waitForStart();

        while (opModeIsActive()) {

            moveUsingEncoders(encoderTicsForATile + encoderTicsForHalfATile, .5); //move a tile and a half forward
            turnUsingEncoders(90, .5); //turns to move to correct section
            moveUsingEncoders(encoderTicsForATile, .5); // moves to correct section
            turnUsingEncoders(90, .5); // turn to face mountain
            moveUsingEncoders(12500, .5); //move up mountain


            // arm.setPosition(1); //sets arm to distance slightly up
            //sleep(500); // waits for 500 millseconds
            // arm.setPosition(5); //moves arm higher
            //moveUsingEncoders(1200, 0.5); // move forward 1200 encoder tics
        }
    }

    public double convertEncoders(double encoderValue) {
        return encoderValue * encoderConversions;
    }

    //    public void sleep(long mill)
//        {
//        ElapsedTime eTime = new ElapsedTime();
    //        while(eTime.time() < mill)
//            {
//            motorLeft.setPower(0);
//            motorRight.setPower(0);
//            }
//       }
    public void moveUsingEncoders(double moveValue, double power) {
        double endVal = moveValue / encoderConversions;
        motor1.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setMode(DcMotorController.RunMode.RESET_ENCODERS);

        motor1.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor1.setPower(power);
        motor2.setPower(power);
        motor1.setTargetPosition((int) endVal);
        motor2.setTargetPosition((int) endVal);

    }

    public void turnUsingEncoders(double length, double power) {
        double end = length / encoderConversions;
        motor1.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motor1.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor1.setPower(power);
        motor2.setPower(power);
        motor1.setTargetPosition((int) end);
        motor2.setTargetPosition((int) -end);


    }


}
