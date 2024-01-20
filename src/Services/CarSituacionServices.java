package Services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date; 
import java.util.LinkedList;

import dto.Car;
import dto.Car_Situation;
import dto.Type_Car_Situation;

public class CarSituacionServices {

    public static void insertarCarSituation(Car_Situation sitCar) throws SQLException, ClassNotFoundException {

        String proCall = "{call \"car_situation_insert\"(?,?,?)}";
        Connection con = ServicesLocator.getConnection();
        CallableStatement cs = con.prepareCall(proCall);

        cs.setDate(1, new java.sql.Date(sitCar.getReturndatecs().getTime()));
        cs.setDate(2, new java.sql.Date(sitCar.getCurrentdatecs().getTime()));
        cs.setInt(3, sitCar.getIdtypesitc());

        cs.executeUpdate();
        con.commit();
        con.close();
    }
    
    
    
    
    public static LinkedList<Car_Situation> obtenerCarSituation() throws SQLException, ClassNotFoundException {
	    LinkedList<Car_Situation> list = new LinkedList<Car_Situation>();
	     
	    
	    Connection connection = ServicesLocator.getConnection();
	    ResultSet result = connection.createStatement().executeQuery(" SELECT * FROM \"car_situation\"");
	    
	  
	    while (result.next()) {
	    	Car_Situation t = new Car_Situation(result.getInt("id_cs"),result.getDate("return_date_cs"),result.getDate("current_date_cs"),result.getInt("id_aut_type_cs"));
	        list.add(t);
	    }
System.out.println("salio2");
	    return list;
	}
    
    
    
    
    
    
    
    
}