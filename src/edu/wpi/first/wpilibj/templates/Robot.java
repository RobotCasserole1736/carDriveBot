/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    //Steering modules - contains sensor & PID controller & Motor
    SteerModuleLeft  leftSteerModule;
    SteerModuleRight rightSteerModule;
    Propulsion driveMotors;
    
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        System.out.println("Hello world!");
        leftSteerModule = new SteerModuleLeft();
        rightSteerModule = new SteerModuleRight();
        driveMotors = new Propulsion();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        leftSteerModule.motor.set(0.3);
        rightSteerModule.motor.set(0.3);
    }
    
    public void disabledInit(){
        //turn off PID's while disabled
        leftSteerModule.disable();
        rightSteerModule.disable();
    }
    
    public void disabledPeriodic(){
        
    }
    
    public void teleopInit(){
        //Reset PID algorithms to zero-state
        leftSteerModule.reset();
        rightSteerModule.reset();
        //Start up PID's before running teleop
        leftSteerModule.enable();
        rightSteerModule.enable();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //Update driver inputs
        JoystickParty.update();
        
        leftSteerModule.sensor.update();
        rightSteerModule.sensor.update();
        
        //Update steering modules
        leftSteerModule.update();
        rightSteerModule.update();
        
        //Update drive motors
        driveMotors.update();
        
    }
    
    public void testInit(){
        //Ensure PID's are off during testing
        leftSteerModule.disable();
        rightSteerModule.disable();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        //These were disabled in the testInit function, so they should not do anything.
        leftSteerModule.sensor.update();
        rightSteerModule.sensor.update();
        
        //Print a bunch of debug info.
        System.out.println("\n============================================");
        System.out.println("Left Voltage: " + Double.toString(leftSteerModule.sensor.getVoltage()) + "V");
        System.out.println("Left Angle: " + Double.toString(leftSteerModule.sensor.getAngle()) + "deg");
        System.out.println("-----");
        System.out.println("Right Voltage: " + Double.toString(rightSteerModule.sensor.getVoltage()) + "V");
        System.out.println("Right Angle: " + Double.toString(rightSteerModule.sensor.getAngle()) + "deg");
        System.out.println("============================================\n");
    
    }
    
}
