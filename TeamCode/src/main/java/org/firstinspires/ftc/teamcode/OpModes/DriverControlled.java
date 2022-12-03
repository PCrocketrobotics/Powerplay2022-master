
package org.firstinspires.ftc.teamcode.OpModes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot.*;

/**
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 * The code is structured as a LinearOpMode
 *
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="DriverControlled")
public class DriverControlled extends LinearOpMode {

    /* Declare OpMode members. */
    Robot robot = new Robot(this);

    @Override
    public void runOpMode() {
        // Initialize all the Robot Parts.
        // First Init the Drive Train by setting up the DriveTrain Motors and Sensors.
        telemetry.addData("Robot Initialized ... ", "START");    //
        telemetry.update();
        robot.getMecanumDriveTrain().init();
        robot.getImuControl().init();
        robot.getArm_powerplaY().init();
        robot.getMecanumDriveTrain().left_front.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.getMecanumDriveTrain().left_back.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.getMecanumDriveTrain().right_front.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.getMecanumDriveTrain().right_back.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Robot Initialized ... ", "DONE");    //
        robot.getImuControl().readimuheading();
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // Clear telemetry to clean up screen.
        telemetry.clearAll();


        //PROGRAM STARTS HERE -----------------------------------------------------------------------------------------------
        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // GamePad 1 Control
            robot.getMecanumDriveTrain().DriverControlled_Drive(.75);
            // GamePad 1 Control END

            // GamePad 2 Control
           // robot.getArm_powerplaY().Arm_lift();
            robot.getArm_powerplaY().Top_Claw_Open_Close();
            robot.getArm_powerplaY().Arm_lift_Driver();
            robot.getArm_powerplaY().Left_Right_gripper_open_close();
            // GamePad 2 Control END

            // Telemetry Display
            telemetry.addData("Arm Position", robot.getArm_powerplaY().Top_Claw.getPosition());
            telemetry.addData("IMU Heading", robot.getImuControl().readimuheading());
            telemetry.addData("Arm Encoder", robot.getArm_powerplaY().Arm_liftMotor.getCurrentPosition());
            telemetry.update();
            telemetry.clearAll();
            // PROGRAM ENDS HERE -------------------------------------------------------------------------------------
        }
    }

}

