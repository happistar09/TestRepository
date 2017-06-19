package com.mycompany.myapp.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.pi4j.io.gpio.RaspiPin;

import hardware.motor.PCA9685;
import hardware.motor.SG90ServoPCA9685Duration;
import hardware.sensor.UltrasonicSensor;

@Component
public class SensingCarServiceImpl implements SensingCarService {
	
	@Override
	public void changeUltrasonicSensorAngle(int angle) throws Exception {	
		PCA9685 pca9685 = PCA9685.getInstance();
		//PWM_0,11,14,15
		SG90ServoPCA9685Duration servo = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_11);
		servo.setAngle(angle);
	}

	@Override
	public int getUltrasonicSensorDistance() throws Exception {
		UltrasonicSensor ultrasonicSensor = new UltrasonicSensor(RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		int distance = ultrasonicSensor.getDistance();
		return distance;
	}

}
