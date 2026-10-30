package org.firstinspires.ftc.teamcode.Functions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class krakens_io extends OpMode {
    DcMotor intakeMotor, flyWheel;
    CRServo spindexer, frontRightServo, frontLeftServo;
    ElapsedTime elapse;
    boolean timerOn;
    double secondsTime;
    @Override
    public void init(){
        intakeMotor = hardwareMap.dcMotor.get("intake");
        flyWheel = hardwareMap.dcMotor.get("Shooter");
        spindexer = hardwareMap.get(CRServo.class, "spindexer");
        frontRightServo = hardwareMap.get(CRServo.class, "frontRightServo");
        frontLeftServo = hardwareMap.get(CRServo.class, "frontLeftServo");
        elapse = new ElapsedTime();
        secondsTime = 0;
        boolean timerOn = false;
    }

    public void loop(){
        if (gamepad1.right_trigger > 0.5) {
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
        //outtake
        if (gamepad1.right_bumper) {
            // spindexer.setPower(-1);
            frontRightServo.setPower(1);
            frontLeftServo.setPower(-1);
            intakeMotor.setPower(-1);
        }
        else {
            frontRightServo.setPower(0);
            frontLeftServo.setPower(0);
            intakeMotor.setPower(0);
        }
            /*
            if (gamepad1.left_trigger > 0.5) {
                flyWheel.setPower(0.9);
                elapse.reset();
                elapse.startTime();
                double seconds = elapse.seconds();
                if(seconds > 0.5){
                    spindexer.setPower(-1);
                }

            }

             */
        //launch
        secondsTime = elapse.seconds();
        if (gamepad1.left_trigger > 0.5) {
            if(!timerOn){
                elapse.reset();
                timerOn = true;
            }
            flyWheel.setPower(0.7);
            if (secondsTime > 1.5) {
                spindexer.setPower(-1);
            }
        }
        else{
            timerOn = false;
            flyWheel.setPower(0);
            spindexer.setPower(0);
        }
    }
}