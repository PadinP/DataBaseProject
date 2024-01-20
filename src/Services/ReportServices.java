package Services;

import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;



public class ReportServices {
	public static ReportServices reports = new ReportServices();

	

	public ReportServices() {
		super();
			
	}

	public void CargarReporteCarros() throws SQLException{
		try {
			
			JasperPrint print = JasperFillManager.fillReport("src/Reports/Carros.jasper", null, ServicesLocator.getConnection());
			JasperViewer.viewReport(print,false);
			
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}
	
	
	public void CargarReporteChoferes() throws SQLException{
		try {
			
			JasperPrint print = JasperFillManager.fillReport("src/Reports/Drivers.jasper", null, ServicesLocator.getConnection());
			JasperViewer.viewReport(print,false);
			
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}
	
	public void CargarReporteSituacionCarros() throws SQLException{
		try {
			
			JasperPrint print = JasperFillManager.fillReport("src/Reports/SituacionCarro.jasper", null, ServicesLocator.getConnection());
			JasperViewer.viewReport(print,false);
			
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}
	
	

}
