package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Emmy on 11/3/2015.
 */
public class MoveToFloorGoal extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {
        CommonRobotInfo robot = new CommonRobotInfo();
        /*
        move forward 2 tiles
        turn 90 degrees to right
        move forward 2 title
         */
        robot.moveUsingEncoders(10, .5); //change to distance for 2 tiles
        robot.turn(-.5, .5); // check turning methods
        robot.moveUsingEncoders(10, .5); //change to distance for 2 tiles

    }
}
