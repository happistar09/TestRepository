
package test;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.led.DualColorLed;
import hardware.motor.SG90Servo;
import hardware.sensor.GasSensor;

public class GasSensorBuzzerDualLedServoMotorTest {
	public static void main(String[] args) throws Exception {			
		PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
		GasSensor gasSensor = new GasSensor(pcf8591, RaspiPin.GPIO_00);
		ActiveBuzzer activeBuzzer = new ActiveBuzzer(RaspiPin.GPIO_04);
		DualColorLed dualColorLed = new DualColorLed(RaspiPin.GPIO_02, RaspiPin.GPIO_03);
		SG90Servo sg90Servo = new SG90Servo(RaspiPin.GPIO_01, 8, 25);
		
		while(true) {
			double value = gasSensor.getValue();
			System.out.println(value);
			if(value>200) {
				//방법1: Analog 값을 이용해서 처리
				//System.out.println("******* 화재발생 *******");
				activeBuzzer.on();
				dualColorLed.red();
				sg90Servo.setAngle(180);
			} 
			else{
				activeBuzzer.off();
				dualColorLed.green();
				sg90Servo.setAngle(0);
			}
			
			Thread.sleep(1000);
		}
	}
}
