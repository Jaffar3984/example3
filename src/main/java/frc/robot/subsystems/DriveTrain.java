/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ManualDriveCommand;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
 
  // instantiate new motor controller objects
  public Spark leftFront = new Spark(RobotMap.leftFrontP);
  public Spark leftBack = new Spark(RobotMap.leftBackP);
  public Spark rightFront = new Spark(RobotMap.rightFrontP);
  public Spark rightBack = new Spark(RobotMap.rightBackP);

  //connect front left/right motor to back left/right motor
  SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftFront, leftBack);
  SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(rightFront, rightBack);

  // connect all 4 motors
  public DifferentialDrive drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  // add manualDrive() method
  public void manualDrive(double move,double turn) {
  
    //deadband the joystick/ set macspeed


    drive.arcadeDrive(move, turn);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ManualDriveCommand());
  }
}
