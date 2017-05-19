/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author FIRSTUser
 */
public class SteerModuleRight  {
    Encoders sensor;
    Victor motor;
    PIDController pid;
    
    public SteerModuleRight(){
        motor = new Victor(Constants.R_steer_motor_port);
        sensor = new Encoders(Constants.R_steer_sensor_port);
        pid = new PIDController(Constants.R_steer_kP, 
                                Constants.R_steer_kI, 
                                Constants.R_steer_kD, 
                                sensor, motor);
        
    }
    
    public void update(){
        pid.setSetpoint(JoystickParty.getDriveAngleCmd());
    }
    
    
}
