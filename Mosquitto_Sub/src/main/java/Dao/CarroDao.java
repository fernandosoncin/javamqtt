
package Dao;

import Model.CarroM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CarroDao {
    
        public void Salvar (CarroM carro) throws SQLException{
        PreparedStatement pst;
        String sql;          
        sql = "insert into sistema_distribuido_2.carro2 (id, marca, modelo, cor, ano) values (?, ?, ?, ?, ?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, carro.getMarca());
        pst.setString(3, carro.getModelo());
        pst.setString(4, carro.getCor());
        pst.setString(5, carro.getAno());

        pst.execute();
        pst.close();
    }
    
        
public void busca(CarroM carro) {
    
	String sql = "select * from carro where id = ?";
	
	try {
            PreparedStatement pst = Conexao.getInstance().prepareStatement(sql);
		pst.setInt(1, carro.getId());
	
		ResultSet result = pst.executeQuery();
		
		if (result.next()) {
			System.out.println("Buscando:");
			
			carro.setId(result.getInt("id"));
			carro.setMarca(result.getString("marca"));
			carro.setModelo(result.getString("modelo"));
			carro.setCor(result.getString("cor"));
			carro.setAno(result.getString("ano"));
		
			Salvar(carro);
			
		}else {
			System.out.println("Saiu do buscador sem nada!");
		}
		
	} catch(SQLException ex) {
		System.out.println("Erro: " + ex.getMessage());
	}
	
}        
}
