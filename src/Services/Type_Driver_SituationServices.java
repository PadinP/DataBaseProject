package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import dto.Type_Car_Situation;
import dto.Type_Driver_Situation;

public class Type_Driver_SituationServices {
	
	/**
	  * M�todo que permite obtener un listado con todas las situaciones
	  * @return
	  * @throws SQLException
	  * @throws ClassNotFoundException
	  */
	public static LinkedList<Type_Driver_Situation> obtenerTypesDriver() throws SQLException, ClassNotFoundException {
	    LinkedList<Type_Driver_Situation> list = new LinkedList<Type_Driver_Situation>();
	     
	    
	    Connection connection = ServicesLocator.getConnection();
	    ResultSet result = connection.createStatement().executeQuery(" SELECT * FROM \"type_driver_situation\"");
	    
	  
	    while (result.next()) {
	    	Type_Driver_Situation t = new Type_Driver_Situation(result.getInt("id_aut_type_ds"),result.getString("type_ds_name"));
	        list.add(t);
	    }
//System.out.println("salio3");
	    return list;
	}
	

}
