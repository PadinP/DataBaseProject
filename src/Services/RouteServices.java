package Services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import dto.Route;

public class RouteServices {
	
	 public static void insertarRuta(Route ruta) throws SQLException, ClassNotFoundException {
		  
		 String proCall="{call \"route_insert\"(?,?,?,?,?))}";
		 CallableStatement cs = ServicesLocator.getConnection().prepareCall(proCall); 		 
		  cs.setDouble(1, ruta.getKm_available_start());
		  cs.setDouble(2, ruta.getKm_available_end());
		  cs.setString(3, ruta.getPick_up_location());
		  cs.setTime(4,ruta.getEnd_time());
		  cs.setInt(5, ruta.getId_solicitude());

		  
		  cs.executeUpdate();

		 }
	 
	 
	    public static LinkedList<Route> mostrarRuta() throws SQLException, ClassNotFoundException {
		    LinkedList<Route> list = new LinkedList<Route>();
		     
		    String proCall="{? = call select_all_route()}"; // el simbolo de "?" se utiliza para indicar los parametros tanto de entrada como de salida
			CallableStatement cs = ServicesLocator.getConnection().prepareCall(proCall); 	
			cs.registerOutParameter(1, Types.REF_CURSOR); // Se define el valor de retorno de la funcion (En este caso un refcursor)
			cs.execute(); // se ejecuta la llamada a la funcion
			ResultSet result = (ResultSet) cs.getObject(1); // se obtiene el valor de retorno de la funcion (en este caso un refcursor)
		    
		    while (result.next()) {
		    	Route t = new Route(result.getInt("id_route"),result.getDouble("km_available_start"),result.getDouble("km_available_end"),result.getString("pick_up_location"),result.getTime("end_time"),result.getInt("id_solicitude"));
		        list.add(t);

		    }
		    
		    ServicesLocator.getConnection().commit(); // se confirman los cambios
		    
		    return list;
		}

}
