

package Control;

import javax.swing.JOptionPane;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;


public class Subscriber {
    
        private static String host = "localhost";
	private static int porta = 1883;
	private static String topico = "id";
	
    public static void main( String[] args )
            
    {

		try {
			
			MqttClient client = new MqttClient("tcp://" + host + ":" + porta, MqttClient.generateClientId());
			client.setCallback( new CallBack());
			client.connect();
			client.subscribe(topico);
			
		} catch (MqttException e) {
			System.out.println("Erro: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao tentar conectar com o MQTT!", "Sistema", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
    	
    }
    
}
