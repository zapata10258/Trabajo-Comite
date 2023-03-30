package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

public class VentanaConsulta extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollArea;
	private JTextArea textArea;

	public VentanaConsulta(boolean b, Hashtable<String, Rutina> tablaRutina) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(568, 332);
		setLocationRelativeTo(null);
		iniciarComponentes();
		
		System.out.println(tablaRutina);
		mostrarRutinas(tablaRutina);
	}

	private void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		getContentPane().add(scrollPane);
		
		
		
	}
	private void mostrarRutinas(Hashtable<String, Rutina> tablaRutina) {
		String mensaje="";
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
		
		Enumeration<Rutina> elemento=tablaRutina.elements();
		
		while (elemento.hasMoreElements()) {
			Rutina rutina = elemento.nextElement();
			mensaje+="Numero: "+rutina.getNumero()+"\n Nombre: "+rutina.getNombre()+"\n";
			mensaje+="Descripcion: "+rutina.getDescripcion()+"\n Fecha inicio: "+rutina.getFecha1()+"\n";
			mensaje+="Fecha Final: "+rutina.getFecha2()+"\n Progreso: "+rutina.getProgreso()+"\n";
			///////////////////////////////////////////////////////
			cadenaI=rutina.getFecha1().substring(0,2);
			cadenaF=rutina.getFecha2().substring(0,2);
			mesI=rutina.getFecha1().substring(4,5);
			mesF=rutina.getFecha2().substring(4,5);
			añoI=rutina.getFecha1().substring(7,10);
			añoF=rutina.getFecha2().substring(7,10);
			//////////////////////////////////////////////////////
			mesInicial=Integer.parseInt(mesI);
			mesFinal=Integer.parseInt(mesF);
			cadenaInicial=Integer.parseInt(cadenaI);
			cadenaFinal=Integer.parseInt(cadenaF);
			añoInicial=Integer.parseInt(añoI);
			añoFinal=Integer.parseInt(añoF);
			///////////////////////////////////////////////////////
			meses=mesFinal-mesInicial;
			Faltantes=cadenaFinal-cadenaInicial;
			años=añoFinal-añoInicial;
			///////////////////////////////////////////////////////
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
		}
		textArea.setText(mensaje);
	}

}
