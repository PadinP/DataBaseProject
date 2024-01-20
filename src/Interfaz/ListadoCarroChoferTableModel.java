package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListadoCarroChoferTableModel extends DefaultTableModel{
	
	public ListadoCarroChoferTableModel(){
		String[] columnNames = {
				"Fecha", "No. del carro", "Nombre y Apellidos del Chofer"};
			this.setColumnIdentifiers(columnNames);
	}
}