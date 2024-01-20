package Services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

import dto.Car;
import dto.Programming_Type;

public class Programming_TypeServices {
	
	 public static void insertarPrograma(Programming_Type prog) throws SQLException, ClassNotFoundException {
		  
		 String proCall="{call \"programming_type_insert\"(?)}";
		 Connection con = ServicesLocator.getConnection();
		 CallableStatement cs = con.prepareCall(proCall); 		 
		  cs.setString(1, prog.getProg_type_name());

		  
		  cs.executeUpdate();
		  con.commit();
		  con.close();
		 }
	 
	 
	    public static LinkedList<Programming_Type> mostrarProg() throws SQLException, ClassNotFoundException {
		    LinkedList<Programming_Type> list = new LinkedList<Programming_Type>();
		     
		    String proCall="{? = call select_all_programming_type()}"; // el simbolo de "?" se utiliza para indicar los parametros tanto de entrada como de salida
			CallableStatement cs = ServicesLocator.getConnection().prepareCall(proCall); 	
			cs.registerOutParameter(1, Types.REF_CURSOR); // Se define el valor de retorno de la funcion (En este caso un refcursor)
			cs.execute(); // se ejecuta la llamada a la funcion
			ResultSet result = (ResultSet) cs.getObject(1); // se obtiene el valor de retorno de la funcion (en este caso un refcursor)
	        
		    
		  
		    while (result.next()) {
		    	Programming_Type t = new Programming_Type(result.getInt("id_aut_prog_type"),result.getString("prog_type_name"));
		        list.add(t);
		    }
	System.out.println("salio9");
		    return list;
		}
	 
	
	

}
