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
public class SteerModuleLeft  {
    Encoders sensor;
    Victor motor;
    PIDController pid;
    
    public SteerModuleLeft(){
        motor = new Victor(Constants.L_steer_motor_port);
        sensor = new Encoders(Constants.L_steer_sensor_port);
        pid = new PIDController(Constants.L_steer_kP, 
                                Constants.L_steer_kI, 
                                Constants.L_steer_kD, 
                                sensor, motor);
        
    }
    
    public void update(){
        
    }
    
    
}