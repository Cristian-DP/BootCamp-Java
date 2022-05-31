package streamAndLambdas;

@SuppressWarnings("rawtypes")
public class Alumnos implements Comparable{
	private int id, edad;
	private String dni, nombre, apellido, curso;
	private double nota;
	
	
	public Alumnos() {
		super();
		set (0, 0, "null", "null", "null", "null", 0.0);
	}
	
	public Alumnos(int id, int edad, String dni, String nombre, String apellido, String curso, double nota) {
		super();
		set (id, edad, dni, nombre, apellido, curso, nota);
	}
	
	private void set (int id, int edad, String dni, String nombre, String apellido, String curso, double nota) {
		this.id = id;
		this.edad = edad;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.curso = curso;
		this.nota = nota;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", edad=" + edad + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", curso=" + curso + ", nota=" + nota + "]";
	}

	@Override
	public int compareTo(Object o) {
		Alumnos a = (Alumnos) o;
		
		return this.getEdad().compareTo(a.getEdad());
	}
	
	
}
