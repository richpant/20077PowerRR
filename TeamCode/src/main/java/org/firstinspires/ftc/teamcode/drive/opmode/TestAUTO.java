package org.firstinspires.ftc.teamcode.drive;

import static com.qualcomm.robotcore.hardware.DcMotor.*;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name = "TestAuto")
public class TestAUTO extends LinearOpMode {
    private DcMotor lift;


    private Servo claw;


    @Override
    public void runOpMode() {
        lift = hardwareMap.get(DcMotor.class, "lift");
        claw = hardwareMap.get(Servo.class, "claw");

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        //liftMotor.setMode(RunMode.STOP_AND_RESET_ENCODER);
        Pose2d startPose = new Pose2d(-23.6, -69.6, Math.PI / 2);
        drive.setPoseEstimate(startPose);

        //liftMotor.getZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
        TrajectorySequence trajSeq = drive.trajectorySequenceBuilder(startPose)
                .back(34.2)
                .addTemporalMarker(() -> drive.lift(600))
                .addTemporalMarker(() -> claw.setPosition(0.7))
                .waitSeconds(3)
                .addTemporalMarker(() -> claw.setPosition(-0.5))
                .addTemporalMarker(() -> drive.lift(-1700))
                .strafeRight(79)
                .forward(29)
                .addTemporalMarker(()-> lift.setPower(-0.4))
                .waitSeconds(2)
                .addTemporalMarker(()-> lift.setPower(0))
                .back(20)
                .build();
        waitForStart();

        if (!isStopRequested())
            drive.followTrajectorySequence(trajSeq);
    }
   /* public void lift(int encod)
    {

        lift.setTargetPosition(encod);

        lift.setMode(RunMode.RUN_TO_POSITION);

        lift.setPower(1);

    }

    public void duck(int encod)
    {
        lift.setTargetPosition(encod);

        lift.setMode(RunMode.RUN_TO_POSITION);

        lift.setPower(.7);

    }*/
}
