package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Emmy on 10/29/2015.
 */
public class MoveToRepairZone extends LinearOpMode
{
    CommonRobotInfo robot = new CommonRobotInfo();

    @Override
    public void runOpMode() throws InterruptedException
    {
        /*
        move forward 1 tiles
        turn right
        move forward 2 tiles
        turn right
        move forward tile
        */
        robot.moveUsingEncoders(5, .5); //change to length for one tile
        robot.turn(-.5, .5); // change turn values to correct values for right
        robot.moveUsingEncoders(5, .5); //change to length for 2 tiles
        robot.turn(-.5,.5); // change turn values to correct values for turning right
        robot.moveUsingEncoders(5,.5); //change to correct length






    }
}
