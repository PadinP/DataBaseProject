package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPrincipal frame = new AdminPrincipal();
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
	public AdminPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminPrincipal.class.getResource("/image/logoApp.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 769);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(AdminPrincipal.class.getResource("/image/TransturrAdmin.jpeg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(0, 21, 159, 728);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIconListUsers = new JLabel("");
		lblIconListUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminUserList au = new AdminUserList();
				au.setVisible(true);				
			}
		});
		lblIconListUsers.setIcon(new ImageIcon(AdminPrincipal.class.getResource("/image/friends2.png")));
		lblIconListUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconListUsers.setBounds(0, 11, 159, 96);
		panel.add(lblIconListUsers);
		
		JLabel lblListUsers = new JLabel("Usuarios");
		lblListUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AdminUserList au = new AdminUserList();
				au.setVisible(true);
			}
		});
		lblListUsers.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblListUsers.setBounds(0, 109, 159, 50);
		panel.add(lblListUsers);
		
		JLabel lblIconAddUser = new JLabel("");
		lblIconAddUser.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				AdminAddUser aau = new AdminAddUser(null);
				aau.setVisible(true);
			}
		});
		lblIconAddUser.setIcon(new ImageIcon(AdminPrincipal.class.getResource("/image/follow2.png")));
		lblIconAddUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAddUser.setBounds(0, 170, 159, 96);
		panel.add(lblIconAddUser);
		
		JLabel lblNewLabel = new JLabel("Agregar Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 277, 159, 50);
		panel.add(lblNewLabel);
		
		JLabel lblIconSearchUser = new JLabel("");
		lblIconSearchUser.setIcon(new ImageIcon(AdminPrincipal.class.getResource("/image/magnifier.png")));
		lblIconSearchUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSearchUser.setBounds(0, 338, 159, 96);
		panel.add(lblIconSearchUser);
		
		JLabel lblSearchUser = new JLabel("Buscar Usuario");
		lblSearchUser.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSearchUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchUser.setBounds(0, 445, 159, 50);
		panel.add(lblSearchUser);
		
		JLabel lblIconInfo = new JLabel("");
		lblIconInfo.setIcon(new ImageIcon(AdminPrincipal.class.getResource("/image/info2.png")));
		lblIconInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconInfo.setBounds(0, 506, 159, 96);
		panel.add(lblIconInfo);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(0, 613, 159, 50);
		panel.add(lblInfo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1367, 21);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminAskLogAut aala = new AdminAskLogAut();
				aala.setVisible(true);
				dispose();
			}
		});
		mntmCerrarSesin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmCerrarSesin.setIcon(new ImageIcon(AdminPrincipal.class.getResource("/image/logout.png")));
		mnArchivo.add(mntmCerrarSesin);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmSalir.setIcon(new ImageIcon(AdminPrincipal.class.getResource("/image/close.png")));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminAskLeave aal = new AdminAskLeave();
				aal.setVisible(true);
				dispose();
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnReportes = new JMenu("Reportes");
		mnReportes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnReportes);
		
		JMenu mnListado = new JMenu("Listado");
		mnListado.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnReportes.add(mnListado);
		
		JMenuItem mntmAdministradores = new JMenuItem("Administradores");
		mntmAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminList al = new AdminList();
				al.setVisible(true);
			}
		});
		mntmAdministradores.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnListado.add(mntmAdministradores);
		
		JMenuItem mntmChofer = new JMenuItem("Choferes");
		mntmChofer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminDriverList ad = new AdminDriverList();
				ad.setVisible(true);
			}
		});
		mntmChofer.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnListado.add(mntmChofer);
		
		JMenuItem mntmDirector = new JMenuItem("Directores");
		mntmDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminDirectorList adr = new AdminDirectorList();
				adr.setVisible(true);
			}
		});
		mntmDirector.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnListado.add(mntmDirector);
		
		JMenu mnHelp = new JMenu("Ayuda");
		mnHelp.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnHelp);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca De");
		mntmAcercaDe.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnHelp.add(mntmAcercaDe);
		
		JMenuItem mntmInformation = new JMenuItem("Informaci\u00F3n");
		mntmInformation.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnHelp.add(mntmInformation);
	}
}
