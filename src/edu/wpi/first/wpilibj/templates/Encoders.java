/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.PIDSource;

/**
 *
 * @author FIRSTUser
 */
public class Encoders implements PIDSource {
    double delt_v;
    double aang;
    double measured_voltage;
    
    double voltsAtZeroAngle = 2.5;
    double degPerVolt = 60.0;
    
    AnalogChannel input_enc;
    
    /**
     * Class to read the present angle of a steering wheel
     * @param port 
     */
    public Encoders(int port){
        input_enc = new AnalogChannel(1, port);
    }
    
    public void setZeroAngleVoltage(double voltage){
        voltsAtZeroAngle = voltage;
    }
    
    public void setDegreesPerVolt(double slope){
        degPerVolt = slope;
    }
    
    public void update(){
        // Read voltage value from encoder
        measured_voltage = input_enc.getVoltage();
    }
    
    public double getVoltage(){
        return measured_voltage;
    }
    
    public double getAngle(){
        
        // Convert to angle
        pot(measured_voltage);
        // Return the measured angle
        return this.aang;
    }
    
    /**
     * Algorithm to convert a voltage into the angle of the wheel 
     * side effects: sets aang
     * @param volt_in voltage measured from encoder
     */
    public void pot(double volt_in){
        delt_v =(volt_in - voltsAtZeroAngle) ;
        aang = delt_v*degPerVolt;
    }

    public double pidGet() {
        return getAngle();
    }
}
