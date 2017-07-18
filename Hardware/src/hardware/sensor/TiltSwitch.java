package hardware.sensor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.io.IOException;

public class TiltSwitch {
	//Field
	private GpioPinDigitalInput tiltPin;
	
	//Constructor
	public TiltSwitch(Pin tiltPinNo) {
		GpioController gpioController = GpioFactory.getInstance();
		tiltPin = gpioController.provisionDigitalInputPin(tiltPinNo);
		tiltPin.setShutdownOptions(true, PinState.LOW);
	}
	
	public void setGpioPinListenerDigital(GpioPinListenerDigital gpioPinListenerDigital) {
		tiltPin.addListener(gpioPinListenerDigital);
	}
	
	public PinState getStatus() {
		return tiltPin.getState();
	}
	
	//Method
	public static void main(String[] args) throws IOException {
		TiltSwitch test = new TiltSwitch(RaspiPin.GPIO_00);
		test.setGpioPinListenerDigital(event -> {
			//PinState가 High면 평탄 Low면 경사
			if(event.getState() == PinState.HIGH) {
				System.out.println("No Tilt");
			} else {
				System.out.println("Tilt");
			}
		});
		
		System.out.println("Ready...");
		System.in.read();
	}
}