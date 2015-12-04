package com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Amy on 12/4/2015.
 */
public interface RobotInfo {
    HardwareMap hardwareMap = new HardwareMap();
    DcMotor motorLeft = hardwareMap.dcMotor.get("motorLeft");
    DcMotor motorRight = hardwareMap.dcMotor.get("motorRight");
    ColorSensor cSensor = hardwareMap.colorSensor.get("cSensor");
    DcMotor lift = hardwareMap.dcMotor.get("lift");
    DcMotor drum = hardwareMap.dcMotor.get("drum");
}
