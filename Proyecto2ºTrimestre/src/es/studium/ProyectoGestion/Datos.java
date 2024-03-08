package es.studium.ProyectoGestion;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

public class Datos
{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/Proyecto2TrimestreProgramacion";
	String login = "root";
	String password = "123456789";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	private int tipoUsuario;
	
	Datos() {}
	
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public boolean conectar()
	{
		
		boolean conexionCorrecta = true;
		try
		{
			Class.forName(driver);
            connection = DriverManager.getConnection(url, login, password);
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Se ha producido un error al cargar el Driver");
			conexionCorrecta = false;
		}
		catch (SQLException e)
		{
			System.out.println("Se produjo un error al conectar a la Base de Datos");
			conexionCorrecta = false;
		}
		return conexionCorrecta;
	}
	
	public boolean comprobarCredenciales(String usuario, String contrasena, int tipo)
	{
		boolean credencialesCorrectas = true;
		String sentencia = "SELECT * FROM usuarios "
				+ "WHERE nombreUsuario='" + usuario + "' "
				+ "AND contrasenaUsuario = SHA2('" + contrasena + "', 256);";
		try
		{
			statement =
					connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery(sentencia);
			if (!rs.next())
			{
				// Credenciales incorrectas
				credencialesCorrectas = false;
			}
		}
		catch (SQLException e)
		{
			System.out.println("Error en la sentencia SQL:" + e.toString());
		}
		return credencialesCorrectas;
	}
	
	public void desconectar()
	{
		try
		{
			statement.close();
			connection.close();
		}
		catch (SQLException e)
		{
			System.out.println("Error al cerrar " + e.toString());
		}
	}
	
	public String dameSocios()
	{
		String contenido = "";
		String sentencia = "SELECT * FROM Socios;";
		try
		{
			statement =
					connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				contenido = contenido + rs.getString("nombreSocios") + "\n";
			}
		}
		catch (SQLException e)
		{
			System.out.println("Error en la sentencia SQL:" + e.toString());
		}
		return contenido;
	}
	
	public boolean AltaSocio(String dni, String nombre, String primerApellido, String segundoApellido, 
			String correoElectronico, String contrasena)
	{
		boolean altaCorrecta = true;
		String sentencia = "INSERT INTO Socios (dniSocio, nombreSocio, primerApellidoSocio, segundoApellidoSocio, "
				+ "correoElectronicoSocio, contrasenaSocio, idReservasFK) " +
	            "VALUES ('" + dni + "', '" + nombre + "', '" + primerApellido + "', '" + segundoApellido + "', '" 
				+ correoElectronico + "', '" + contrasena + "', 1);";
		try
		{
			statement =
					connection.createStatement
			(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.executeUpdate(sentencia);
		}
		catch (SQLException e)
		{
			System.out.println("Error en la sentencia SQL:" + e.toString());
			altaCorrecta = false;
		}
		return altaCorrecta;
		
	}
	
	public int dameTipo(String usuario) 
	{
		String sentencia = "SELECT tipoUsuario FROM Usuarios where nombreUsuario = '" + usuario + "';";
		try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sentencia);

            if (rs.next()) {
               tipoUsuario  = rs.getInt("tipoUsuario");
            }
        } catch (SQLException e) {
            System.out.println("Error en la sentencia SQL:" + e.toString());
        }
			return tipoUsuario;
				
	}

	public boolean eliminarSocio(String dni, String contrasena) 
	{
	    boolean eliminacionCorrecta = false;
	    String sentencia = "DELETE FROM Socios WHERE dniSocio = '" + dni + "' AND contrasenaSocio = '" + contrasena + "';";
	    try {
	        statement = connection.createStatement();
	        int filasAfectadas = statement.executeUpdate(sentencia);

	        if (filasAfectadas > 0) {
	            eliminacionCorrecta = true;
	        }
	    } catch (SQLException e) {
	        System.out.println("Error en la sentencia SQL: " + e.toString());
	    }
	    
		return eliminacionCorrecta;
	}
	
	public ResultSet obtenerSocios() 
	{
	    ResultSet resultado = null;
	    String sentencia = "SELECT dniSocio, nombreSocio, primerApellidoSocio, segundoApellidoSocio,"
	    		+ " correoElectronicoSocio, contrasenaSocio from Socios;";
	    try {
	        statement = connection.createStatement();
	        resultado = statement.executeQuery(sentencia);
	    } catch (SQLException e) {
	        System.out.println("Error en la sentencia SQL: " + e.toString());
	    }
	    return resultado;
		
	}

}
