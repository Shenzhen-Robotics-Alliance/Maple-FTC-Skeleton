package org.firstinspires.ftc.teamcode.UnitTests;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class WheelsSpeedTest implements UnitTest {
    private final DcMotorEx[] motors;
    private final Gamepad gamepad;
    private final Telemetry telemetry;
    public WheelsSpeedTest(HardwareMap hardwareMap, Gamepad gamepad, Telemetry telemetry) {
        this.gamepad = gamepad;
        this.telemetry = telemetry;
        this.motors = new DcMotorEx[] {
                hardwareMap.get(DcMotorEx.class, "mot0"),
                hardwareMap.get(DcMotorEx.class, "mot1"),
                hardwareMap.get(DcMotorEx.class, "mot2"),
                hardwareMap.get(DcMotorEx.class, "mot3"),
        };
    }


    @Override
    public void testStart() {

    }

    @Override
    public void testPeriodic() {
        final double power = gamepad.a ? 1:0;
        for (int i = 0; i < motors.length; i++) {
            motors[i].setPower(power);;
            telemetry.addData("motor" + i + " encoder velocity", motors[i].getVelocity());
        }
    }
}
