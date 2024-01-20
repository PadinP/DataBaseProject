package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

public class CarInterior extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CarInterior dialog = new CarInterior();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CarInterior() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CarInterior.class.getResource("/image/bustransport_bus_4984s.png")));
		setTitle("Situaci\u00F3n del carro");
		setBounds(100, 100, 450, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		this.repaint();
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Fecha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(45, 26, 345, 87);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(155, 33, 146, 20);
			panel.add(dateChooser);
			dateChooser.setDateFormatString("dd/MM/yyyy");
			dateChooser.setDate(new Date());
			dateChooser.setMinSelectableDate(new Date());
			
			JLabel lblFechaDeRegreso = new JLabel("Fecha de regreso:");
			lblFechaDeRegreso.setBounds(30, 33, 106, 20);
			panel.add(lblFechaDeRegreso);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
