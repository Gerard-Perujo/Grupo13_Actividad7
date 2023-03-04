package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Departamentos;
import modelo.javabeans.Empleados;
import modelo.javabeans.Perfil;

/**
 * En esta clase implementamos todos los metodos de la interface EmpleadoDao y tambien importamos
 * la clase abtracta de conexion para que nos podamos conectar en la base de datos
 * 
 * @author Gerard_Perujo
 *
 */
public class EmpleadoDaoImplMy8 extends AbstractConexionMy8 implements EmpleadoDao{
	
	private DepartamentosDaoImplMy8 depar;
	private PerfilDaoImplMy8 perf;
	private Empleados empl;
	
	public EmpleadoDaoImplMy8() {
		depar = new DepartamentosDaoImplMy8();
		perf = new PerfilDaoImplMy8();
		empl = new Empleados();
		
	}
	


	@Override
	public int crearEmpleado(Empleados empleado) {
		
		sql = "insert into Empleados values (?,?,?,?,?,?,?,?,?,?,?)";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empleado.getIdEmpl());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellidos());
			ps.setString(4,empleado.getGenero());
			ps.setString(5, empleado.getEmail());
			ps.setString(6, empleado.getPassword());
			ps.setDouble(7, empleado.getSalario());
			ps.setDate(8, empleado.getFechaIngreso());
			ps.setDate(9, empleado.getFechaNacimiento());
			ps.setInt(10, empleado.getPerfil().getIdPerfil());
			ps.setInt(11, empleado.getDepartamentos().getIdDepar());
			
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Empleados buscarUno(int idEmpl) {
		sql = "Select* from Empleados where id_empl = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			rs = ps.executeQuery();
			
			if (rs.next())
				empl = new Empleados();
				crearEmpleados(empl);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empl;
	}

	@Override
	public int modificarEmpleado(Empleados empleado) {
		sql = "Update empleados set nombre = ?, apellidos = ?, genero = ?, email = ?, salario = ?, password = ?, fecha_ingreso = ?, fecha_nacimiento = ?, id_perfil = ?, id_depar = ? where id_empl = ?";
			
		
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellidos());
			ps.setString(3, empleado.getGenero());
			ps.setString(4, empleado.getEmail());
			ps.setDouble(5, empleado.getSalario());
			ps.setString(6, empleado.getPassword());
			ps.setDate(7, empleado.getFechaIngreso());
			ps.setDate(8, empleado.getFechaNacimiento());
			ps.setInt(9, empleado.getPerfil().getIdPerfil());
			ps.setInt(10, empleado.getDepartamentos().getIdDepar());
			ps.setInt(11, empleado.getIdEmpl());
			
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarEmpleado(int idEmpl) {
		sql = "delete from Empleados where id_empl = ?";
		
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			filas = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Empleados> buscarTodos() {
		sql = "select* from empleados";
		List<Empleados> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
			while (rs.next()) {
				empl = new Empleados();
				crearEmpleados(empl);
				lista.add(empl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	@Override
	public List<Empleados> empleadoByDepartamento(int idDepar) {
		sql = "Select* from Empleados where id_depar = ?";
		List<Empleados> lista = new ArrayList<>();
		int depar = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepar);;
			rs = ps.executeQuery();
			while (rs.next())
				depar = rs.getInt(1);
				empl = new Empleados();
				crearEmpleados(empl);
				lista.add(empl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Empleados> empleadosBySexo(char sexo) {
		sql = "select* from empleados where genero = ?";
		List<Empleados> lista = new ArrayList<>();
		
		String genero = String.valueOf(sexo);
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, genero);
			rs = ps.executeQuery();
			while (rs.next())
				empl = new Empleados();
				crearEmpleados(empl);
				
				lista.add(empl);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<Empleados> empleadosByApellido(String subcadena) {
		sql = "select* from empleados where apellidos = ?";
		
		List<Empleados> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(3, subcadena);
			rs = ps.executeQuery();
			
			while (rs.next())
				empl = new Empleados();
				crearEmpleados(empl);
				
				lista.add(empl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public double salarioTotal() {
		sql = "Select sum(salario) from empleados";
		
		double total = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				total = rs.getDouble(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
	}

	@Override
	public double salarioTotal(int idDepar) {
		sql = "select sum(salario) from empleados where id_depar = ?";
		
		double total = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepar);
			rs = ps.executeQuery();
			if (rs.next())
				total = rs.getDouble(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	

	/**
	 * Creo un metodo buscar empleado para evitar tener que crear
	 * un objeto empleado dentro de cada metodo 
	 */
	public void crearEmpleados(Empleados empleado) throws SQLException{
		
		empleado.setIdEmpl(rs.getInt(1));
		empleado.setNombre(rs.getString(2));
		empleado.setApellidos(rs.getString(3));
		empleado.setGenero(rs.getString(4));
		empleado.setEmail(rs.getString(5));
		empleado.setPassword(rs.getString(6));
		empleado.setSalario(rs.getDouble(7));
		empleado.setFechaIngreso(rs.getDate(8));
		empleado.setFechaNacimiento(rs.getDate(9));
		empleado.setPerfil(perf.buscarUno(rs.getInt(10)));
		empleado.setDepartamentos(depar.buscarUno(rs.getInt(11)));
		
	}
	
	
}
