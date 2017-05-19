/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
/**
 * Class to wrapper the driver joystick into 
 * steering and drive velocity commands
 * @author FIRSTUser
 */
public class JoystickParty {
            
    public static Joystick driverJoy = new Joystick(0);
    private static double steerAxisVal = 0;
    private static double driveAxisVal = 0;
    
    
    public static void update(){
        steerAxisVal = driverJoy.getRawAxis(0);
        driveAxisVal = driverJoy.getRawAxis(1);
    }
    
    //Returns a desired steering angle in degrees
    public static double getDriveAngleCmd(){
        return steerAxisVal * Constants.Steer_MaxDeflection_deg;
    }
    
    //Returns a drive motor command in motor cmd units (-1 to 1)
    public static double getDriveVelCmd(){
        return driveAxisVal;
    }
    
    
}
