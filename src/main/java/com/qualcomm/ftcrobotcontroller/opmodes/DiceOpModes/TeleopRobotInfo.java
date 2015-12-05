package com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.ElapsedTime;
/**
 *
 * Created by InDenProCom on 10/20/2015.
 */
public abstract class TeleopRobotInfo extends OpMode implements RobotInfo
{
    public void hookDown()
    {
        hookServo.setPosition(HOOK_SERVO_DOWN);
    }

    public void moveLift(double power)
    {
        drum.setPower(power);
    }

    public void lowerLift (double power)
    {
        lift.setPower(power);
    }


}
