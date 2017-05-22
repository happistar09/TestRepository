package test;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import hardware.sensor.TrackingSensor;
import java.io.IOException;

public class TrackingSensorBuzzerTest {
	public static void main(String[] args) throws IOException {
		ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_01);
		TrackingSensor sensor = new TrackingSensor(RaspiPin.GPIO_00);
		System.out.println("Ready...");
		while(true){
			if(sensor.getStatus()==PinState.LOW){
				buzzer.on();
			} else{
				buzzer.off();
			}		
		}
		
	}	
}
