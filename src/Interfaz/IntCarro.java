package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

import Services.CarServices;
import dto.Car;
import dto.Car_Situation;
import dto.Type_Car_Situation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import Services.Type_Car_SituationServices;
import Services.CarSituacionServices;

public class IntCarro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNumCar;
	private JTextField textFieldBrand;
	private JTextField textFieldSeat;

	private CarServices servicio;
	private Type_Car_SituationServices tcs;
	private CarSituacionServices csc;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IntCarro dialog = new IntCarro();
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
	public IntCarro() throws ClassNotFoundException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IntCarro.class.getResource("/image/bustransport_bus_4984s.png")));
		setTitle("Agregar Carro");
		setResizable(false);
		setBounds(100, 100, 450, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		this.repaint();
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Carro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(21, 22, 388, 148);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNumCar = new JLabel("N\u00FAmero:");
				lblNumCar.setBounds(81, 25, 62, 14);
				panel.add(lblNumCar);
			}
			{
				JLabel lblBrand = new JLabel("Marca:");
				lblBrand.setBounds(103, 64, 40, 14);
				panel.add(lblBrand);
			}
			{
				JLabel lblSeat = new JLabel("Cantidad de Asientos:");
				lblSeat.setBounds(20, 103, 123, 14);
				panel.add(lblSeat);
			}
			
			textFieldNumCar = new JTextField();
			textFieldNumCar.setBounds(155, 22, 204, 20);
			panel.add(textFieldNumCar);
			textFieldNumCar.setColumns(10);
			
			textFieldBrand = new JTextField();
			textFieldBrand.setBounds(155, 61, 204, 20);
			panel.add(textFieldBrand);
			textFieldBrand.setColumns(10);
			
			textFieldSeat = new JTextField();
			textFieldSeat.setBounds(155, 100, 204, 20);
			panel.add(textFieldSeat);
			textFieldSeat.setColumns(10);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Situaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 181, 388, 114);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDate = new JLabel("Fecha:");
		lblDate.setBounds(97, 30, 46, 14);
		panel.add(lblDate);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setDate(new Date());
		dateChooser.setMinSelectableDate(new Date());
		dateChooser.setBounds(153, 24, 205, 20);
		panel.add(dateChooser);
		
		JLabel lblSituation = new JLabel("Situaci\u00F3n:");
		lblSituation.setBounds(83, 66, 60, 14);
		panel.add(lblSituation);
		
		final JComboBox<String> comboBoxSituation = new JComboBox<String>();
		
		
		
		
		LinkedList<Type_Car_Situation> t = new  LinkedList<Type_Car_Situation>();
		t = tcs.obtenerTypes();
		
		
		LinkedList<String> x = new LinkedList<String>();
		ListIterator<Type_Car_Situation> iterator = t.listIterator();
		
		while(iterator.hasNext()){
		Type_Car_Situation c =iterator.next();
		
		x.add(c.getTypesitcname()) ;
		
	}
		
		
	  for (String c : x)
		 {
	            comboBoxSituation.addItem(c);
	        }
		
		
		
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Taller", "Interior del Pa\u00EDs", "Disponible", "Trabajando en la Ciudad"}));
		
	        comboBoxSituation.setBounds(153, 63, 205, 20);
		panel.add(comboBoxSituation);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						

						String co = comboBoxSituation.getSelectedItem().toString();
						
						int id = 0;
						boolean find = false;
						LinkedList<Type_Car_Situation> j = new LinkedList<Type_Car_Situation>();
						try {
							j = tcs.obtenerTypes();
							ListIterator<Type_Car_Situation> iterator = j.listIterator();
							while(iterator.hasNext()&&!find){
								Type_Car_Situation x =iterator.next();
								if(x.getTypesitcname().equalsIgnoreCase(co))
									id = x.getIdtypesitc();
							}
							}
						 catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println(id + "");
						
						
						

						Car_Situation sitCar = new Car_Situation(dateChooser.getDate(),new Date(),id);
						try {
							CarSituacionServices.insertarCarSituation(sitCar);
							System.out.println("");
							
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						
						int y =0;
						
						
						LinkedList<Car_Situation> l = new LinkedList<Car_Situation>();
						try {
							l= csc.obtenerCarSituation();
							 y = l.getLast().getCscode();
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						//System.out.println(y + "valorrrrrr");
						
						
						Car carro = new Car(textFieldNumCar.getText(),textFieldBrand.getText(),Integer.parseInt(textFieldSeat.getText()),y);
						try {
							CarServices.insertarCarro(carro);
							System.out.println("inserto bien");
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						
						
						
						dispose();
						
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
