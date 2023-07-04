package br.inatel.labs.labmqtt.client;

import java.util.Random;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SensorTemperaturaPublisher {
	
	public static void main(String[] args) throws MqttException {
		
		//pt1
		String publisherId = UUID.randomUUID().toString();
		IMqttClient publisher = new MqttClient( MyConstants.URI_BROKER, publisherId);
		
		//pt2
		MqttMessage msg = getTemperatureMessage();
		msg.setQos(0);
		msg.setRetained(true);
		
		//pt3
		MqttConnectOptions options = new MqttConnectOptions();
		options.setAutomaticReconnect(true);
		options.setCleanSession(true);
		options.setConnectionTimeout(10);
		publisher.connect(options);
		
		//pt4.publica
		publisher.publish(MyConstants.TOPIC_1, msg);
		
		
		//pt5.desconecta
		publisher.disconnect();


		
	}
	

	
	private static MqttMessage getTemperatureMessage() {
		Random r = new Random();
		double temperatura = 80 + r.nextDouble() * 20.0;
		byte[] payload = String.format("T:%04.2f", temperatura).getBytes();
		return new MqttMessage(payload);
	}


}
