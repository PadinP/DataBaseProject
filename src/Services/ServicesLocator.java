package Services;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class ServicesLocator {
private static Connection connectionDataBase;
private static ReportServices reportServices;

public static Connection getConnection() throws SQLException {
	Connection connectionDataBase = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base", "postgres", "pasword");
	connectionDataBase.setAutoCommit(false); // se deshabilitan los auto-commit
	return connectionDataBase;
}

/*public static void establecerConeccion () throws SQLException {
	connectionDataBase = DriverManager.getConnection("jdbc:postgresql://localhost:5432/base", "postgres", "pasword");
	connectionDataBase.setAutoCommit(false); // se deshabilitan los auto-commit
}

public static void commit () throws SQLException { // metodo para realizar commit (confirmar los cambios)
	connectionDataBase.commit();
}

public static void roolback () throws SQLException { // metodo para relizar rollback (inhabilitarcambios)
	connectionDataBase.rollback();
}

public static void cerrarConeccion () throws SQLException {
	connectionDataBase.close();
}*/

public static ReportServices getReportServices(){
	
	if(reportServices == null){
		reportServices = new ReportServices();
	}
	return reportServices;
}

}
