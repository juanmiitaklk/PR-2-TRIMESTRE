package es.studium.ProyectoGestion;

import java.awt.*;
import java.awt.event.*;

public class BajaSocio implements ActionListener, WindowListener  {

    Frame ventana = new Frame("Baja Socio");
    Label dniSociolbl = new Label("DNI del Socio");
    TextField dniSocioTXT = new TextField();
    Label contrasenaSociolbl = new Label("Contraseña del Socio");
    TextField contrasenaSocioTXT = new TextField();
    Button eliminarbtn = new Button("Eliminar");

    Datos datos = new Datos();
    Dialog mensaje = new Dialog(ventana, "Mensaje", true);
    Label lblMensaje = new Label("");

    BajaSocio() 
    {
        ventana.setLayout(new GridLayout(0, 2, 10, 10));
        ventana.setSize(300, 150);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        eliminarbtn.addActionListener(this);


        ventana.add(dniSociolbl);
        ventana.add(dniSocioTXT);
        ventana.add(contrasenaSociolbl);
        ventana.add(contrasenaSocioTXT);
        ventana.add(eliminarbtn);

        mensaje.setLayout(new FlowLayout());
        mensaje.setSize(250, 150);
        mensaje.setResizable(false);
        mensaje.setLocationRelativeTo(null);
        mensaje.add(lblMensaje);
        mensaje.addWindowListener(new WindowAdapter() {
            
    @Override
    public void windowClosing(WindowEvent e) {
                mensaje.dispose();
            }
        }
        );
        ventana.addWindowListener(new WindowAdapter() {
     @Override
     public void windowClosing(WindowEvent e) {
                ventana.dispose();
            }
        }
        );    
    ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == eliminarbtn) 
        {
            datos.conectar();
            boolean eliminacionCorrecta = datos.eliminarSocio(dniSocioTXT.getText(), contrasenaSocioTXT.getText());

            if (eliminacionCorrecta) 
            {
                lblMensaje.setText("Socio eliminado correctamente");
            } 
            else 
            {
                lblMensaje.setText("No se pudo eliminar al socio");
            }
            mensaje.setVisible(true);
            datos.desconectar();
        }
    }
@Override
	public void windowClosing(WindowEvent e) 
	{ 
		ventana.dispose();   
	}
    public static void main(String[] args) {
        new BajaSocio();
    }

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}

