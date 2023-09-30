package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	private static final String Controlador = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost/testeosoap";
	private static final String usuario = "root";
	private static final String clave = "";
	
	static Connection conexion = null;
	
	public static Connection Conectar() {
		try {
			Class.forName(Controlador);
			conexion = DriverManager.getConnection(url, usuario, clave);
		} catch (Exception e) {
			System.out.println("ERROR AL CONECTAR BASE DE DATOS");
			e.printStackTrace();
			e.getMessage();
		}
		return conexion;
	}
}
