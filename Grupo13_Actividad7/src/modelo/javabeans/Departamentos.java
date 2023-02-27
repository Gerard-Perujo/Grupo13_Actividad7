package modelo.javabeans;

import java.util.Objects;

/**
 * 
 * @author Gerard_Perujo
 *
 */
public class Departamentos {
	
	private  int idDepar;
	private String nombre;
	private String direccion;
	
	
	public Departamentos() {
		super();
	}




	public Departamentos(int idDepar, String nombre, String direccion) {
		super();
		this.idDepar = idDepar;
		this.nombre = nombre;
		this.direccion = direccion;
	}


	public int getIdDepar() {
		return idDepar;
	}


	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Departamentos [idDepar=" + idDepar + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(idDepar);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamentos other = (Departamentos) obj;
		return idDepar == other.idDepar;
	}
	
	
	
	
	
	
	
	

}
