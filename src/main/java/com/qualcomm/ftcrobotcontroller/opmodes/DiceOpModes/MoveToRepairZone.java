package com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes;

import com.qualcomm.ftcrobotcontroller.opmodes.DiceOpModes.AutonomousRobotInfo;

/**
 * Created by Emmy on 10/29/2015.
 */
public class MoveToRepairZone extends AutonomousRobotInfo
{

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
        moveUsingEncoders(5, .5); //change to length for one tile
        turn(-.5, .5); // change turn values to correct values for right
        moveUsingEncoders(5, .5); //change to length for 2 tiles
        turn(-.5,.5); // change turn values to correct values for turning right
        moveUsingEncoders(5,.5); //change to correct length






    }
}
