package com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 *
 * Created by InDenProCom on 10/20/2015.
 */
  public abstract class AutonomousRobotInfo extends LinearOpMode implements RobotInfo
{

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
        motorRight.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motorLeft.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
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
    public ColorSensor getColorSensor() { return cSensor; }
}
