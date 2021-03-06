/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author FIRSTUser
 */
public class Constants {
    
    //IO Ports
    //Set these once and forget about them
    static int FL_drive_motor_port = 3;
    static int FR_drive_motor_port = 2;
    static int RL_drive_motor_port = 4;
    static int RR_drive_motor_port = 1;
    
    static int R_steer_motor_port = 5;
    static int L_steer_motor_port = 6;
    
    static int R_steer_sensor_port = 2;
    static int L_steer_sensor_port = 1;
    
    //Steering module controller gains
    //Tune these!
    static double R_steer_kP = 0.009;
    static double R_steer_kD = 0.001;
    static double R_steer_kI = 0.0007;

    static double L_steer_kP = 0.009;
    static double L_steer_kD = 0.001;
    static double L_steer_kI = 0.0007;    
    
    //Steering module input conversion constants
    //Tune These!
    static double R_steer_Vzero = 2.50;
    static double R_steer_degPerV = 60.0;
    
    static double L_steer_Vzero = 2.50;
    static double L_steer_degPerV = 60.0;
    
    //Max allowable steering angle
    static double Steer_MaxDeflection_deg = 40.0;
    
    //Drive Velocity Deadzone
    static double FwdRevCmd_Deadzone = 0.1;
    
}
