package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Brogan Android Code")
public class KrakensMecanumOp extends OpMode {
    KrakensV2_code mecanum = new KrakensV2_code();

    double forward, rotate, strafe;
    public void init(){
        mecanum.init(hardwareMap);
    }

    public void loop(){
        forward = -gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        mecanum.driveFieldRelative(forward, strafe, rotate);

    }
}
