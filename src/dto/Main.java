package dto;

import java.awt.EventQueue;
import java.sql.SQLException;

import Interfaz.Login;
import Services.CarServices;
import Services.ServicesLocator;

public class Main {

	public static void main(String[] args) {
		
		/*try {
			ServicesLocator.establecerConeccion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		

	}

}
