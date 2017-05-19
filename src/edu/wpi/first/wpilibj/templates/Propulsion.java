/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author FIRSTUser
 */
public class Propulsion {
    
    Victor driveMotorFL;
    Victor driveMotorFR;
    Victor driveMotorRL;
    Victor driveMotorRR;
    
    
    public Propulsion(){
        driveMotorFL = new Victor(Constants.FL_drive_motor_port);
        driveMotorFR = new Victor(Constants.FR_drive_motor_port);
        driveMotorRL = new Victor(Constants.RL_drive_motor_port);
        driveMotorRR = new Victor(Constants.RR_drive_motor_port);
        
    }
    
    public void update(){
        driveMotorFL.set(JoystickParty.getDriveVelCmd());
        driveMotorFR.set(-JoystickParty.getDriveVelCmd());
        driveMotorRL.set(JoystickParty.getDriveVelCmd());
        driveMotorRR.set(-JoystickParty.getDriveVelCmd());
    }
    
}
