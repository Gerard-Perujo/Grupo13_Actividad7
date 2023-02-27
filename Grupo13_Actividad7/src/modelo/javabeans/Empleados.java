package modelo.javabeans;

import java.sql.Date;

public class Empleados {
	
	private int idEmpl;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private double salario;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	private Perfil perfil;
	private Departamentos departamentos;
	
	
	public Empleados() {
		super();
	}


	public Empleados(int idEmpl, String nombre, String apellidos, String email, String password, double salario,
			Date fechaIngreso, Date fechaNacimiento, Perfil perfil, Departamentos departamentos) {
		super();
		this.idEmpl = idEmpl;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.perfil = perfil;
		this.departamentos = departamentos;
	}


	public int getIdEmpl() {
		return idEmpl;
	}


	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public Departamentos getDepartamentos() {
		return departamentos;
	}


	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}


	@Override
	public String toString() {
		return "Empleados [idEmpl=" + idEmpl + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", salario=" + salario + ", fechaIngreso=" + fechaIngreso
				+ ", fechaNacimiento=" + fechaNacimiento + ", perfil=" + perfil + ", departamentos=" + departamentos
				+ "]";
	}
	
	public double salarioBruto() {
		return salario;
	}
	
	
	public double salarioMensual(int meses) {
		return salario/meses;
	}
	
	public String literalSexo() {
		String sexo = "";
			switch(sexo){
				case "H", "h":
					System.out.println("Eres un Hombre");;
				break;
				case "M", "m":
					System.out.println("Eres una Mujer"); ;
				break;
				default:
				System.out.println("Caracter introducido incorrecto");;
				
			}
			
			return sexo;
	}
	
	public String obtenerEmail() {
		String minuscula = apellidos.toLowerCase();
		char letra = 'c';
		for(int i = nombre.length()-1; i > 0; i--) {
			letra = nombre.charAt(i);
			
			System.out.println("La direccion del email: " + letra + minuscula + "@edix.com");
		}
		return email;
	}
	
	public String nombreCompleto() {
		return "Tu nombre completo es: " + nombre + " " + apellidos;
		
	}
	
	
	

}
