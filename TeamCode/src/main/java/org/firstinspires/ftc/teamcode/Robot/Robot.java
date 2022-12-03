package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Robot {
    //public BNO055IMU imu_hub1;
    MecanumDriveTrain  mecanumDriveTrain;
    AprilTag_powerPLAY AprilTag_powerplay;
    IMUControl          imuControl;
    Arm_powerplay arm_powerplaY;

    ElapsedTime autonomusTime;
    final LinearOpMode opMode;

    public Robot (LinearOpMode opMode){
        this.opMode         = opMode;
        this.autonomusTime  = new ElapsedTime();
        this.mecanumDriveTrain     = new MecanumDriveTrain(this);
        this.AprilTag_powerplay = new AprilTag_powerPLAY(this);
        this.imuControl     = new IMUControl(this);
        this.arm_powerplaY = new Arm_powerplay(this);
    }

    public MecanumDriveTrain getMecanumDriveTrain()     {return this.mecanumDriveTrain;}
    public AprilTag_powerPLAY getAprilTag_powerplay()    {return this.AprilTag_powerplay;}
    public IMUControl        getImuControl()     {return this.imuControl;}
    public Arm_powerplay getArm_powerplaY() {return this. arm_powerplaY;}
}
