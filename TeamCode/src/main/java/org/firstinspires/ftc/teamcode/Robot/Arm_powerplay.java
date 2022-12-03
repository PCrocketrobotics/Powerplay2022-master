package org.firstinspires.ftc.teamcode.Robot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm_powerplay {
    public DcMotor Arm_liftMotor;
    public Servo Right_gripper;
    public Servo Left_gripper;
    public Servo Back_Push;
    public Servo Top_Claw;
    Robot robot;
    public Arm_powerplay(Robot robot) {this.robot = robot;}
    public double left_gripper_init = .52;
    public double right_gripper_init = .45;

 public void init (){
       Arm_liftMotor = robot.opMode.hardwareMap.get(DcMotor.class,"armlift");
       Right_gripper = robot.opMode.hardwareMap.get(Servo.class,"right_gripper");
       Left_gripper = robot.opMode.hardwareMap.get(Servo.class,"left_gripper");
       //Back_Push = robot.opMode.hardwareMap.get(Servo.class,"back_push");
       Top_Claw = robot.opMode.hardwareMap.get(Servo.class,"top_claw");


       Arm_liftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

       Arm_liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       Arm_liftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       Arm_liftMotor.setPower(0);

       Top_Claw.setDirection(Servo.Direction.REVERSE);
       Top_Claw.scaleRange(0,1);
       Top_Claw.setPosition(0);

       Left_gripper.scaleRange(0,1);
       Right_gripper.scaleRange(0,1);
       Left_gripper.setPosition(left_gripper_init);
       Right_gripper.setPosition(right_gripper_init);
    }

  public void Arm_lift(){
        Arm_liftMotor.setPower(robot.opMode.gamepad2.left_stick_y);
  }
  public void armlift_auto(int armposition){
      Arm_liftMotor.setTargetPosition(armposition);
      Arm_liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      Arm_liftMotor.setPower(.3);


  }

    public void Arm_lift_Driver(){
        if (robot.opMode.gamepad2.dpad_down){
            Arm_liftMotor.setTargetPosition(0);
            Arm_liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm_liftMotor.setPower(.25);
        }
        if (robot.opMode.gamepad2.x){
            Arm_liftMotor.setTargetPosition(150);
            Arm_liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm_liftMotor.setPower(.7);
        }
        if (robot.opMode.gamepad2.dpad_left){
            Arm_liftMotor.setTargetPosition(900);
            Arm_liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm_liftMotor.setPower(.7);

        }
        if (robot.opMode.gamepad2.dpad_right){
            Arm_liftMotor.setTargetPosition(1563);
            Arm_liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm_liftMotor.setPower(.7);
        }
        if (robot.opMode.gamepad2.dpad_up){
            Arm_liftMotor.setTargetPosition(2069);
            Arm_liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm_liftMotor.setPower(.7);
        }
        if (robot.opMode.gamepad2.right_bumper){
            Arm_liftMotor.setTargetPosition(112);
            Arm_liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm_liftMotor.setPower(.7);
        }
    }
    public void Top_Claw_Open_Close() {
        if (robot.opMode.gamepad2.y) {
            Top_Claw.setPosition(.4);
        } else {
            Top_Claw.setPosition(0);
        }
    }
    public void Top_Claw_Open(){
        Top_Claw.setPosition(0);
    }

    public void  Top_Claw_Close(){
        Top_Claw.setPosition(.4);
    }
    public void Left_Right_gripper_open_close() {
        if (robot.opMode.gamepad2.a) {
            Left_gripper.setPosition(.4);
            Right_gripper.setPosition(.6);
        } else {
            Left_gripper.setPosition(left_gripper_init);
            Right_gripper.setPosition(right_gripper_init);
        }
    }
}
