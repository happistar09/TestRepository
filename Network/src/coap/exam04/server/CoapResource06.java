
package coap.exam04.server;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.sensor.GasSensor;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoapResource06 extends CoapResource {
	//Field
	private int value;
	private PCF8591 pcf8591;	
	private GasSensor gasSensor;
	private int flag=1;
	private ActiveBuzzer activeBuzzer;
	
	
	//Constructor
	public CoapResource06() {
		super("resource06");
		pcf8591 = new PCF8591(0x48, PCF8591.AIN2);
		gasSensor = new GasSensor(pcf8591, RaspiPin.GPIO_23);
		activeBuzzer = new ActiveBuzzer(RaspiPin.GPIO_24);
		//관찰 기능 활성화
		setObservable(true);
		//관찰 기능을 제공한다라는 것을 클라이언트가 알 수 있도록 설정
		getAttributes().setObservable();
		Thread thread = new Thread() {
			@Override
			public void run() {				
				while(true){
					try {
						value = gasSensor.getValue();
					} catch (Exception ex) {}
					changed();				
					try { Thread.sleep(1000); } catch(Exception e) {}
				}
			}			
		};
		thread.start();
		
	}	
	//Method
	@Override
	public void handleGET(CoapExchange exchange) {		
		if(value>150){
			exchange.respond("**가스검출**");
			activeBuzzer.on();
			flag=1;
		} else {
			if(flag==1){
				exchange.respond("**정상상태**");
				activeBuzzer.off();
				flag=0;
			}
		} 
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
		
	}	
	
}
