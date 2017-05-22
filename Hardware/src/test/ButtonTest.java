
package test;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.io.IOException;
import hardware.led.RgbLedDigital;
import hardware.button.Button;



	
	public class ButtonTest{
	//Method
	public static void main(String[] args) throws IOException {
		Button redButton = new Button(RaspiPin.GPIO_00);
		Button greenButton = new Button(RaspiPin.GPIO_01);
		Button blueButton = new Button(RaspiPin.GPIO_02);
		RgbLedDigital rgbLed = new RgbLedDigital(RaspiPin.GPIO_27, RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		
		//DualColorLed dualColorLed= new DualColorLed(RaspiPin.GPIO_01, RaspiPin.GPIO_02);
		redButton.setGpioPinListenerDigital(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if(event.getState() == PinState.LOW){
					rgbLed.red(true);
				}
				else{
					rgbLed.red(false);
				}
			}			
		});
		
		greenButton.setGpioPinListenerDigital(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if(event.getState() == PinState.LOW){
					rgbLed.green(true);
				}
				else{
					rgbLed.green(false);
				}
			}			
		});
		
		blueButton.setGpioPinListenerDigital(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if(event.getState() == PinState.LOW){
					rgbLed.blue(true);
				}
				else{
					rgbLed.blue(false);
				}
			}			
		});
		System.out.println("Ready...");
		System.in.read();
	}
	
}

