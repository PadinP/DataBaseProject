package Services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

import dto.Route;
import dto.Solicitude;

public class SolicitudeServices {
	
	 public static void insertarSolicitud (Solicitude solicitud) throws SQLException, ClassNotFoundException {
		  
		 String proCall="{call \"solicitude_insert\"(?,?,?,?,?,?,?,?)}";
		 Connection con = ServicesLocator.getConnection();
		 CallableStatement cs = con.prepareCall(proCall);
		 
		  cs.setTime(1, solicitud.getProgramming_start_time());
		  cs.setString(2, solicitud.getProgramming_to_be_done());
		  cs.setInt(3, solicitud.getDuration_time());
		  cs.setInt(4,solicitud.getId_car());
		  cs.setInt(5, solicitud.getMileage());
		  cs.setInt(6, solicitud.getId_aut_date());
		  cs.setInt(7, solicitud.getId_aut_prog_type());
		  cs.setInt(8,solicitud.getId_group());
			  
		  
		  cs.executeUpdate();
		  con.commit();
		  con.close();
		 }
	 
	 
	    public static LinkedList<Solicitude> mostrarRuta() throws SQLException, ClassNotFoundException {
		    LinkedList<Solicitude> list = new LinkedList<Solicitude>();
		     
		    String proCall="{? = call select_all_solicitude()}"; // el simbolo de "?" se utiliza para indicar los parametros tanto de entrada como de salida
			CallableStatement cs = ServicesLocator.getConnection().prepareCall(proCall); 	
			cs.registerOutParameter(1, Types.REF_CURSOR); // Se define el valor de retorno de la funcion (En este caso un refcursor)
			cs.execute(); // se ejecuta la llamada a la funcion
			ResultSet result = (ResultSet) cs.getObject(1); // se obtiene el valor de retorno de la funcion (en este caso un refcursor)
		    
		    while (result.next()) {
		    	Solicitude t = new Solicitude(result.getInt("id_solicitude"),result.getTime("programming_start_time"),result.getString("programming_to_be_done"),result.getInt("duration_time"),result.getInt("id_car"),result.getInt("mileage"),result.getInt("id_aut_date"),result.getInt("id_aut_prog_type"),result.getInt("id_group"));
		        list.add(t);

		    }
		    
		    ServicesLocator.getConnection().commit(); // se confirman los cambios
		    
		    return list;
		}


}
