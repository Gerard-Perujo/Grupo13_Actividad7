package modelo.dao;

import java.util.List;

import modelo.javabeans.Empleados;

public class EmpleadoDaoMy8 implements EmpleadoDao{

	@Override
	public int crearEmpleado(Empleados empleado) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Empleados buscarUno(int idEmpl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modificarEmpleado(Empleados empleado) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarEmpleado(int idEmpl) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Empleados> empleadoByDepartamento(int idDepar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleados> empleadosBySexo(char sexo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleados> empleadosByApellido(String subcadena) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double salarioTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double salarioTotal(int idDepar) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
