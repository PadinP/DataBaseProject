package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import util.Errors;
import util.Validar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntArrastre extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IntArrastre dialog = new IntArrastre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IntArrastre() {
		setTitle("Agregar Arrastre");
		setBounds(100, 100, 450, 279);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		this.repaint();
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(24, 32, 376, 139);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(174, 11, 163, 20);
			panel.add(dateChooser);
			
			textField = new JTextField();
			textField.setBounds(174, 42, 163, 20);
			panel.add(textField);
			textField.setColumns(10);
			{
				JLabel lblNewLabel = new JLabel(" Fecha:");
				lblNewLabel.setBounds(101, 17, 53, 14);
				panel.add(lblNewLabel);
			}
			
			textField_1 = new JTextField();
			textField_1.setBounds(174, 73, 163, 20);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(174, 104, 163, 20);
			panel.add(textField_2);
			textField_2.setColumns(10);
			{
				JLabel lblNewLabel_3 = new JLabel("  Cantidad de pasajeros:");
				lblNewLabel_3.setBounds(10, 107, 136, 14);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_2 = new JLabel(" Pa\u00EDs:");
				lblNewLabel_2.setBounds(112, 76, 34, 14);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("C\u00F3digo del Grupo:");
				lblNewLabel_1.setBounds(45, 45, 101, 14);
				panel.add(lblNewLabel_1);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String pais = textField_1.getText();
						int pasajeros = Integer.parseInt(textField_2.getText());
						if(Validar.solo_Letras(pais))
							Errors.mostrarError("País Incorrecto");
						if(Validar.pasajeros(pasajeros))
							Errors.mostrarError("Cantidad de Pasajeros incorrecta");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
