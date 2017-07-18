package com.mycompany.sensingcarcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    CoapClient coapClient = new CoapClient();
    JSONObject resJsonObject = null;
    CoapResponse coapResponse = null;
    String resJson = null;
    boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void btnBuzzerOn(View v) throws JSONException {
        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "change");
        reqJsonObject.put("status", "on");
        String reqJson = reqJsonObject.toString();
        coapClient.setURI("coap://192.168.3.24/buzzer");
        coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        coapClient.shutdown();

    }

    public void btnBuzzerOff(View v) throws JSONException {
        JSONObject reqJsonObject = new JSONObject();
        reqJsonObject.put("command", "change");
        reqJsonObject.put("status", "off");
        String reqJson = reqJsonObject.toString();
        coapClient.setURI("coap://192.168.3.24/buzzer");
        coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
        coapClient.shutdown();
    }

}
