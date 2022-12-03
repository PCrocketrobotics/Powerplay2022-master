package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot.Robot;



@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Left", group="Production")

public class Left_Autonmous extends LinearOpMode {
    Robot robot = new Robot (this);
    boolean run;
    public int GetAprilTagID = 0;
    public int AprlTagFound = 0;
    private boolean inInitializationState() {
        return (!opModeIsActive() && !isStopRequested());
    }

@Override

    public void runOpMode(){

        robot.getMecanumDriveTrain().init();
        robot.getImuControl().init();
        robot.getAprilTag_powerplay().init();
        robot.getArm_powerplaY().init();

        sleep(500);

        ElapsedTime timer = new ElapsedTime();
        int count = 0;
        // Stay in this loop until Play Button Pressed on Phone
        while (inInitializationState()) {
            GetAprilTagID = robot.getAprilTag_powerplay().AprilTagID();
            telemetry.addData("",  "----------------------------");
            telemetry.addData(">", "--- Press Play to Start ----");
            telemetry.addData("",  "----------------------------");
            telemetry.addData("AprilTagFound" , GetAprilTagID);
            telemetry.addData("Heading", robot.getImuControl().readimuheading());
            telemetry.addData("", "");
            AprlTagFound= GetAprilTagID;
            telemetry.update();
            sleep(1000);
        }
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                robot.getArm_powerplaY().Right_gripper.setPosition(.6);
                robot.getArm_powerplaY().Left_gripper.setPosition(.4);
                sleep(100);
                //the top claw closes on cone
                robot.getArm_powerplaY().armlift_auto(900);
                sleep(500);
                // the arm is lifted to high needed
                robot.getMecanumDriveTrain().gyroTurn(.4,-70);
                sleep(500);
                // turns robot to an angle of 30
                robot.getMecanumDriveTrain().gyroDrive(14,14,14,14,.4,-70);
                sleep((100));
                // moves forward 10in
                robot.getArm_powerplaY().Left_gripper.setPosition(.52);
                robot.getArm_powerplaY().Right_gripper.setPosition(.45);
                sleep(200);
                //claw opens and drops cone
                robot.getMecanumDriveTrain().gyroDrive(-25,-25,-25,-25,.4,-70);
                sleep(500);
                // robot moves back 10in
                //robot.getMecanumDriveTrain().gyroTurn(.5,0);
                //robot turns to an angle of 0
                robot.getArm_powerplaY().armlift_auto(0);
                //arm drops down
                //robot scans the april tag
                robot.getMecanumDriveTrain().gyroDrive(-6,-6,-6,-6,.4, 0);

                if (AprlTagFound==(1)){
                    robot.getMecanumDriveTrain().gyroDrive(-2,-2,-2,-2,.4,90);


                    robot.getMecanumDriveTrain().gyroTurn(0.4, -90);
                    sleep(100);
                    //robot turns 90
                    robot.getMecanumDriveTrain().gyroDrive(27,27,27,27,.4,-90);
                    sleep(100);
                    //robot drives 19in
                    robot.getMecanumDriveTrain().gyroTurn(0.4, 0);
                    sleep(100);
                    //robot moves back to 0
                    robot.getMecanumDriveTrain().gyroDrive(36,36,36,36,.4,0);
                    sleep(100);
                    //moves 32in forward;
                }
                if(AprlTagFound==(2)) {
                    robot.getMecanumDriveTrain().gyroTurn(0.4, 0);
                    robot.getMecanumDriveTrain().gyroDrive(40, 40, 40, 40, .4, 0);
                    //drives robot 32in forward
                }
                if(AprlTagFound==(3)){
                    robot.getMecanumDriveTrain().gyroDrive(2,2,2,2,.4,0);
                    robot.getMecanumDriveTrain().gyroTurn(0.4,  45);
                    robot.getMecanumDriveTrain().gyroDrive(105, 105, 105,105, .4, 0);
                    robot.getMecanumDriveTrain().gyroTurn(.4,0);


                }

                // telemetry.addData("ring patter", ringpattern);// telemetry.addData("TargetZone", Target_Zone);
                telemetry.addData("", "----------------------------");
                telemetry.addData("sec", String.format("%.2f", timer.seconds()));
                telemetry.addData(">", "Autonomous Done");
                telemetry.addData("AprilTag",AprlTagFound);
                telemetry.update();

                break;
            }
        }

    }
}
