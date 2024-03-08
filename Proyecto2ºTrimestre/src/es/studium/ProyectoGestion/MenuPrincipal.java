package es.studium.ProyectoGestion;

import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal implements WindowListener, ActionListener {
    Frame ventana = new Frame("Principal");
    MenuBar barraMenu = new MenuBar();
    Menu mnuSocios = new Menu("Socios");
    Menu mnuReservas = new Menu("Reservas");
    Menu mnuPistas = new Menu("Pistas");

    MenuItem mniConsultaReservas = new MenuItem("Consulta");
    MenuItem mniAltaReservas = new MenuItem("Alta");
    MenuItem mniBajaReservas = new MenuItem("Baja");
    MenuItem mniModificacionReservas = new MenuItem("Modificación");

    MenuItem mniModificacionPistas = new MenuItem("Modificación");
    MenuItem mniConsultaPistas = new MenuItem("Consulta");
    MenuItem mniBajaPistas = new MenuItem("Baja");
    MenuItem mniAltaPistas = new MenuItem("Alta");

    MenuItem mniSocioNuevo = new MenuItem("Nuevo Socio");
    MenuItem mniSocioEliminar = new MenuItem("Eliminar Socio");
    MenuItem mniSocioConsultar = new MenuItem("Consultar Socio");

    Dialog dlgMensaje = new Dialog(ventana, "Diálogo con mensaje", true);
    Label lblMensaje = new Label("          ");
  

    Datos datos = new Datos();
 
    
    public MenuPrincipal(int tipo) 
    {
    	 datos.conectar();

        ventana.setLayout(new FlowLayout());
        dlgMensaje.setLayout(new FlowLayout());
        ventana.addWindowListener(this);
        dlgMensaje.addWindowListener(this);

        
       
       
        if (tipo == 0) 
        	{ //  juanmaRoot
            mnuSocios.add(mniSocioNuevo);
            mnuSocios.add(mniSocioEliminar);
            mnuSocios.add(mniSocioConsultar);

            mnuPistas.add(mniAltaPistas);
            mnuPistas.add(mniConsultaPistas);
            mnuPistas.add(mniBajaPistas);
            mnuPistas.add(mniModificacionPistas);
            
            mnuReservas.add(mniAltaReservas);
            mnuReservas.add(mniConsultaReservas);
            mnuReservas.add(mniBajaReservas);
            mnuReservas.add(mniModificacionReservas);
            
            barraMenu.add(mnuSocios);
            barraMenu.add(mnuPistas);
            barraMenu.add(mnuReservas);
            
            ventana.setMenuBar(barraMenu);
        	}
        
        else if (tipo == 1) //  juanma2
        	{ 
            mnuReservas.add(mniAltaReservas);
            mnuReservas.add(mniConsultaReservas);
            mnuReservas.add(mniBajaReservas);
            mnuReservas.add(mniModificacionReservas);
            
            barraMenu.add(mnuReservas);
            
            ventana.setMenuBar(barraMenu);
        	}
        
        mniSocioNuevo.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                new AltaSocio();
            }
        }
        );
        
        mniSocioEliminar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                new BajaSocio(); 
            }
        }
        );
        mniSocioConsultar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                new ConsultarSocio(); 
            }
        }
        );

    		
        ventana.setSize(450, 260);
        ventana.setResizable(false);
        ventana.setBackground(Color.gray);
        ventana.setLocationRelativeTo(null);

        dlgMensaje.setSize(250, 200);
        dlgMensaje.setResizable(false);
        dlgMensaje.setBackground(Color.white);
        dlgMensaje.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }



	@Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) 
    {
        if (dlgMensaje.isActive()) 
        {
            dlgMensaje.setVisible(false);
        } 
        else 
        {
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
