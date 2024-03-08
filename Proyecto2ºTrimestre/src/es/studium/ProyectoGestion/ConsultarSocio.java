package es.studium.ProyectoGestion;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarSocio implements WindowListener, ActionListener 
{
	
    Frame ventana = new Frame("Consulta de Socios");
    TextArea areaTexto = new TextArea(10, 40);

    Datos datos = new Datos();
    
    public ConsultarSocio() 
    {
        ventana.setLayout(new BorderLayout());
        ventana.addWindowListener(this);
        ventana.add(areaTexto, BorderLayout.CENTER);
        ventana.setSize(450, 300);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        mostrarSocios(); 

    }

    @Override
    public void actionPerformed(ActionEvent e)  {}
    
    private void mostrarSocios() {
        datos.conectar();
        ResultSet rs = datos.obtenerSocios();
        try {
            while (rs.next()) {
                String dni = rs.getString("dniSocio");
                String nombre = rs.getString("nombreSocio");
                String primerApellido = rs.getString("primerApellidoSocio");
                String segundoApellido = rs.getString("segundoApellidoSocio");
                String correoElectronico = rs.getString("correoElectronicoSocio");
                areaTexto.append("DNI: " + dni + "\n");
                areaTexto.append("Nombre: " + nombre + "\n");
                areaTexto.append("Primer Apellido: " + primerApellido + "\n");
                areaTexto.append("Segundo Apellido: " + segundoApellido + "\n");
                areaTexto.append("Correo Electrónico: " + correoElectronico + "\n\n");
            }
        } catch (SQLException ex) {
            System.out.println("Error al mostrar socios: " + ex.getMessage());
        } finally {
            datos.desconectar();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
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
    public void windowDeactivated(WindowEvent e) {}
}
