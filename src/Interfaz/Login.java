package Interfaz; 

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
	public Login() {
	}

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/image/login2.png")));
		setTitle("Iniciar Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		this.repaint();

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(38, 78, 165, 20);
		contentPane.add(lblNewLabel);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(38, 102, 283, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(38, 170, 283, 20);
		contentPane.add(passwordField);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(38, 145, 83, 14);
		contentPane.add(lblNewLabel_1);

		final JLabel lblNewLabel_ErrorMessage = new JLabel("Nombre de usuario o contrase\u00F1a incorrecto");
		lblNewLabel_ErrorMessage.setForeground(Color.RED);
		lblNewLabel_ErrorMessage.setBounds(52, 201, 269, 20);
		lblNewLabel_ErrorMessage.setVisible(false);
		contentPane.add(lblNewLabel_ErrorMessage);

		final JButton btnNewButton = new JButton("Iniciar Sesi\u00F3n");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()== KeyEvent.VK_ENTER){
					btnNewButton.doClick();
				}
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = textFieldUsuario.getText();
				String password = passwordField.getText();

				boolean valid = valid_User(user, password);
				boolean valid2 = valid_User2(user, password);
				if (!valid) {
					lblNewLabel_ErrorMessage.setVisible(true);
				} else {
					Principal p = new Principal();
					p.setVisible(true);
					dispose();
				}

				if (!valid2) {
					lblNewLabel_ErrorMessage.setVisible(true);

				} else {
					AdminPrincipal ap = new AdminPrincipal();
					ap.setVisible(true);
					dispose();

				}

			}

			private boolean valid_User(String user, String password) {
				boolean result = false;

				if ((user.equalsIgnoreCase("e")) && (password.equalsIgnoreCase("1")))
					result = true;

				return result;
			}

			private boolean valid_User2(String user, String password) {
				boolean result = false;

				if ((user.equalsIgnoreCase("admin")) && (password.equalsIgnoreCase("1234")))
					result = true;

				return result;
			}

		});
		btnNewButton.setBounds(86, 232, 189, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/image/Login.png")));
		lblNewLabel_2.setBounds(145, 11, 64, 69);
		contentPane.add(lblNewLabel_2);

	}
}
