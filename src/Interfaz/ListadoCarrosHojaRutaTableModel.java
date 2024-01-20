package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListadoCarrosHojaRutaTableModel extends DefaultTableModel{
	
	public ListadoCarrosHojaRutaTableModel(){
		String[] columnNames = {
				"Número", "Marca", "Cantidad de Asientos", "Kilómetros Disponibles"};
			this.setColumnIdentifiers(columnNames);
	}
}