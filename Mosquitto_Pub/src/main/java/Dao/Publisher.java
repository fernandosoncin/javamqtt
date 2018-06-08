package Dao;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import View.CarroView;

public class Publisher{
    
    
        private String mensagem;
	private String topico2;
	private int porta2;
	private String host2;
	
	public Publisher(String mensagem, String topico2, int porta2, String host2) {
	this.mensagem = mensagem;
    	this.topico2 = topico2;
    	this.porta2 = porta2;
    	this.host2 = host2;
    }

                public boolean enviarMensagem() {
	    	System.out.println("Publicando mensagem...");
	    	
			try {
				
				MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
				client.connect();
				MqttMessage messagem = new MqttMessage();
				messagem.setPayload(mensagem.getBytes());
				client.publish(topico2, messagem);
                                System.out.println("Mensagem publicada!");
				client.disconnect();
				
				return true;
				
			} catch (MqttException e) {
				System.out.println(e.getMessage());
				
				return false;
			}
	    }
    
	}





