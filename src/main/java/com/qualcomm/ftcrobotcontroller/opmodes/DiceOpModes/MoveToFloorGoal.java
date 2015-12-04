package com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes;

import com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes.AutonomousRobotInfo;


/**
 * Created by Emmy on 11/3/2015.
 */
public class MoveToFloorGoal extends AutonomousRobotInfo
{
    @Override
    public void runOpMode() throws InterruptedException
    {
        /*
        move forward 2 tiles
        turn 90 degrees to right
        move forward 2 title
         */
        moveUsingEncoders(10, .5); //change to distance for 2 tiles
        turn(-.5, .5); // check turning methods
        moveUsingEncoders(10, .5); //change to distance for 2 tiles

    }
}
