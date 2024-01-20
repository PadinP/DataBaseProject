package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListadoArrastresTableModel extends DefaultTableModel{
	
	public ListadoArrastresTableModel(){
		String[] columnNames = {
				"Fecha", "Código del Grupo", "País", "Cantidad de Pasajeros","No. de los carros"};
			this.setColumnIdentifiers(columnNames);
	}
}