package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class Drivetrain extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public PWMVictorSPX leftPrimary = new PWMVictorSPX(Constants.DRIVETRAIN_LEFT_FRONT_MOTOR);
  public PWMVictorSPX leftSecondary = new PWMVictorSPX(Constants.DRIVETRAIN_LEFT_BACK_MOTOR);
  public PWMVictorSPX rightPrimary = new PWMVictorSPX(Constants.DRIVETRAIN_RIGHT_FRONT_MOTOR);
  public PWMVictorSPX rightSecondary = new PWMVictorSPX(Constants.DRIVETRAIN_RIGHT_BACK_MOTOR);

  MotorControllerGroup leftMotors = null;
  MotorControllerGroup rightMotors = null;

  DifferentialDrive differentialDrive = null;

  public Drivetrain() {
    leftMotors = new MotorControllerGroup(leftPrimary, leftSecondary);
    rightMotors = new MotorControllerGroup(rightPrimary, rightSecondary);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  public void DriveInversion(){
    leftMotors.setInverted(true);
    rightMotors.setInverted(true);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setMotors(double leftSpeed, double rightSpeed, double Speed) {
    differentialDrive.arcadeDrive(leftSpeed * Speed, rightSpeed * Speed);
  }
}