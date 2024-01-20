package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListadoSolicitudesTableModel extends DefaultTableModel {

	public ListadoSolicitudesTableModel(){
		String[] columnNames = {
				"Fecha", "TipoDeProgram", "Código del Grupo", "País","Cantidad de Turistas","Hora de Comienzo"};
			this.setColumnIdentifiers(columnNames);
	}
}
