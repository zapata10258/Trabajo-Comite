package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

import java.awt.Button;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	private JTextField textNombre;
	private JTextField textFechai;
	private JTextField textFechaf;
	private JTextField textProgreso;
	private JTextField textNumero;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnGuardar;	
	private JButton btnVerTodo;
	private JTextArea textDescripcion;
	Hashtable<String, Rutina> tablaRutina;

	
	

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 320);
		iniciarComponentes();
		tablaRutina=new Hashtable<String,Rutina>();
	}
	public void iniciarComponentes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setFont(new Font("Kartika", Font.BOLD, 11));
		btnGuardar.setBounds(10, 249, 117, 23);
		panelPrincipal.add(btnGuardar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Kartika", Font.BOLD, 11));
		btnBuscar.setBounds(150, 249, 89, 23);
		panelPrincipal.add(btnBuscar);
		
		btnVerTodo = new JButton("VER TODO");
		btnVerTodo.addActionListener(this);
		btnVerTodo.setFont(new Font("Kartika", Font.BOLD, 11));
		btnVerTodo.setBounds(266, 249, 105, 23);
		panelPrincipal.add(btnVerTodo);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this); 
		btnEliminar.setFont(new Font("Kartika", Font.BOLD, 11));
		btnEliminar.setBounds(398, 249, 89, 23);
		panelPrincipal.add(btnEliminar);
		
		textNombre = new JTextField();
		textNombre.setBounds(64, 128, 187, 20);
		panelPrincipal.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre del objetivo");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(68, 103, 183, 14);
		panelPrincipal.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(118, 159, 78, 14);
		panelPrincipal.add(lblNewLabel_1);
		
		textFechai = new JTextField();
		textFechai.setBounds(368, 84, 86, 20);
		panelPrincipal.add(textFechai);
		textFechai.setColumns(10);
		
		textFechaf = new JTextField();
		textFechaf.setBounds(368, 141, 86, 20);
		panelPrincipal.add(textFechaf);
		textFechaf.setColumns(10);
		
		textProgreso = new JTextField();
		textProgreso.setBounds(368, 197, 86, 20);
		panelPrincipal.add(textProgreso);
		textProgreso.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de inicio");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(346, 59, 122, 14);
		panelPrincipal.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de Finalizacion");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(348, 116, 139, 14);
		panelPrincipal.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Progreso Actual");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(346, 172, 122, 14);
		panelPrincipal.add(lblNewLabel_4);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(64, 69, 187, 20);
		panelPrincipal.add(textNumero);
		
		JLabel lblNumeroDeNota = new JLabel("Numero de Rutina");
		lblNumeroDeNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDeNota.setForeground(Color.BLUE);
		lblNumeroDeNota.setBounds(64, 44, 187, 14);
		panelPrincipal.add(lblNumeroDeNota);
		
		textDescripcion = new JTextArea();
		textDescripcion.setBounds(64, 180, 187, 58);
		panelPrincipal.add(textDescripcion);
		
	
	}
	
	
	
	private void eliminarRutinas(Hashtable<String, Rutina> tablaRutina) {
		String numero=JOptionPane.showInputDialog("Ingrese el numero de rutina a eliminar");
		if (tablaRutina.containsKey(numero)) {
			tablaRutina.remove(numero);
			System.out.println("Se a eliminado");
		}else {
			JOptionPane.showMessageDialog(null,"El numero no existe!!","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	private void consultarRutina(Hashtable<String, Rutina> tablaRutina) {
		String mensaje="DATOS DE LA RUTINA\n";
		String numero=JOptionPane.showInputDialog("Ingrese el numero de la Rutina:");
		String cadenaI="";
		String cadenaF="";
		String mesI="";
		String mesF="";
		String añoI="";
		String añoF="";
		int cadenaInicial=0;
		int cadenaFinal=0;
		int Faltantes=0;
		int mesInicial=0;
		int mesFinal=0;
		int meses=0;
		int añoInicial=0;
		int añoFinal=0;
		int años=0;
		
		if (tablaRutina.containsKey(numero)==true) {
			Rutina rutina=tablaRutina.get(numero);
			mensaje+="Numero: "+rutina.getNumero()+"\n";
			mensaje+="Nombre: "+rutina.getNombre()+"\n";
			mensaje+="Descripcion: "+rutina.getDescripcion()+"\n";
			mensaje+="Fecha Inicio: "+rutina.getFecha1()+"\n";
			mensaje+="Fecha Final: "+rutina.getFecha2()+"\n";
			mensaje+="Progreso: "+rutina.getProgreso()+"%\n";
			///////////////////////////////////////////////////
			cadenaI=rutina.getFecha1().substring(0,2);
			cadenaF=rutina.getFecha2().substring(0,2);
			mesI=rutina.getFecha1().substring(4,5);
			mesF=rutina.getFecha2().substring(4,5);
			añoI=rutina.getFecha1().substring(7,10);
			añoF=rutina.getFecha2().substring(7,10);
			//////////////////////////////////////////////////
			mesInicial=Integer.parseInt(mesI);
			mesFinal=Integer.parseInt(mesF);
			cadenaInicial=Integer.parseInt(cadenaI);
			cadenaFinal=Integer.parseInt(cadenaF);
			añoInicial=Integer.parseInt(añoI);
			añoFinal=Integer.parseInt(añoF);
			///////////////////////////////////////////////////
			meses=mesFinal-mesInicial;
			Faltantes=cadenaFinal-cadenaInicial;
			años=añoFinal-añoInicial;
			//////////////////////////////////////////////////
//			if (meses<0) {
//				mensaje+="Le faltan: "+Faltantes+" dias "+" 0 meses "+años+" años.\n\n";
//			}
//			if (Faltantes<0) {
//				mensaje+="Le faltan: "+" 0 dias "+meses+" meses "+años+" años.\n\n";
//			}
//			if (años>0 && meses>0 && Faltantes>0) {
//				mensaje+="Le faltan: "+Faltantes+" dias "+meses+" meses "+años+" años.\n\n";
//			}
			mensaje+="Le faltan: "+Faltantes+" dias "+meses+" meses "+años+" años.\n\n";
			JOptionPane.showMessageDialog(null, mensaje);
		}else {
			JOptionPane.showMessageDialog(null,"El numero no existe!!","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	private void guardarRutina(Hashtable<String, Rutina> tablaRutina) {
		Rutina miRutina=new Rutina();
		miRutina.setNumero(textNumero.getText());
		miRutina.setNombre(textNombre.getText());
		miRutina.setDescripcion(textDescripcion.getText());
		miRutina.setFecha1(textFechai.getText());
		miRutina.setFecha2(textFechaf.getText());
		miRutina.setProgreso(Integer.parseInt(textProgreso.getText()));
		
		if (tablaRutina.containsKey(miRutina.getNumero())==false) {
			tablaRutina.put(miRutina.getNumero(), miRutina);
			System.out.println("Guardo");
			limpiarcampo();
		}else {
			JOptionPane.showMessageDialog(null,"El numero ya existe!!","Advertencia",JOptionPane.WARNING_MESSAGE);
		}
	}
	private void limpiarcampo() {
		textFechaf.setText("");textFechai.setText("");textNombre.setText("");
		textNumero.setText("");textProgreso.setText("");textDescripcion.setText("");
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnGuardar) {
			guardarRutina(tablaRutina);	
		}else if(e.getSource()== btnBuscar) {
			consultarRutina(tablaRutina);
		}else if(e.getSource()== btnVerTodo) {			
			VentanaConsulta miVentana=new VentanaConsulta(true,tablaRutina);
			miVentana.setVisible(true);	
		}else if(e.getSource()== btnEliminar) {
			eliminarRutinas(tablaRutina);
		}
		
	}
}
