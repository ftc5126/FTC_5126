package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by DICE on 2/5/2016.
 */
public class LEDTest extends OpMode {

    DcMotor test = hardwareMap.dcMotor.get("LED");

    public void init() {

    }

    public void loop() {
        test.setPower(.42);
    }
}
