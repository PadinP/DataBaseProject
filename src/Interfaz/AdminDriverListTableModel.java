package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AdminDriverListTableModel extends DefaultTableModel {
	
	public AdminDriverListTableModel(){
		String[] columnNames = {
				"Usuario", "Contraseña", "Rol" };
			this.setColumnIdentifiers(columnNames);
	}
	
}
