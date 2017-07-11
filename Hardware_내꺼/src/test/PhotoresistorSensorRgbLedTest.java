package test;

import com.pi4j.io.gpio.RaspiPin;
import hardware.converter.PCF8591;
import hardware.led.RgbLedPWM;
import hardware.sensor.PhotoresistorSensor;

public class PhotoresistorSensorRgbLedTest {
	public static void main(String[] args) throws Exception {
		PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
		PhotoresistorSensor photoresistorSensor = new PhotoresistorSensor(pcf8591);
		RgbLedPWM rgbLed = new RgbLedPWM(RaspiPin.GPIO_00,RaspiPin.GPIO_02,RaspiPin.GPIO_03);
		
		while(true) {
			double value = photoresistorSensor.getValue();
			System.out.println(value);
			if(value>100){
				rgbLed.ledColorSet(0, 255, 0);
			}
			else {
				rgbLed.ledColorSet(255, 0, 0);
			}
			
			
			Thread.sleep(1000);
		}
	}
}
