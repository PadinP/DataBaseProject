package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import Services.CarServices;
import Services.Date_dServices;
import Services.DriverServices;
import Services.Group_TourServices;
import Services.Programming_TypeServices;
import Services.RouteServices;
import Services.ServicesLocator;
import Services.SolicitudeServices;

import com.toedter.calendar.JDateChooser;

import dto.Car;
import dto.Date_d;
import dto.Driver;
import dto.Group_Tour;
import dto.Programming_Type;
import dto.Route;
import dto.Solicitude;
import dto.Type_Car_Situation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JSpinner;

import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import util.Errors;
import util.Validar;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Time;

public class IntSolicitud extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCountry;
	private JTextField programDsc;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Programming_TypeServices tp;
	private Group_TourServices gt;
	private CarServices cs;
	private DriverServices ds;
	private JTextField textFieldCodGroup;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private Date_dServices fecha;
	private JTextField textFieldPickUp;
	
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IntSolicitud dialog = new IntSolicitud();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public IntSolicitud() throws ClassNotFoundException, SQLException {
		// ServicesLocator.establecerConeccion();
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				IntSolicitud.class.getResource("/image/document.png")));
		setTitle("Solicitud");
		setBounds(100, 100, 558, 853);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		this.repaint();

		JPanel panelProgram = new JPanel();
		panelProgram.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Programaci\u00F3n",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panelProgram.setBounds(37, 24, 455, 190);
		contentPanel.add(panelProgram);
		panelProgram.setLayout(null);

		JLabel lblprogram = new JLabel("Programaci\u00F3n:");
		lblprogram.setBounds(115, 91, 89, 14);
		panelProgram.add(lblprogram);

		final JComboBox<String> comboBoxProgram = new JComboBox<String>();

		LinkedList<Programming_Type> t = new LinkedList<Programming_Type>();
		t = tp.mostrarProg();

		LinkedList<String> x = new LinkedList<String>();
		ListIterator<Programming_Type> iterator = t.listIterator();

		while (iterator.hasNext()) {
			Programming_Type c = iterator.next();

			x.add(c.getProg_type_name());

		}

		for (String c : x) {
			comboBoxProgram.addItem(c);
		}

		comboBoxProgram.setBounds(214, 85, 211, 20);
		panelProgram.add(comboBoxProgram);
		// comboBox.setModel(new DefaultComboBoxModel(new String[] {"transfer",
		// "visita", "circuito", "excursi\u00F3n"}));

		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(214, 25, 211, 20);
		panelProgram.add(dateChooser);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setDate(new Date());
		// dateChooser.setMinSelectableDate(new Date());

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(155, 25, 43, 23);
		panelProgram.add(lblFecha);

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(165, 58, 35, 14);
		panelProgram.add(lblHora);

		JLabel lblKilometraje = new JLabel("Kilometraje:");
		lblKilometraje.setBounds(125, 122, 79, 16);
		panelProgram.add(lblKilometraje);

		final JSpinner spinnerKm = new JSpinner();
		spinnerKm.setBounds(214, 118, 211, 22);
		panelProgram.add(spinnerKm);

		JLabel lblDelayTime = new JLabel("Tiempo de demora:");
		lblDelayTime.setBounds(90, 151, 114, 16);
		panelProgram.add(lblDelayTime);

		final JSpinner spinnerDelayTime = new JSpinner();
		spinnerDelayTime.setBounds(214, 148, 211, 22);
		panelProgram.add(spinnerDelayTime);

		final JSpinner spinnerHour = new JSpinner();
		spinnerHour.setModel(new SpinnerNumberModel(1, 1, 24, 1));
		spinnerHour.setBounds(214, 58, 56, 22);
		panelProgram.add(spinnerHour);

		final JSpinner spinnerMinutes = new JSpinner();
		spinnerMinutes.setBounds(346, 58, 79, 22);
		panelProgram.add(spinnerMinutes);
		
		JLabel lblminutes = new JLabel("Minutos:");
		lblminutes.setBounds(282, 61, 56, 16);
		panelProgram.add(lblminutes);

		JPanel panelTourist = new JPanel();
		panelTourist.setBorder(new TitledBorder(null, "Grupo Tur\u00EDstico",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelTourist.setBounds(37, 227, 455, 273);
		contentPanel.add(panelTourist);
		panelTourist.setLayout(null);

		final JLabel lblTouristNum = new JLabel("Cantidad de turistas:");
		lblTouristNum.setEnabled(false);
		lblTouristNum.setBounds(84, 200, 122, 14);
		panelTourist.add(lblTouristNum);

		final JLabel lblCountry = new JLabel("Pa\u00EDs de prodecencia:");
		lblCountry.setEnabled(false);
		lblCountry.setBounds(84, 170, 122, 14);
		panelTourist.add(lblCountry);

		textFieldCountry = new JTextField();
		textFieldCountry.setEnabled(false);
		textFieldCountry.setBounds(218, 167, 211, 20);
		panelTourist.add(textFieldCountry);
		textFieldCountry.setColumns(10);

		final JLabel lblCodGroup = new JLabel("C\u00F3digo del Grupo:");
		lblCodGroup.setBounds(84, 29, 122, 17);
		panelTourist.add(lblCodGroup);

		JLabel lblprogramDsc = new JLabel(
				"Descripci\u00F3n de la Programaci\u00F3n:");
		lblprogramDsc.setBounds(20, 234, 186, 17);
		panelTourist.add(lblprogramDsc);

		programDsc = new JTextField();
		programDsc.setBounds(218, 231, 211, 20);
		panelTourist.add(programDsc);
		programDsc.setColumns(10);

		final JComboBox<String> comboBoxCodGrup = new JComboBox<String>();

		LinkedList<Group_Tour> g = new LinkedList<Group_Tour>();
		g = gt.mostrarGrupo();

		LinkedList<Integer> z = new LinkedList<Integer>();
		ListIterator<Group_Tour> iterator2 = g.listIterator();

		while (iterator2.hasNext()) {
			Group_Tour c2 = iterator2.next();

			z.add(c2.getGroup_code());
		}

		for (Integer c2 : z) {
			comboBoxCodGrup.addItem(String.valueOf(c2));
		}

		comboBoxCodGrup.setBounds(216, 27, 211, 20);
		panelTourist.add(comboBoxCodGrup);

		final JSpinner spinnerNumTourist = new JSpinner();
		spinnerNumTourist.setEnabled(false);
		spinnerNumTourist.setModel(new SpinnerNumberModel(1, 1, 45, 1));
		spinnerNumTourist.setBounds(218, 197, 211, 20);
		panelTourist.add(spinnerNumTourist);

		JPanel panelNewGroup = new JPanel();
		panelNewGroup.setLayout(null);
		panelNewGroup.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Crear Grupo Nuevo",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panelNewGroup.setBounds(22, 59, 412, 90);
		panelTourist.add(panelNewGroup);

		final JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setEnabled(false);
		lblCdigo.setBounds(129, 56, 56, 14);
		panelNewGroup.add(lblCdigo);

		final JRadioButton  radioButtonSi = new JRadioButton("Si");
		buttonGroup_1.add(radioButtonSi);
		radioButtonSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldCodGroup.setEnabled(true);
				lblCdigo.setEnabled(true);
				comboBoxCodGrup.setEnabled(false);
				lblCodGroup.setEnabled(false);
				textFieldCountry.setEnabled(true);
				spinnerNumTourist.setEnabled(true);
				lblCountry.setEnabled(true);
				lblTouristNum.setEnabled(true);

			}
		});
		radioButtonSi.setBounds(71, 24, 56, 23);
		panelNewGroup.add(radioButtonSi);

		final JRadioButton radioButtonNo = new JRadioButton("No");
		buttonGroup_1.add(radioButtonNo);
		radioButtonNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldCodGroup.setEnabled(false);
				lblCdigo.setEnabled(false);
				comboBoxCodGrup.setEnabled(true);
				lblCodGroup.setEnabled(true);
				textFieldCountry.setEnabled(false);
				spinnerNumTourist.setEnabled(false);
				lblCountry.setEnabled(false);
				lblTouristNum.setEnabled(false);

			}
		});
		radioButtonNo.setSelected(true);
		radioButtonNo.setBounds(304, 24, 56, 23);
		panelNewGroup.add(radioButtonNo);

		textFieldCodGroup = new JTextField();
		textFieldCodGroup.setEnabled(false);
		textFieldCodGroup.setBounds(197, 53, 203, 20);
		panelNewGroup.add(textFieldCodGroup);
		textFieldCodGroup.setColumns(10);

		JPanel panelCar = new JPanel();
		panelCar.setBorder(new TitledBorder(null, "Carro Asignado",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCar.setBounds(37, 513, 455, 91);
		contentPanel.add(panelCar);
		panelCar.setLayout(null);

		JLabel lblNumCar = new JLabel("N\u00FAmero del Carro:");
		lblNumCar.setBounds(81, 37, 116, 14);
		panelCar.add(lblNumCar);

		final JComboBox<String> comboBoxNumCar = new JComboBox<String>();
		comboBoxNumCar.setBounds(215, 34, 209, 20);

		LinkedList<Car> availables_cars = new LinkedList<Car>();
		availables_cars = cs.obtenerCarrosDisponibles();

		LinkedList<String> carsNumber = new LinkedList<String>();
		ListIterator<Car> iterator3 = availables_cars.listIterator();

		while (iterator3.hasNext()) {
			Car c3 = iterator3.next();

			carsNumber.add(c3.getCarnumber());
		}

		for (String c3 : carsNumber) {
			comboBoxNumCar.addItem(c3);
		}
		panelCar.add(comboBoxNumCar);

		/*
		 * LinkedList<Driver> obtenerDriver = new LinkedList<Driver>();
		 * obtenerDriver = ds.obtenerDriverDisponibles();
		 * 
		 * LinkedList<String> driverName = new LinkedList<String>();
		 * ListIterator<Driver> iterator4 = obtenerDriver.listIterator();
		 * 
		 * while(iterator4.hasNext()){ Driver d3 =iterator4.next();
		 * 
		 * driverName.add(d3.getDrivername()) ; }
		 * 
		 * for (String d3 : driverName) { comboBox_6.addItem(d3); }
		 */

		/*
		 * LinkedList<Driver> obtenerDriver2 = new LinkedList<Driver>();
		 * obtenerDriver2 = DriverServices.obtenerCopilotDisponibles();
		 * 
		 * LinkedList<String> copilotName = new LinkedList<String>();
		 * ListIterator<Driver> iterator5 = obtenerDriver2.listIterator();
		 * 
		 * while(iterator5.hasNext()){ Driver d7 =iterator5.next();
		 * 
		 * copilotName.add(d7.getDrivername()) ; }
		 * 
		 * for (String d7 : copilotName) { comboBox_2.addItem(d7); }
		 */

		JPanel panelRut = new JPanel();
		panelRut.setLayout(null);
		panelRut.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Ruta",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panelRut.setBounds(37, 617, 455, 141);
		contentPanel.add(panelRut);

		JLabel labelPickUp = new JLabel("Lugar de Recogida:");
		labelPickUp.setBounds(87, 26, 125, 14);
		panelRut.add(labelPickUp);

		textFieldPickUp = new JTextField();
		textFieldPickUp.setColumns(10);
		textFieldPickUp.setBounds(231, 23, 196, 20);
		panelRut.add(textFieldPickUp);

		JLabel labelBeginKm = new JLabel("Km disponibles al comenzar:");
		labelBeginKm.setBounds(44, 61, 168, 14);
		panelRut.add(labelBeginKm);

		JLabel labelEndKm = new JLabel("Km disponibles al terminar:");
		labelEndKm.setBounds(54, 94, 158, 14);
		panelRut.add(labelEndKm);

		final JSpinner spinnerBeginKm = new JSpinner();
		spinnerBeginKm.setBounds(231, 56, 196, 20);
		panelRut.add(spinnerBeginKm);

		final JSpinner spinnerEndKm = new JSpinner();
		spinnerEndKm.setBounds(231, 91, 196, 20);
		panelRut.add(spinnerEndKm);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						// ---------------------------------------------------

						String co = comboBoxNumCar.getSelectedItem().toString();

						int id = 0;
						boolean find = false;
						LinkedList<Car> j = new LinkedList<Car>();
						try {
							j = CarServices.obtenerCarrosDisponibles();
							ListIterator<Car> iterator1 = j.listIterator();
							while (iterator1.hasNext() && !find) {
								Car x = iterator1.next();
								if (x.getCarnumber().equalsIgnoreCase(co)) {
									id = x.getIdCar();
									find = true;

								}
							}
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						System.out.println(id + "");

						// ----------------------------------------------

						String co1 = comboBoxProgram.getSelectedItem().toString();

						int idProgType = 0;
						boolean find1 = false;
						LinkedList<Programming_Type> k = new LinkedList<Programming_Type>();
						try {
							k = Programming_TypeServices.mostrarProg();
							ListIterator<Programming_Type> iterator2 = k
									.listIterator();
							while (iterator2.hasNext() && !find1) {
								Programming_Type x = iterator2.next();
								if (x.getProg_type_name().equalsIgnoreCase(co1)) {
									idProgType = x.getId_aut_prog_type();
									find = true;

								}
							}
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						System.out.println(id + "");

						int cant = (int) spinnerHour.getValue();
						int miliseg = cant * 3600000;

						// Crea un objeto Time a partir del valor del entero
						// Time tiempo = new Time(cant * 60 * 60 * 1000L);

						// Time tiempo = new Time(miliseg);
						// Object valorSpinner = spinner.getValue();
						// int cant = (int) spinner.getValue();

						Time valueHour = java.sql.Time.valueOf(spinnerHour.getValue()
								.toString()
								+ ":"
								+ spinnerMinutes.getValue().toString() + ":00");

						//Date_d tiempo1 = new Date_d(dateChooser.getDate()); // variable que recibe la fecha selecionada por el usuario
						//tiempo1.setId_date(dateChooser.getDate());
						Date_d dAux2 = new Date_d(dateChooser.getDate(), valueHour);

						//int dAut; // variable que almacena el identificador autogenerado de la fecha
						try {
							boolean find2 = false;
							LinkedList<Date_d> d = new LinkedList<Date_d>(); // lista para guardar las fechas de la bd
							d = Date_dServices.mostrarFechas(); //llenar la lista con las fechas de la bd
							 ListIterator<Date_d> it2 = d.listIterator();
							while (it2.hasNext() && !find2 ) { 
								Date_d dAux = it2.next();
								int comparison = dAux.getId_date().compareTo(dateChooser.getDate());
									if (comparison == 0) {
									dAux2 = dAux;
									find2 = true;
										System.out.println("date1 es igual a date2");
									}
									
									

							}
							if (!find2) {
								Date_dServices.insertarFecha(dAux2);
								dAux2 = Date_dServices.mostrarFechas().getLast();
							}
						
							//tiempo1 = d.getFirst();
							 
						} catch (ClassNotFoundException | SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

						// if(radioButton_1.isSelected()){
						// Integer.parseInt(comboBox_4.getSelectedItem().toString());
						int id4 = 0;
						String groupStr = comboBoxCodGrup.getSelectedItem().toString();
						System.out.println("***************************** grupo seleccionado " + groupStr);
						int idGroupSelect = Integer.parseInt(groupStr);
						System.out.println("***************************** conversiona entero del seleccionado "+ idGroupSelect);
						boolean find4 = false;
						LinkedList<Group_Tour> listGroup = new LinkedList<Group_Tour>();
						try {
							listGroup = Group_TourServices.mostrarGrupo();
							ListIterator<Group_Tour> iter5 = listGroup.listIterator();
							while (iter5.hasNext() && !find4 && radioButtonNo.isSelected()) {
								Group_Tour g = iter5.next();
								if (g.getGroup_code() == idGroupSelect) {
									id4 = g.getId_group();
									find4 = true;
								}

							}
							if (!find4 && radioButtonSi.isSelected()) {
								int codGroup = Integer.parseInt(textFieldCodGroup.getText());
								String country = textFieldCountry.getText();
								int numTourist = (int) spinnerNumTourist.getValue();

								Group_Tour group_Tour = new Group_Tour(codGroup, country, numTourist);
								Group_TourServices.insertarGrupo(group_Tour);
								id4 = Group_TourServices.mostrarGrupo().getLast().getId_group();

								System.out.println(id4+"id grupo");
							}

						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						System.out.println(id + "");

						// }
						/*
						 * else{ Object valorSpinner1 = spinner_1.getValue();
						 * int cantq = (Integer) valorSpinner1;
						 * 
						 * int code = Integer.parseInt(textField_1.getText());
						 * Group_Tour grupo = new
						 * Group_Tour(code,textField.getText(),cantq);
						 * id4=grupo.getId_group(); }
						 */

						Object valorSpinner2 = spinnerDelayTime.getValue();
						int cant2 = (Integer) valorSpinner2;

						Object valorSpinner5 = spinnerKm.getValue();
						int cant5 = (Integer) valorSpinner5;

						
					

						final Solicitude solicitud = new Solicitude(valueHour,
								programDsc.getText(), cant2, id, cant5, dAux2.getId_aut_date() , idProgType, id4);
							System.out.println("*****************************" + dAux2.getId_aut_date());
																						
						try {
							SolicitudeServices.insertarSolicitud(solicitud);
							System.out.println("inserto solicitud");
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						Object valorSpinner3 = spinnerBeginKm.getValue();
						int cant3 = (Integer) valorSpinner3;

						Object valorSpinner4 = spinnerEndKm.getValue();
						int cant4 = (Integer) valorSpinner4;

						int endTime = cant + cant2;
						String q = String.valueOf(endTime);

						/*
						 * DateFormat formatter = new
						 * SimpleDateFormat("HH:mm:ss"); try { Time y = new
						 * Time(formatter.parse(q).getTime()); Route ruta = new
						 * Route(cant3,cant4,textField_2.getText(),y,solicitud.
						 * getId_solicitude());
						 * RouteServices.insertarRuta(ruta); } catch
						 * (ParseException | ClassNotFoundException |
						 * SQLException e1) { // TODO Auto-generated catch block
						 * e1.printStackTrace(); }
						 */

						// -------------------------------

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
