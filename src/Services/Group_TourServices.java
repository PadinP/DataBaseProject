package Services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import dto.Group_Tour;
import dto.Programming_Type;

public class Group_TourServices {
	
	 public static void insertarGrupo(Group_Tour grupo) throws SQLException, ClassNotFoundException {
		  
		 String proCall="{call \"group_tour_insert\"(?,?,?)}";
		 Connection con = ServicesLocator.getConnection();
		 CallableStatement cs = con.prepareCall(proCall); 	
		 
		  cs.setInt(1, grupo.getGroup_code());
		  cs.setString(2, grupo.getGroup_country());
		  cs.setInt(3, grupo.getNumber_of_tourists());

		  
		  cs.executeUpdate();
		  con.commit();
		  con.close();
		 }
	 
	 
	    public static LinkedList<Group_Tour> mostrarGrupo() throws SQLException, ClassNotFoundException {
		    LinkedList<Group_Tour> list = new LinkedList<Group_Tour>();
		     
		    
		    Connection connection = ServicesLocator.getConnection();
		    ResultSet result = connection.createStatement().executeQuery(" SELECT * FROM \"group_tour\"");
		    
		  
		    while (result.next()) {
		    	Group_Tour t = new Group_Tour(result.getInt(
						"id_group"),result.getInt("group_code"),result.getString("group_country"),result.getInt("number_of_tourists"));
		        list.add(t);
		    }
	System.out.println("salio7");
		    return list;
		}
	 

}
