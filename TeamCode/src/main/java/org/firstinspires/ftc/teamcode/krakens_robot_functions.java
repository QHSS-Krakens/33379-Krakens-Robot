package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.Servo;


public class krakens_robot_functions extends krakens_robot{
    DcMotor intakeMotor, flyWheel;
    CRServo spindexer, frontRightServo, frontLeftServo;
    public void intake(){
        if (gamepad1.a) {
            // spindexer.setPower(-1);
            frontRightServo.setPower(-1);
            frontLeftServo.setPower(1);
            intakeMotor.setPower(1);
        }
        else {
            frontRightServo.setPower(0);
            frontLeftServo.setPower(0);
            intakeMotor.setPower(0);
        }
    }

    public void outtake(){
        if (gamepad1.b) {
            spindexer.setPower(-1);
            flyWheel.setPower(0.8);
        } else {
            spindexer.setPower(0);
            flyWheel.setPower(0);
        }
    }

    public void runOpMode() throws InterruptedException {


    intakeMotor = hardwareMap.dcMotor.get("intake");
    flyWheel = hardwareMap.dcMotor.get("Shooter");

    //Servo
    spindexer = hardwareMap.get(CRServo.class, "spindexer");
    frontRightServo = hardwareMap.get(CRServo.class, "frontRightServo");
    frontLeftServo = hardwareMap.get(CRServo.class, "frontLeftServo");





    waitForStart();

    if (isStopRequested()) return;

    while (opModeIsActive()) {
        //intake
        /*
        if (gamepad1.a) {
            // spindexer.setPower(-1);
            frontRightServo.setPower(-1);
            frontLeftServo.setPower(1);
            intakeMotor.setPower(1);
        } else {
            frontRightServo.setPower(0);
            frontLeftServo.setPower(0);
            intakeMotor.setPower(0);
        }

         */

        intake();
        outtake();

        }
    }
}
