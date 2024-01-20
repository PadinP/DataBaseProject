package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListadoSitChoferTableModel extends DefaultTableModel {
	
	public ListadoSitChoferTableModel(){
		String[] columnNames = {
				"Fecha", "Nombre y Apellidos", "Situación", "Fecha de Rregreso"};
			this.setColumnIdentifiers(columnNames);
	}
	
}
