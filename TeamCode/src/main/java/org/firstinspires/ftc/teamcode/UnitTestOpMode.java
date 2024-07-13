package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.UnitTests.UnitTest;
import org.firstinspires.ftc.teamcode.UnitTests.WheelsSpeedTest;

@TeleOp(name="Unit Test")
public class UnitTestOpMode extends LinearOpMode {
    private UnitTest unitTest;
    @Override
    public void runOpMode() throws InterruptedException {
        unitTest = new WheelsSpeedTest(hardwareMap, gamepad1, telemetry);
        unitTest.testStart();

        waitForStart();

        while (!isStopRequested() && opModeIsActive())
            unitTest.testPeriodic();
    }
}
