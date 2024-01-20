package Services;

import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalTime;
import dto.Car;
import dto.Car_Situation;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.sql.Connection;


public class CarServices {
	
	
	 public static void insertarCarro(Car carro) throws SQLException, ClassNotFoundException {
		  
		 String proCall="{call \"car_insert\"(?,?,?,?)}";
		 Connection con = ServicesLocator.getConnection();
		 CallableStatement cs = con.prepareCall(proCall); 		 
		  
		 cs.setString(1, carro.getCarnumber());
		  cs.setString(2, carro.getCarbrand());
		  cs.setInt(3, carro.getNumberofseats());
		  cs.setInt(4, carro.getCscode());
		  
		  cs.executeUpdate();
		  con.commit();
		  con.close();

		 }
	 
		
	 
	    public static LinkedList<Car> mostrarCar() throws SQLException, ClassNotFoundException {
		    LinkedList<Car> list = new LinkedList<Car>();
		     
		    
		    String proCall="{? = call select_all_car()}"; // el simbolo de "?" se utiliza para indicar los parametros tanto de entrada como de salida
			CallableStatement cs = ServicesLocator.getConnection().prepareCall(proCall); 	
			cs.registerOutParameter(1, Types.REF_CURSOR); // Se define el valor de retorno de la funcion (En este caso un refcursor)
			cs.execute(); // se ejecuta la llamada a la funcion
			ResultSet result = (ResultSet) cs.getObject(1); // se obtiene el valor de retorno de la funcion (en este caso un refcursor)
		    
		    while (result.next()) {
		    	Car t = new Car(result.getInt("id_car"),result.getString("car_number"),result.getString("car_brand"),result.getInt("number_of_seats"),result.getInt("id_cs"));
		        list.add(t);
		        System.out.println(result.getInt("id_car") + " " + result.getString("car_number") 
		        + " " + result.getString("car_brand") + " " + result.getInt("number_of_seats") + " " + result.getInt("id_cs"));
		    }
		    
		    ServicesLocator.getConnection().commit(); // se confirman los cambios
		    
		    return list;
		}
	 
	
	    public static LinkedList<Car> obtenerCarrosDisponibles() throws SQLException, ClassNotFoundException {
	        LinkedList<Car> list = new LinkedList<Car>();

	           
	        String proCall="{? = call find_available_cars()}"; // el simbolo de "?" se utiliza para indicar los parametros tanto de entrada como de salida
			CallableStatement cs = ServicesLocator.getConnection().prepareCall(proCall); 	
			cs.registerOutParameter(1, Types.REF_CURSOR); // Se define el valor de retorno de la funcion (En este caso un refcursor)
			cs.execute(); // se ejecuta la llamada a la funcion
			ResultSet result = (ResultSet) cs.getObject(1); // se obtiene el valor de retorno de la funcion (en este caso un refcursor)
	        
	        while (result.next()) {
	            Car t = new Car(result.getInt("id_car"), result.getString("car_number"), result.getString("car_brand"), result.getInt("number_of_seats"), result.getInt("id_cs"));
	            list.add(t);
	        }

	        System.out.println("salio carros disponibles");
	        return list;
	    }
	
	

}
