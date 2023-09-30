package DAO_WS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Conexion.Conexion;
import VO.CiudadanoVO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class CiudadanoDAO {
	
	@WebMethod(operationName = "AddCiudadano")
	public Boolean AñadirCiudadano(CiudadanoVO object) {
		Boolean resultado = false;
		try {
			Connection conexion = Conexion.Conectar();
			String sql = "INSERT INTO CIUDADANO (nombre, edad) values (?, ?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, object.getNombre());
			ps.setString(2, object.getEdad());
			if (ps.executeUpdate() == 1) {
				resultado = true;
			}
			conexion.close();
			ps.close();
		}   catch (Exception e) {
			System.out.println("ERROR DE INSERCCION DE OBJETO A BD");
			e.printStackTrace();
			e.getMessage();
		}
			return resultado;	
	}
	
	@WebMethod(operationName = "RequestCiudadano")
	public ArrayList<CiudadanoVO> ConsultarCiudadanos () {
		ArrayList<CiudadanoVO> ListaCiudadano = new ArrayList<CiudadanoVO>();
		Connection conexion = Conexion.Conectar();
		try {
		Statement stmt = conexion.createStatement();
		ResultSet set = stmt.executeQuery("select * from ciudadano");
		while (set.next()) {
			int idciudadano = set.getInt("idciudadano");
			String nombre = set.getString("nombre");
			String edad = set.getString("edad");
			CiudadanoVO object = new CiudadanoVO(nombre, edad, idciudadano);
			ListaCiudadano.add(object);
			}
		conexion.close();
		stmt.close();
		set.close();
		} catch (Exception e) {
		System.out.println("ERROR DE CONSULTA DE DATOS");
		e.printStackTrace();
		e.getMessage();
		}
	    return ListaCiudadano;
	}
	
	@WebMethod(operationName = "DeleteCiudadano")
	public Boolean EliminarCiudadano(int id) {
		Boolean resultado = false;
		Connection conexion = Conexion.Conectar();
		String sql = "DELETE FROM ciudadano where idciudadano = " + id;
		try {
		Statement stmt = conexion.prepareStatement(sql);
		if (stmt.executeUpdate(sql) == 1) {
			resultado = true;
			} 
		} catch (Exception e) {
			System.out.println("ERROR AL ELIMINAR DATOS DE USUARIO");
			e.printStackTrace();
			e.getMessage();
		}
		return resultado;
	}
	
	
	
	
}
