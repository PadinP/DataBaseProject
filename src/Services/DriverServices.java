package Services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

import dto.Car;
import dto.Driver;

public class DriverServices {

	 public static void insertarChofer(Driver chofer) throws SQLException, ClassNotFoundException {
		  
		 String proCall="{call \"driver_insert\"(?,?,?,?,?,?,?)}";
		 Connection con = ServicesLocator.getConnection();
		 CallableStatement cs = con.prepareCall(proCall); 	
		 
		  cs.setString(1, chofer.getDni());
		  cs.setString(2, chofer.getDrivername());
		  cs.setString(3, chofer.getHomeaddress());
		  cs.setString(4, chofer.getCategory());
		  cs.setBoolean(5, chofer.isIscopilot());
		  cs.setInt(6, chofer.getDscode());
		  cs.setInt(7, chofer.getCarnumber());

		  
		  cs.executeUpdate();
		  con.commit();
		  con.close();
		 }
	 
	 
	 
	 public static void insertarChofer2(Driver chofer) throws SQLException, ClassNotFoundException {
		  
		 String proCall="{call \"driver_insert2\"(?,?,?,?,?,?)}";
		 CallableStatement cs = ServicesLocator.getConnection().prepareCall(proCall); 		 
		  cs.setString(1, chofer.getDni());
		  cs.setString(2, chofer.getDrivername());
		  cs.setString(3, chofer.getHomeaddress());
		  cs.setString(4, chofer.getCategory());
		  cs.setBoolean(5, chofer.isIscopilot());
		  cs.setInt(6, chofer.getDscode());
		  

		  
		  cs.executeUpdate();

		 }
	 
	 
	 
	 
	 
	 
	  
	 public static LinkedList<Driver> obtenerDriverDisponibles() throws SQLException, ClassNotFoundException {
	        LinkedList<Driver> list = new LinkedList<Driver>();
	        
	        

	        
	        String proCall="{? = call find_available_drivers()}"; // el simbolo de "?" se utiliza para indicar los parametros tanto de entrada como de salida
			CallableStatement cs = ServicesLocator.getConnection().prepareCall(proCall); 	
			cs.registerOutParameter(1, Types.REF_CURSOR); // Se define el valor de retorno de la funcion (En este caso un refcursor)
			cs.execute(); // se ejecuta la llamada a la funcion
			ResultSet result = (ResultSet) cs.getObject(1); // se obtiene el valor de retorno de la funcion (en este caso un refcursor)
	        
	        
	        while (result.next()) {
	        	Driver t = new Driver(result.getInt("id_driver"), result.getString("dni_driver"), result.getString("driver_name"),result.getString("home_address"),result.getString("category"),result.getBoolean("is_copilot"), result.getInt("id_ds"), result.getInt("id_car"));
	            list.add(t);
	        }

	        System.out.println("salio choferes disponibles");
	        return list;
	    }
	
	 
	 
	 public static LinkedList<Driver> obtenerCopilotDisponibles() throws SQLException, ClassNotFoundException {
	        LinkedList<Driver> list = new LinkedList<Driver>();
	       
	       

	        
	        String proCall="{? = call find_available_copilot()}"; // el simbolo de "?" se utiliza para indicar los parametros tanto de entrada como de salida
			CallableStatement cs = ServicesLocator.getConnection().prepareCall(proCall); 	
			cs.registerOutParameter(1, Types.REF_CURSOR); // Se define el valor de retorno de la funcion (En este caso un refcursor)
			cs.execute(); // se ejecuta la llamada a la funcion
			ResultSet result = (ResultSet) cs.getObject(1); // se obtiene el valor de retorno de la funcion (en este caso un refcursor)
	        
	        
	        while (result.next()) {
	        	Driver t = new Driver(result.getInt("id_driver"), result.getString("dni_driver"), result.getString("driver_name"),result.getString("home_address"),result.getString("category"),result.getBoolean("is_copilot"), result.getInt("id_ds"), result.getInt("id_car"));
	            list.add(t);
	        }

	        System.out.println("salio choferes disponibles");
	        return list;
	    }
	
	 
	
	
}
