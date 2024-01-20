package Services;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import dto.Type_Car_Situation;
//import util.Connection;


import java.sql.PreparedStatement;
//import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.Connection;          


public class Type_Car_SituationServices {


	/**
	  * M�todo que permite obtener un listado con todas las situaciones
	  * @return
	  * @throws SQLException
	  * @throws ClassNotFoundException
	  */
	public static LinkedList<Type_Car_Situation> obtenerTypes() throws SQLException, ClassNotFoundException {
	    LinkedList<Type_Car_Situation> list = new LinkedList<Type_Car_Situation>();
	     
	    
	    Connection connection = ServicesLocator.getConnection();
	    ResultSet result = connection.createStatement().executeQuery(" SELECT * FROM \"type_car_situation\"");
	    
	  
	    while (result.next()) {
	    	Type_Car_Situation t = new Type_Car_Situation(result.getInt("id_aut_type_cs"),result.getString("type_cs_name"));
	        list.add(t);
	    }
System.out.println("salio");
	    return list;
	}
	
	
}
