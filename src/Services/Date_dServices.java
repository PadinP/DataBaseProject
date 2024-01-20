package Services;

import java.sql.CallableStatement;
//import java.sql.Timestamp;//Importante
import java.time.LocalTime;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.Date;
import java.sql.Time;



import dto.Date_d;

public class Date_dServices {
	
	 public static void insertarFecha(Date_d fecha) throws SQLException, ClassNotFoundException {
		  
		 String proCall="{call \"date_d_insert\"(?,?)}";
		 Connection con = ServicesLocator.getConnection();
		 CallableStatement cs = con.prepareCall(proCall); 		 
		 
		 cs.setDate(1, new java.sql.Date(fecha.getId_date().getTime()));
		 cs.setTime(2, fecha.getHour_d() );

		  
		  cs.executeUpdate();
		  con.commit();
		  con.close();

		 }
	 
		
	 
	    public static LinkedList<Date_d > mostrarFechas() throws SQLException, ClassNotFoundException {
		    LinkedList<Date_d > list = new LinkedList<Date_d >();
		     
		    
		    String proCall="{? = call select_all_date_d()}"; // el simbolo de "?" se utiliza para indicar los parametros tanto de entrada como de salida
			CallableStatement cs = ServicesLocator.getConnection().prepareCall(proCall); 	
			cs.registerOutParameter(1, Types.REF_CURSOR); // Se define el valor de retorno de la funcion (En este caso un refcursor)
			cs.execute(); // se ejecuta la llamada a la funcion
			ResultSet result = (ResultSet) cs.getObject(1); // se obtiene el valor de retorno de la funcion (en este caso un refcursor)
		    
		    while (result.next()) {
		    	Date_d  t = new Date_d (result.getInt("id_aut_date"),result.getDate("id_date"),result.getTime("hour_d"));
		        list.add(t);
		    }
		    
		    ServicesLocator.getConnection().commit(); // se confirman los cambios
		    
		    return list;
		}

}
