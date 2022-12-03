package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot.Robot;


@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="TEST", group="Production")

public class DRIVETEST extends LinearOpMode {
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
            telemetry.update();
            AprlTagFound= GetAprilTagID;
        }
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                //robot.getArm_powerplaY().Top_Claw_Close();
                sleep(1000);
                robot.getArm_powerplaY().armlift_auto(900);
                sleep(1000);
                robot.getMecanumDriveTrain().gyroDrive(12,12,12,12,.2,0);
                sleep(1000);
                robot.getMecanumDriveTrain().gyroTurn(.15, 45);
                sleep(1000);
                robot.getMecanumDriveTrain().gyroTurn(.15, 45);
                sleep(1000);
               // telemetry.addData("ring patter", ringpattern);// telemetry.addData("TargetZone", Target_Zone);
                telemetry.addData("", "----------------------------");
                telemetry.addData("sec", String.format("%.2f", timer.seconds()));
                telemetry.addData(">", "Autonomous Done");
                telemetry.update();
                break;
            }
        }

    }
}
