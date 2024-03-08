package es.studium.ProyectoGestion;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ConsultaSocio implements ActionListener, WindowListener {

	Frame ventana = new Frame("Listado de Socios");
	TextArea listado = new TextArea(5,40);
	Button btnVolver = new Button("Volver");
	Datos datos = new Datos();
	
	ConsultaSocio()
	{
		
		ventana.setLayout(new FlowLayout());
		ventana.addWindowListener(this);
		btnVolver.addActionListener(this);

		
		//Conectar BD
		datos.conectar();
		listado.append(datos.dameSocios());
		datos.desconectar();
		
		ventana.add(listado);
		ventana.add(btnVolver);
		
		ventana.setSize(350, 200);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		
		ventana.setResizable(true);
		ventana.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		ventana.setVisible(false);		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) 
	{
		if(e.getSource().equals(btnVolver))
		{
			ventana.setVisible(false);
		}		
	}
		
}
	

