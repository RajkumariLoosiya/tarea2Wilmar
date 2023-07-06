package beans;

public class Empleado {
	
	private int id; 
	private String nombre; 
	private int edad; 
	private int departamento_id;
	
	public Empleado(int id, String nombre, int edad, int departamento_id) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.departamento_id = departamento_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDepartamento_id() {
		return departamento_id;
	}

	public void setDepartamento_id(int departamento_id) {
		this.departamento_id = departamento_id;
	} 
	
	

}
