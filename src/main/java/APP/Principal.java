package APP;

import Conexion.Conexion;
import DAO_WS.CiudadanoDAO;
import VO.CiudadanoVO;
import jakarta.xml.ws.Endpoint;


@SuppressWarnings("unused")
public class Principal {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:8090/wssoap/CiudadanoDAO", new CiudadanoDAO());
		System.out.println("Soap");
		System.out.println("http://localhost:8090/wssoap/CiudadanoDAO");
		
	}

}
