/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManuallyCommand;

public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

public PWM leftBitch = new PWM(RobotMap.leftBitchPort);
public PWM leftCheek = new PWM(RobotMap.leftCheekPort);
public PWM rightBitch = new PWM(RobotMap.rightBitchPort);
public PWM rightCheek = new PWM(RobotMap.rightCheekPort);

//public DifferentialDrive drive = new DifferentialDrive(leftBitch, rightBitch);

public DriveSubsystem() {
 // leftCheek.follow(leftBitch);
 // rightCheek.follow(rightBitch);
}

public void manualDrive(double move, double turn){

  if (Math.abs(move) < 0.10){
    move = 0;
  }
  if (Math.abs(turn) < 0.10){
    turn = 0;
  }
  //drive.arcadeDrive(move, turn);

  leftBitch.setSpeed(0.25);
  leftCheek.setSpeed(0.25);
  rightBitch.setSpeed(-0.25);
  rightCheek.setSpeed(-0.25);
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveManuallyCommand());
 
  }
}