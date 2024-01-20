package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;

import dto.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AdminAddUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldPassword;
	private JTextField textFieldUser;
	private JComboBox comboBoxRoleUser;
	private JLabel lblUser;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdminAddUser dialog = new AdminAddUser(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdminAddUser(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminAddUser.class.getResource("/image/logoApp.jpg")));
		setTitle("Agregar usuario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(32, 21, 370, 124);
		contentPanel.add(panel);
		panel.setLayout(new MigLayout("", "[115px][225px,grow]", "[20px][20px][20px]"));
		
		lblUser = new JLabel("Usuario");
		panel.add(lblUser, "cell 0 0,alignx right,aligny center");
		
		lblPassword = new JLabel("Contrase\u00F1a");
		panel.add(lblPassword, "cell 0 1,alignx right,aligny center");
		
		JLabel lblRoleUser = new JLabel("Rol de usuario");
		panel.add(lblRoleUser, "cell 0 2,alignx right,aligny center");
		
		final JComboBox comboBoxRoleUser = new JComboBox();
		comboBoxRoleUser.setModel(new DefaultComboBoxModel(new String[] {"Chofer", "Administrador", "Directivo"}));
		panel.add(comboBoxRoleUser, "cell 1 2,growx,aligny top");
		
		textFieldPassword = new JTextField();
		panel.add(textFieldPassword, "cell 1 1,growx,aligny top");
		textFieldPassword.setColumns(10);
		
		textFieldUser = new JTextField();
		panel.add(textFieldUser, "cell 1 0,growx,aligny top");
		textFieldUser.setColumns(10);
		
		final JLabel lblErrorMessage = new JLabel("Los datos insertados no son v\u00E1lidos");
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(108, 173, 217, 14);
		lblErrorMessage.setVisible(false);
		
		contentPanel.add(lblErrorMessage);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Continuar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String userdata = textFieldUser.getText();
						String password = textFieldPassword.getText();
						String rolefk = comboBoxRoleUser.getSelectedItem().toString();
						
						boolean valido = verificarDatosUsuario(userdata, password);
						
						if(valido){
							User user = new User(userdata, password, rolefk);
							AdminVerifyUser avu = new AdminVerifyUser(user);
							avu.setVisible(true);
							dispose();
						}
						else {
							lblErrorMessage.setVisible(true);
						}
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		addUserData(user);
	}
	private void addUserData(User user){
		if(user != null){
			textFieldUser.setText(user.getUserdata());
			textFieldPassword.setText(user.getPassworduser());
		}
	}
	
	private boolean verificarDatosUsuario(String userdata, String password){
		boolean result = true;
		
		boolean resultUserdata = validarUserdata(userdata);
		boolean resultPassword = validarPassword(password);
		
		if(!resultUserdata || !resultPassword)
			result = false;
		
		return result;
	}
	
	private boolean validarUserdata(String userdata){
		boolean result = userdata.trim().length() > 3 && userdata.trim().length() <= 30;
		
		if(!result)
			lblUser .setForeground(Color.RED);
		else
			lblUser .setForeground(Color.BLACK);
		
		return result;
	}
	
	private boolean validarPassword(String password){
		boolean result = password.trim().length() > 3 && password.trim().length() <= 15;
		
		if(!result)
			lblPassword.setForeground(Color.RED);
		else
			lblPassword .setForeground(Color.BLACK);
		
		return result;
	}
}
