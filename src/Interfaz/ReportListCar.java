package Interfaz;

import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JInternalFrame;

import Services.ServicesLocator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReportListCar extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportListCar frame = new ReportListCar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Connection myConnection;

	/**
	 * Create the frame.
	 */
	public ReportListCar() {
		setBounds(100, 100, 450, 300);
		
		this.myConnection = ServicesLocator.getConnection();
			
				
				JasperReport report;
				try {
					report = (JasperReport) JRLoader.loadObjectFromFile("src/Reports/Carros.jasper");
					JasperPrint print = JasperFillManager.fillReport(report, null, myConnection);
					JasperViewer view = new JasperViewer(print, false);
					view.setVisible(true);
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//JasperViewer view = new JasperViewer(print, false);
				//view.setVisible(true);
			
		


	}

}
