package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 *
 * Created by InDenProCom on 10/20/2015.
 */
  public class CommonRobotInfo extends LinearOpMode
{
    DcMotor motorLeft = hardwareMap.dcMotor.get("motorLeft");
    DcMotor motorRight = hardwareMap.dcMotor.get("motorRight");
    ColorSensor cSensor = hardwareMap.colorSensor.get("cSensor");
    DcMotor buttonLeft = hardwareMap.dcMotor.get("buttonLeft");
    DcMotor buttonRight = hardwareMap.dcMotor.get("buttonRight");
    public void runOpMode()
    {

    }


    public void moveForward (double power, long time)
    {

        ElapsedTime eTime = new ElapsedTime();

        while (eTime.time() < time)
        {
            motorLeft.setPower(power);
            motorRight.setPower(-power);
        }
        motorLeft.setPower(0);
        motorRight.setPower(0);

    }
    public void moveUsingEncoders(int moveValue, double power)
    {
        motorRight.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motorLeft.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motorRight.setTargetPosition(moveValue);
        motorLeft.setTargetPosition(moveValue);
        motorLeft.setPower(power);
        motorLeft.setPower(power);
    }
    public void turn(double rPower, double lPower)
    {
        motorLeft.setPower(rPower);
        motorRight.setPower(lPower);
        sleep(10);
        motorLeft.setPower(0);
        motorRight.setPower(0);
    }
    public void sleep(long mill)
    {
        ElapsedTime eTime = new ElapsedTime();
        while(eTime.time() < mill)
        {
            motorLeft.setPower(0);
            motorRight.setPower(0);
        }
    }
    public double getColorAlpha() { return cSensor.alpha(); }
    public double getColorBlue() { return cSensor.blue(); }
    public double getColorRed() { return cSensor.red(); }
    public DcMotor getMotorLeft()
    {
        return motorLeft;
    }
    public DcMotor getMotorRight()
    {
        return motorRight;
    }
    public DcMotor getButtonLeft() { return buttonLeft; }
    public DcMotor getButtonRight() { return buttonRight; }
    public ColorSensor getColorSensor() { return cSensor; }
}
