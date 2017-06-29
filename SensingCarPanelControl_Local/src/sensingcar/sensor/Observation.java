package sensingcar.sensor;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Observation {

    private static final Logger logger = LoggerFactory.getLogger(Observation.class);

    private double temperature;
    private double photoresistorValue;
    private double gasValue;
    private int distance;
    private int angle;
    private int tracking;

    private CoapClient coapClient1;
    private CoapClient coapClient2;
    private CoapClient coapClient3;
    private CoapClient coapClient4;
    private CoapClient coapClient5;
    private CoapObserveRelation coapObserveRelation1;
    private CoapObserveRelation coapObserveRelation2;
    private CoapObserveRelation coapObserveRelation3;
    private CoapObserveRelation coapObserveRelation4;
    private CoapObserveRelation coapObserveRelation5;

    private String uri = "192.168.35.142";

    private static Observation observation = new Observation();

    private Observation() {
        coapClient1 = new CoapClient();
        coapClient2 = new CoapClient();
        coapClient3 = new CoapClient();
        coapClient4 = new CoapClient();
        coapClient5 = new CoapClient();
        coapClient1.setURI("coap://" + uri + "/thermistorsensor");
        coapClient2.setURI("coap://" + uri + "/photoresistorsensor");
        coapClient3.setURI("coap://" + uri + "/gassensor");
        coapClient4.setURI("coap://" + uri + "/ultrasonicsensor");
        coapClient5.setURI("coap://" + uri + "/trackingsensor");

        coapObserveRelation1 = coapClient1.observe(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                String resJson = response.getResponseText();
                JSONObject jsonObject = new JSONObject(resJson);
                double tmp = Double.parseDouble(jsonObject.getString("temperature"));
                temperature = ((int) (tmp * 10)) / 10.0;
            }

            @Override
            public void onError() {
            }
        });

        coapObserveRelation2 = coapClient2.observe(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                String resJson = response.getResponseText();
                JSONObject jsonObject = new JSONObject(resJson);
                photoresistorValue = Double.parseDouble(jsonObject.getString("photoresistor"));
            }

            @Override
            public void onError() {
            }
        });

        coapObserveRelation3 = coapClient3.observe(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                String resJson = response.getResponseText();
                JSONObject jsonObject = new JSONObject(resJson);
                gasValue = Double.parseDouble(jsonObject.getString("gas"));
            }

            @Override
            public void onError() {
            }
        });

        coapObserveRelation4 = coapClient4.observe(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                String resJson = response.getResponseText();
                JSONObject jsonObject = new JSONObject(resJson);
                distance = Integer.parseInt(jsonObject.getString("distance"));
            }

            @Override
            public void onError() {
            }
        });

        coapObserveRelation5 = coapClient5.observe(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                String resJson = response.getResponseText();
                JSONObject jsonObject = new JSONObject(resJson);
                if (jsonObject.getString("tracking").equals("black")) {
                    tracking = 0;
                } else if (jsonObject.getString("tracking").equals("white")) {
                    tracking = 1;
                }
            }

            @Override
            public void onError() {
            }
        });

    }

    public static Observation getInstance() {
        return observation;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPhotoresistorValue() {
        return photoresistorValue;
    }

    public void setPhotoresistorValue(double photoresistorValue) {
        this.photoresistorValue = photoresistorValue;
    }

    public double getGasValue() {
        return gasValue;
    }

    public void setGasValue(double gasValue) {
        this.gasValue = gasValue;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTracking() {
        return tracking;
    }

    public void setTracking(int tracking) {
        this.tracking = tracking;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

}
