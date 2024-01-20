package util;

public class Validar {

	public static boolean solo_Letras(String string){
		boolean comprobar=false;

		if(!string.matches("^[A-Za-z]\\w{2,29}$"))
			comprobar=true;
			
	return comprobar;	
	}
	
	public static boolean pasajeros(int pasajeros){
		boolean comprobar = false;
		
		if(pasajeros>0 && pasajeros<45)
			comprobar = true;
		
		return comprobar;
	}
}
