package test;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.led.DualColorLed;
import hardware.sensor.FlameSensor;

public class FlameSensorBuzzerDualLedTest {
	public static void main(String[] args) throws Exception {			
		PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
		FlameSensor test = new FlameSensor(pcf8591, RaspiPin.GPIO_00);
		ActiveBuzzer activeBuzzer = new ActiveBuzzer(RaspiPin.GPIO_01);
		DualColorLed dualColorLed = new DualColorLed(RaspiPin.GPIO_02, RaspiPin.GPIO_03);
		
		//방법1 : Digital 핀의 상태를 이용
		test.setGpioPinListenerDigital(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if(event.getState() == PinState.LOW) {
					System.out.println("******* 화재발생 *******");
					activeBuzzer.on();
					dualColorLed.red();
				} else {
					System.out.println("******* 정상상태 *******");
					activeBuzzer.off();
					dualColorLed.green();
				}
			}
		});
		System.in.read();
	}
}
