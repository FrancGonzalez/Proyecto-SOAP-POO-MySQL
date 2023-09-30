package VO;

public class CiudadanoVO {

	private String edad;
	private String nombre;
	private int id;
	
	public CiudadanoVO() {}
	
	public CiudadanoVO(String edad, String nombre) {
		this.edad = edad;
		this.nombre = nombre;
	}
	public CiudadanoVO(String edad, String nombre, int id) {
		this.edad = edad;
		this.nombre = nombre;
		this.id = id;
	}
	
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "CiudadanoVO Edad: " + edad + "\nnombre: " + nombre;
	}

	
	
}
