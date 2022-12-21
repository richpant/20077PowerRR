package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 13)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-34, -70, 0))
                                .strafeLeft(65)
                                .lineToLinearHeading(new Pose2d(-30, -12, Math.toRadians(35)))

                                .lineToLinearHeading(new Pose2d(-65, -12, Math.toRadians(180)))
                                .lineToLinearHeading(new Pose2d(-30, -5, Math.toRadians(-90)))
                                .lineToLinearHeading(new Pose2d(-65, -12, Math.toRadians(180)))
                                .lineToLinearHeading(new Pose2d(-30, -5, Math.toRadians(35)))
                                .lineToLinearHeading(new Pose2d(-65, -12, Math.toRadians(180)))
                                .lineToLinearHeading(new Pose2d(-30, -5, Math.toRadians(35)))
                                .lineToLinearHeading(new Pose2d(-65, -12, Math.toRadians(180)))
                                .lineToLinearHeading(new Pose2d(-30, -5, Math.toRadians(35)))
                                .lineToLinearHeading(new Pose2d(-65, -12, Math.toRadians(180)))
                                .lineToLinearHeading(new Pose2d(-30, -5, Math.toRadians(35)))

                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }

}