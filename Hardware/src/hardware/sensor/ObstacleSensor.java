package hardware.sensor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.io.IOException;

public class ObstacleSensor {
	//Field
	private GpioPinDigitalInput ObstaclePin;
	
	//Constructor
	public ObstacleSensor(Pin ObstaclePinNo) {
		GpioController gpioController = GpioFactory.getInstance();
		ObstaclePin = gpioController.provisionDigitalInputPin(ObstaclePinNo);
		ObstaclePin.setShutdownOptions(true, PinState.LOW);
	}
	
	public void setGpioPinListenerDigital(GpioPinListenerDigital gpioPinListenerDigital) {
		ObstaclePin.addListener(gpioPinListenerDigital);
	}
	
	public PinState getStatus() {
		return ObstaclePin.getState();
	}
	
	//Method
	public static void main(String[] args) throws IOException {
		ObstacleSensor test = new ObstacleSensor(RaspiPin.GPIO_00);
		test.setGpioPinListenerDigital(event -> {
			//PinState가 LOW면 장애물
			if(event.getState() == PinState.LOW) {
				System.out.println("Obstacle");
			} else {
				System.out.println("No Obstacle");
			}
		});
		
		System.out.println("Ready...");
		System.in.read();
	}
}