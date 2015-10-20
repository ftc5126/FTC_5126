package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by InDenProCom on 10/20/2015.
 */
  public class CommonRobotInfo extends OpMode
{
    DcMotor motorLeft = hardwareMap.dcMotor.get("motorLeft");
    DcMotor motorRight = hardwareMap.dcMotor.get("motorRight");
    ColorSensor cSensor = hardwareMap.colorSensor.get("cSensor");
    DcMotor buttonLeft = hardwareMap.dcMotor.get("buttonLeft");
    DcMotor buttonRight = hardwareMap.dcMotor.get("buttonRight");
    public void init()
    {

    }
    public void loop()
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
    public void turn(double rPower, double lPower, long time )
    {
        ElapsedTime eTime = new ElapsedTime();
        while(eTime.time() < time)
        {
            motorLeft.setPower(rPower);
            motorRight.setPower(lPower);
        }
        motorLeft.setPower(0);
        motorRight.setPower(0);
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
