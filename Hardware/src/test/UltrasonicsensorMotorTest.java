package test;

import com.pi4j.io.gpio.RaspiPin;
import hardware.motor.DCMotor;
import hardware.motor.PCA9685;
import hardware.sensor.UltrasonicSensor;

public class UltrasonicsensorMotorTest {
	
	public static void main(String[] args) throws InterruptedException, Exception {
		UltrasonicSensor test = new UltrasonicSensor(RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		PCA9685 pca9685 = PCA9685.getInstance();
		
		DCMotor motor = new DCMotor(RaspiPin.GPIO_02, RaspiPin.GPIO_03, pca9685, PCA9685.PWM_04);
	}
}
