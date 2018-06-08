
package Dao;

import Model.CarroM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.eclipse.paho.client.mqttv3.MqttClient;


public class CarroDao {

       public void Salvar (CarroM carro) throws SQLException{
        PreparedStatement pst;
        String sql;          
        sql = "insert into carro values (?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, 0);
        pst.setString(2, carro.getMarca());
        pst.setString(3, carro.getModelo());
        pst.setString(4, carro.getCor());
        pst.setString(5, carro.getAno());

        pst.executeUpdate();
        
        try {
            ResultSet result = pst.getGeneratedKeys();
            //System.out.println("chegou aqui 1");
        if (result.next()){
        //System.out.println("chegou aqui 2");
         
              
              System.out.println("ID: " + result.getInt(1));
		    
		    Publisher mosquittoPub = new Publisher(Integer.toString(result.getInt(1)), "id", 1883, "localhost");
		    
		    if (!mosquittoPub.enviarMensagem()){
		    	JOptionPane.showMessageDialog(null, "Erro ao enviar mensagem 'CarroDao'", "Sistema", JOptionPane.ERROR_MESSAGE);
		    }
                    
          }  }catch (Exception ex) {
              Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
          }
        }   
        
    }
 
