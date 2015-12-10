package com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Amy on 12/4/2015.
 */
public interface RobotInfo {
    HardwareMap hardwareMap = new HardwareMap();
    DcMotor motorLeft = hardwareMap.dcMotor.get("motorLeft");
    DcMotor motorRight = hardwareMap.dcMotor.get("motorRight");
//    Servo hookServo = hardwareMap.servo.get("hookServo");
//    ColorSensor cSensor = hardwareMap.colorSensor.get("cSensor");
//    DcMotor lift = hardwareMap.dcMotor.get("lift");
//    DcMotor drum = hardwareMap.dcMotor.get("drum");
    final int HOOK_SERVO_DOWN = 0;

}
