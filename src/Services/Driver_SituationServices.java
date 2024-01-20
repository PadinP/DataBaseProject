package Services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

import dto.Car_Situation;
import dto.Driver;
import dto.Driver_Situation;

public class Driver_SituationServices {

	 public static void insertarDriverSituation(Driver_Situation sitDriv) throws SQLException, ClassNotFoundException {

	        String proCall = "{call \"driver_situation_insert\"(?,?,?)}";
	        Connection con = ServicesLocator.getConnection();
	        CallableStatement cs = con.prepareCall(proCall);

	        
	        cs.setDate(1, new java.sql.Date(sitDriv.getReturndateds().getTime()));
	        cs.setDate(2, new java.sql.Date(sitDriv.getCurrentdateds().getTime()));
	        cs.setInt(3, sitDriv.getIdtypesitd());

	        cs.executeUpdate();
	        con.commit();
			con.close();
	    }
	    
	    
	    
	    
	    public static LinkedList<Driver_Situation> obtenerDriverSituation() throws SQLException, ClassNotFoundException {
		    LinkedList<Driver_Situation> list = new LinkedList<Driver_Situation>();
		     
		    
	        
	        String proCall="{? = call select_all_driver_situation()}"; // el simbolo de "?" se utiliza para indicar los parametros tanto de entrada como de salida
			CallableStatement cs = ServicesLocator.getConnection().prepareCall(proCall); 	
			cs.registerOutParameter(1, Types.REF_CURSOR); // Se define el valor de retorno de la funcion (En este caso un refcursor)
			cs.execute(); // se ejecuta la llamada a la funcion
			ResultSet result = (ResultSet) cs.getObject(1); // se obtiene el valor de retorno de la funcion (en este caso un refcursor)
	        
		  
		    while (result.next()) {
		    	Driver_Situation t = new Driver_Situation(result.getInt("id_ds"),result.getDate("return_date_ds"),result.getDate("current_date_ds"),result.getInt("id_aut_type_ds"));
		        list.add(t);
		    }
	System.out.println("salio4");
		    return list;
		}
	    
	
}
