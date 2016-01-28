package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

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


    final double encoderConversions = .014;

    public void runOpMode() throws InterruptedException {
        waitForStart();

        while (opModeIsActive()) {
//            motorLeft.setPower(0);
//            motorRight.setPower(0);
//            double rightInches = convertEncoders(motorRight.getCurrentPosition());
//            double leftInches = convertEncoders(motorRight.getCurrentPosition());
//            //move forward to mountain
//            moveUsingEncoders(3, .5);
//            //turn till facing mountain
//            turn(.8,.2);
//            //move up mountain
//            moveUsingEncoders(3, .5);
            int dist = (int) (12 / encoderConversions);
            moveUsingEncoders(dist, 0.5);
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
    public void moveUsingEncoders(int moveValue, double power) {

        motor1.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor1.setTargetPosition(moveValue);
        motor2.setTargetPosition(moveValue);
        motor1.setPower(power);
        motor2.setPower(power);
    }


}
