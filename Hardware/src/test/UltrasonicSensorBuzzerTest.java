package test;
import com.pi4j.io.gpio.RaspiPin;
import hardware.sensor.UltrasonicSensor;
import hardware.buzzer.ActiveBuzzer;

public class UltrasonicSensorBuzzerTest {
	public static void main(String[] args) throws Exception {
		UltrasonicSensor sensor = new UltrasonicSensor(RaspiPin.GPIO_00, RaspiPin.GPIO_01);
		ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_02);
		
		while(true){
			int distance = sensor.getDistance();
			System.out.println("거리(cm) : " + distance);
			if(distance<20){
				buzzer.on();
			} else{
				buzzer.off();
			}
		
			Thread.sleep(1000);
		}
	}
}
