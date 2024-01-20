package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListadoCarrosTableModel extends DefaultTableModel{
	
	public ListadoCarrosTableModel(){
		String[] columnNames = {
				"Número", "Marca", "Cantidad de Asientos", "Kilómetros Disponibles"};
			this.setColumnIdentifiers(columnNames);
	}
}