
package hardware.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class RgbLed {
private GpioPinDigitalOutput redPin;
	//디지털 출력 핀 객체 필드
private GpioPinDigitalOutput greenPin;
private GpioPinDigitalOutput bluePin;
	
	//Constructor
	public RgbLed(Pin redPinNo, Pin greenPinNo, Pin bluePinNo){
		//GpioController 객체 얻기
		GpioController gpioController = GpioFactory.getInstance();
		//디지털 출력핀 생성
		redPin = gpioController.provisionDigitalOutputPin(redPinNo, PinState.HIGH);
		//애플리케이션이 종료될 때 출력 모드를 해제하고, 핀의 출력을 LOW
		redPin.setShutdownOptions(true, PinState.LOW);
		
		greenPin = gpioController.provisionDigitalOutputPin(greenPinNo, PinState.HIGH);		
		greenPin.setShutdownOptions(true, PinState.LOW);
		
		bluePin = gpioController.provisionDigitalOutputPin(bluePinNo, PinState.HIGH);		
		bluePin.setShutdownOptions(true, PinState.LOW);
	}
	
	//Method
	public void rgb(boolean red, boolean green, boolean blue){
		
		if(red) redPin.low();
		else redPin.high();
		
		if(green) greenPin.low();
		else greenPin.high();
		
		if(blue) bluePin.low();
		else bluePin.high();
	}
	
	
	public void red(boolean state){
		if(state) {
			redPin.low();
		} else {
			redPin.high();
		}
	}
	public void green(boolean state){
		if(state) {
			greenPin.low();
		} else {
			greenPin.high();
		}
	}
	public void blue(boolean state){
		if(state) {
			bluePin.low();
		} else {
			bluePin.high();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		RgbLed test = new RgbLed(RaspiPin.GPIO_27, RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		
				
		while(true) {
			
			test.rgb(true, false, false);
			Thread.sleep(1000);
			test.rgb(false, true, false);
			Thread.sleep(1000);
			test.rgb(false, false, true);
			Thread.sleep(1000);

		}
	
	}
}
