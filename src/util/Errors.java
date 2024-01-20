package util;
import Interfaz.Error;
	public class Errors {
		
		public static void mostrarError(String mensajeError){
			Error error=new Error(mensajeError);
			error.setVisible(true);
			throw new IllegalArgumentException(mensajeError);
			
		}

	}



