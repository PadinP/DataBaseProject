package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import dto.User;
import net.miginfocom.swing.MigLayout;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminVerifyUser extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			User user = new User("userdata", "password", "rolefk");
			
			AdminVerifyUser dialog = new AdminVerifyUser(user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminVerifyUser(final User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminVerifyUser.class.getResource("/image/logoApp.jpg")));
		setTitle("Agregar usuario");
		setBounds(100, 100, 403, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 367, 105);
		contentPanel.add(panel);
		panel.setLayout(new MigLayout("", "[87.00px][46px,grow]", "[20.00px][20.00px][20.00px]"));
		
		JLabel lblUserdata = new JLabel("Usuario:");
		panel.add(lblUserdata, "cell 0 0,growx,aligny top");
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		panel.add(lblPassword, "cell 0 1,growx,aligny top");
		
		JLabel lblRole = new JLabel("Rol:");
		panel.add(lblRole, "cell 0 2,growx,aligny top");
		
		JLabel lblUserdata1 = new JLabel(user.getUserdata());
		panel.add(lblUserdata1, "cell 1 0,alignx left,aligny top");
		
		JLabel lblPassword1 = new JLabel(user.getPassworduser());
		panel.add(lblPassword1, "cell 1 1,alignx left,aligny top");
		
		JLabel lblRole1 = new JLabel(user.getRolefk());
		panel.add(lblRole1, "cell 1 2,alignx left,aligny top");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AdminAddedUser aau = new AdminAddedUser(user);
						aau.setVisible(true);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AdminAddUser aau = new AdminAddUser(user);
						aau.setVisible(true);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
