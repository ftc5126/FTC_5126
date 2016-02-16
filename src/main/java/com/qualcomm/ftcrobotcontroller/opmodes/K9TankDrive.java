/* Copyright (c) 2014 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/*
 * TeleOp Mode
 * <p>
 * Enables control of the robot via the gamepad
 */
public class K9TankDrive extends OpMode {

	/*
	 * Note: the configuration of the servos is such that
	 * as the arm servo approaches 0, the arm position moves up (away from the floor).
	 * Also, as the claw servo approaches 0, the claw opens up (drops the game element).
	 */
    // TETRIX VALUES.
	final double HOOK_DOWN = .23;
	final double HOOK_UP = 1;
	final double ARM1_UP = 55 / 255.0;
	final double ARM1_DOWN = 1.0;
	final double ARM2_UP = 205 / 255.0;
	final double ARM2_DOWN = 0;
	boolean toggle = false;
    boolean armToggle = false;

	DcMotor motorRight;
	DcMotor motorLeft;
	DcMotor lift;
	DcMotor winch;
	Servo hook;
	Servo arm1;
	Servo arm2;

	double winchPower;



	/**
	 * Constructor
	 */
    public K9TankDrive() {

	}
	@Override
    public void init() {
        /*
		 * Use the hardwareMap to get the dc motors and servos by name. Note
		 * that the names of the devices must match the names used when you
		 * configured your robot and created the configuration file.
		 */

		motorRight = hardwareMap.dcMotor.get("motor2");
		motorLeft = hardwareMap.dcMotor.get("motor1");
		motorRight.setDirection(DcMotor.Direction.REVERSE);
		//motorLeft.setDirection(DcMotor.Direction.REVERSE);
		motorLeft.setMode(DcMotorController.RunMode.RESET_ENCODERS);
		motorRight.setMode(DcMotorController.RunMode.RESET_ENCODERS);
		motorLeft.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
		motorRight.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);

		lift = hardwareMap.dcMotor.get("lift"); //arm up and down
        winch = hardwareMap.dcMotor.get("winch"); //arm extending
		winch.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
		winch.setDirection(DcMotor.Direction.REVERSE);


		hook = hardwareMap.servo.get("hook");
		arm1 = hardwareMap.servo.get("arm1");
		arm2 = hardwareMap.servo.get("arm2");
		hook.setPosition(HOOK_UP);
		arm1.setPosition(ARM1_UP);
		arm2.setPosition(ARM2_UP);

	}

	/*
	 * This method will be called repeatedly in a loop
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#run()
	 */
	@Override
    public void loop() {

        int leftMotorPostion = motorLeft.getCurrentPosition();
        int rightMotorPostion = motorRight.getCurrentPosition();
        int winchPosiion = winch.getCurrentPosition();
        double hookPosition = hook.getPosition();
		double arm1Position = arm1.getPosition();
		double arm2Position = arm2.getPosition();
		winchPower = gamepad1.left_trigger - gamepad1.right_trigger;


		float left = gamepad1.left_stick_y;
        if (left < .3 && left > -.3) {
            left = 0;
        }
        float right = gamepad1.right_stick_y;

		// scale the joystick value to make it easier to control
		// the robot more precisely at slower speeds.
		right = (float)scaleInput(right);
		left =  (float)scaleInput(left);

		// write the values to the motors
		motorRight.setPower(right);
		motorLeft.setPower(left);
		if (winchPower > 0.05) {
			if (winch.getCurrentPosition() <= 0) {
				winch.setPower(winchPower);
			} else {
				winch.setPower(0);
			}
		} else if (winchPower < -0.05) {
			if (winch.getCurrentPosition() >= -7500) {
				winch.setPower(winchPower);
			} else {
				winch.setPower(0);
			}
		} else {
			winch.setPower(0);
		}

		if (gamepad1.b) {
			if (!toggle) {
				if (hook.getPosition() > .7) {
					hook.setPosition(HOOK_DOWN);
				} else {
                    if (!(hookPosition >= 5)) //if hook is not at max
                    {
                        hook.setPosition(HOOK_UP);
                    }
                }
				toggle = true;
			}
		} else {
			toggle = false;
        }

        if (gamepad1.right_bumper) {
			if (!armToggle) {
				if (arm1.getPosition() < 0.8) {
					arm1.setPosition(ARM1_DOWN);
					arm2.setPosition(ARM2_DOWN);
				} else {
					arm1.setPosition(ARM1_UP);
					arm2.setPosition(ARM2_UP);
				}
				armToggle = true;
			}
		} else {
			armToggle = false;
		}


		if (gamepad1.a) {
			lift.setPower(-.17);
		} else if (gamepad1.y) {
			lift.setPower(.17);
		} else {
			lift.setPower(0);
		}

		/*
		 * Send telemetry data back to driver station. Note that if we are using
		 * a legacy NXT-compatible motor controller, then the getPower() method
		 * will return a null value. The legacy NXT-compatible motor controllers
		 * are currently write only.
		 */

		telemetry.addData("Text", "*** Robot Data***");
		telemetry.addData("left tgt pwr", "left dist " + String.format("%.2f", gamepad1.left_stick_y));
		telemetry.addData("right tgt pwr", "right dist" + String.format("%.2f", gamepad1.right_stick_y));
		telemetry.addData("Winch", "winch postion: " + String.format("%.2f", (double) winchPower));
		telemetry.addData("hook", "hook position:  " + String.format("%.2f", (double) hook.getPosition()));
		telemetry.addData("arm", "arm position:  " + String.format("%.2f", (double) arm1.getPosition()));
		telemetry.addData("arm2", "arm position:  " + String.format("%.2f", (double) arm2.getPosition()));

	}

	/*
	 * Code to run when the op mode is first disabled goes here
	 *
	 * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
	 */
	@Override
	public void stop() {

	}

	/*
	 * This method scales the joystick input so for low joystick values, the
	 * scaled value is less than linear.  This is to make it easier to drive
	 * the robot more precisely at slower speeds.
	 */
	double scaleInput(double dVal)  {
		double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
				0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

		// get the corresponding index for the scaleInput array.
		int index = (int) (dVal * 16.0);

		// index should be positive.
		if (index < 0) {
			index = -index;
		}

		// index cannot exceed size of array minus 1.
		if (index > 16) {
			index = 16;
		}

		// get value from the array.
		double dScale = 0.0;
		if (dVal < 0) {
			dScale = -scaleArray[index];
		} else {
			dScale = scaleArray[index];
		}

		// return scaled value.
		return dScale;
	}

}
