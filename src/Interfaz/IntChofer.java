package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import util.Errors;
import util.Validar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

import Services.CarServices;
import Services.CarSituacionServices;
import Services.DriverServices;
import Services.Driver_SituationServices;
import Services.Type_Car_SituationServices;
import Services.Type_Driver_SituationServices;

import com.toedter.calendar.JDateChooser;

import dto.Car;
import dto.Car_Situation;
import dto.Driver;
import dto.Driver_Situation;
import dto.Type_Car_Situation;
import dto.Type_Driver_Situation;

public class IntChofer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDni;
	private JTextField textFieldName;
	private JTextField textFieldAdress;
	private JTextField textFieldCateg;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Type_Driver_SituationServices tds;
	private Driver_SituationServices cdc;
	private DriverServices servicio;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private boolean copiloto = false;
	private Car carro1;
	private CarServices carro2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IntChofer dialog = new IntChofer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public IntChofer() throws ClassNotFoundException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IntChofer.class.getResource("/image/male-user.png")));
		setTitle("Agregar Chofer");
		setResizable(false);
		setBounds(100, 100, 479, 572);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		this.repaint();
		{
			JPanel panelDriver = new JPanel();
			panelDriver.setBorder(new TitledBorder(null, "Chofer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDriver.setBounds(38, 28, 386, 168);
			contentPanel.add(panelDriver);
			panelDriver.setLayout(null);
			{
				JLabel lblDni = new JLabel("DNI:");
				lblDni.setBounds(100, 19, 23, 14);
				panelDriver.add(lblDni);
			}
			
			textFieldDni = new JTextField();
			textFieldDni.setBounds(138, 16, 204, 20);
			panelDriver.add(textFieldDni);
			textFieldDni.setColumns(10);
			
			JLabel lblName = new JLabel("Nombre y Apellidos:");
			lblName.setBounds(10, 55, 118, 14);
			panelDriver.add(lblName);
			
			textFieldName = new JTextField();
			textFieldName.setBounds(138, 52, 204, 20);
			panelDriver.add(textFieldName);
			textFieldName.setColumns(10);
			
			JLabel lblAdress = new JLabel("Direcci\u00F3n Particular:");
			lblAdress.setBounds(10, 91, 118, 14);
			panelDriver.add(lblAdress);
			
			textFieldAdress = new JTextField();
			textFieldAdress.setBounds(138, 88, 204, 20);
			panelDriver.add(textFieldAdress);
			textFieldAdress.setColumns(10);
			
			JLabel lblCateg = new JLabel("Categor\u00EDa:");
			lblCateg.setBounds(68, 127, 60, 14);
			panelDriver.add(lblCateg);
			
			textFieldCateg = new JTextField();
			textFieldCateg.setBounds(138, 124, 205, 20);
			panelDriver.add(textFieldCateg);
			textFieldCateg.setColumns(10);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Carro Fijo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(38, 282, 386, 93);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		
		final JLabel lblNumCar = new JLabel("N\u00FAmero del carro:");
		lblNumCar.setEnabled(false);
		lblNumCar.setBounds(25, 57, 102, 14);
		panel.add(lblNumCar);
		

		
		final JComboBox<String> comboBoxNumCar = new JComboBox<String>();
		comboBoxNumCar.setEnabled(false);
		
		LinkedList<Car> h = new  LinkedList<Car>();
		h = CarServices.obtenerCarrosDisponibles();
		
		
		LinkedList<String> w = new LinkedList<String>();
		ListIterator<Car> iterator2 = h.listIterator();
		
		while(iterator2.hasNext()){
		Car c =iterator2.next();
		
		w.add(c.getCarnumber()) ;
		
	}
		
		
	  for (String q : w)
		 {
	            comboBoxNumCar.addItem(q);
	        }
		
		comboBoxNumCar.setBounds(151, 54, 191, 20);
		panel.add(comboBoxNumCar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Situaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(38, 386, 386, 113);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDate = new JLabel("Fecha:");
		lblDate.setBounds(93, 35, 46, 14);
		panel_1.add(lblDate);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setDate(new Date());
		dateChooser.setMinSelectableDate(new Date());
		dateChooser.setBounds(149, 29, 189, 20);
		panel_1.add(dateChooser);
		
		JRadioButton rdbtnSi2 = new JRadioButton("Si");
		rdbtnSi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNumCar.setEnabled(true);
				comboBoxNumCar.setEnabled(true);
			}
		});
		buttonGroup.add(rdbtnSi2);
		rdbtnSi2.setBounds(76, 20, 48, 23);
		panel.add(rdbtnSi2);
		
		final JRadioButton rdbtnNo2 = new JRadioButton("No");
		rdbtnNo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNumCar.setEnabled(false);
				comboBoxNumCar.setEnabled(false);
				
			}
		});
		rdbtnNo2.setSelected(true);
		buttonGroup.add(rdbtnNo2);
		rdbtnNo2.setBounds(259, 20, 48, 23);
		panel.add(rdbtnNo2);
		
		JLabel lblSituation = new JLabel("Situaci\u00F3n:");
		lblSituation.setBounds(75, 68, 64, 14);
		panel_1.add(lblSituation);
		

		final JComboBox<String> comboBoxSituation = new JComboBox<String>();

		LinkedList<Type_Driver_Situation> t = new  LinkedList<Type_Driver_Situation>();
		t = tds.obtenerTypesDriver();
		
		
		LinkedList<String> x = new LinkedList<String>();
		ListIterator<Type_Driver_Situation> iterator = t.listIterator();
		
		while(iterator.hasNext()){
		Type_Driver_Situation c =iterator.next();
		
		x.add(c.getTypesitdname()) ;
		
	}
		
		
	  for (String c : x)
		 {
	            comboBoxSituation.addItem(c);
	        }
		
	//	comboBox.setModel(new DefaultComboBoxModel(new String[] {"Taller", "Vacaciones", "Franco", "Trabajando en la Ciudad", "Trabajando en el Interior", "Disponible", "Otro"}));
		comboBoxSituation.setBounds(149, 65, 189, 20);
		panel_1.add(comboBoxSituation);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Copiloto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(38, 207, 386, 64);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		final JRadioButton rdbtnSi = new JRadioButton("Si");
		buttonGroup_1.add(rdbtnSi);
		rdbtnSi.setBounds(72, 21, 53, 23);
		panel_2.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setSelected(true);
		buttonGroup_1.add(rdbtnNo);
		rdbtnNo.setBounds(259, 21, 53, 23);
		panel_2.add(rdbtnNo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					/*	String np = textField_1.getText();
						if(Validar.solo_Letras(np))
						   Errors.mostrarError("Nombre y Apellidos incorrectos");*/
						
						//-------------------------------
						
                          String co = comboBoxSituation.getSelectedItem().toString();
						
						int id = 0;
						boolean find = false;
						LinkedList<Type_Driver_Situation> j = new LinkedList<Type_Driver_Situation>();
						try {
							j = tds.obtenerTypesDriver();
							ListIterator<Type_Driver_Situation> iterator = j.listIterator();
							while(iterator.hasNext()&&!find){
								Type_Driver_Situation x =iterator.next();
								if(x.getTypesitdname().equalsIgnoreCase(co))
									id = x.getIdtypesitd();
							}
							}
						 catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println(id + "");
						
						
						

						Driver_Situation sitDriv = new Driver_Situation(dateChooser.getDate(),new Date(),id);
						try {
							Driver_SituationServices.insertarDriverSituation(sitDriv);
							System.out.println("");
							
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						
						int y =0;
						
						
						LinkedList<Driver_Situation> l = new LinkedList<Driver_Situation>();
						try {
							l= cdc.obtenerDriverSituation();
							 y = l.getLast().getDscode();
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						//System.out.println(y + "valorrrrrr");
						
						if(rdbtnSi.isSelected())
							copiloto = true;
						
					    String ka = comboBoxNumCar.getSelectedItem().toString();
						int id2 = 0;
						boolean find2 = false;
						LinkedList<Car> z = new LinkedList<Car>();
						try {
							z = carro2.mostrarCar();
							ListIterator<Car> iterator3 = z.listIterator();
							while(iterator3.hasNext()&&!find2){
								Car x =iterator3.next();
								if(x.getCarnumber().equalsIgnoreCase(ka))
									id2 = x.getIdCar();
							}
							}
						 catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println(id2 + "");
					
						
						
						if(rdbtnNo2.isSelected()){
						
							Driver chofer = new Driver(textFieldDni.getText(),textFieldName.getText(),textFieldAdress.getText(),textFieldCateg.getText(),copiloto,y);
						
						try {
							DriverServices.insertarChofer2(chofer);
							//System.out.println("inserto bien");
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						}
						else{
							
							
					Driver chofer = new Driver(textFieldDni.getText(),textFieldName.getText(),textFieldAdress.getText(),textFieldCateg.getText(),copiloto,y,id2);
						try {
							DriverServices.insertarChofer(chofer);
							System.out.println("inserto bien");
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						}	
						
						dispose();
						
						//---------------------
						}}
				);
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
