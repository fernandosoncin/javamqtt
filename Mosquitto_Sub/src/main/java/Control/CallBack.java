
package Control;

import Dao.CarroDao;
import Model.CarroM;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class CallBack implements MqttCallback  {
    
    	public void connectionLost(Throwable throwable) {
	    System.out.println("Connection lost!");
	}
	
	public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
		System.out.println(new String(mqttMessage.getPayload()));
		CarroDao CarroD = new CarroDao();
		CarroM Carro = new CarroM();
		Carro.setId(Integer.parseInt(new String(mqttMessage.getPayload())));
		CarroD.busca(Carro);
	}
	
  	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {}
    
}





