// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.RunMotorCommand;

import com.ctre.phoenix6.hardware.TalonFX;

public class MotorSubsystem extends SubsystemBase {
  private TalonFX motor;
  private Timer timer;
  private double timeToRun = 5;
  
  /** Creates a new ExampleSubsystem. */
  public MotorSubsystem() {
    motor = new TalonFX(Constants.motorId);
    timer = new Timer();
  }

  public void setVoltage(int voltage) {
    motor.setVoltage(voltage);
  }

  public void stopMotor() {
    motor.stopMotor();
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command getCommandToRunMotor() {
    return new RunMotorCommand(this);
  }

  public void startMotor(double runFor) {
    motor.setVoltage(5);
    timer.reset();
    timer.start();
    timeToRun = runFor;
  }

  @Override
  public void periodic() {
    if (timer.hasElapsed(timeToRun)) {
      stopMotor();
    }
  }
}
