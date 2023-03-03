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
			ps.setInt(1, empl.getIdEmpl());
			ps.setString(2, empl.getNombre());
			ps.setString(3, empl.getApellidos());
			ps.setString(4,empl.getGenero());
			ps.setString(5, empl.getEmail());
			ps.setString(6, empl.getPassword());
			ps.setDouble(7, empl.getSalario());
			ps.setDate(8, empl.getFechaIngreso());
			ps.setDate(9, empl.getFechaNacimiento());
			ps.setInt(10, empl.getPerfil().getIdPerfil());
			ps.setInt(11, empl.getDepartamentos().getIdDepar());
			
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
		sql = "Select from Empleados where id_empl = ?";
		
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
		sql = "Update form Empleados set id_empl =?, nombre = ?, apellidos = ?, genero = ?, email = ?"
			+ "	salario = ?, fecha_ingreso = ?, fecha_nacimiento = ?, id_perfil = ?, id_depar = ? ";
		
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empleado.getIdEmpl());
			ps.setString(2, empleado.getNombre());
			ps.setString(3, empleado.getApellidos());
			ps.setString(4, empleado.getGenero());
			ps.setString(5, empleado.getEmail());
			ps.setDouble(6, empleado.getSalario());
			ps.setString(7, empleado.getPassword());
			ps.setDate(8, empleado.getFechaIngreso());
			ps.setDate(9, empleado.getFechaNacimiento());
			ps.setInt(10, empleado.getPerfil().getIdPerfil());
			ps.setInt(11, empleado.getDepartamentos().getIdDepar());
			
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
		sql = "select from empleados";
		List<Empleados> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
			while (rs.next()) {
				crearEmpleados(empl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Empleados> empleadoByDepartamento(int idDepar) {
		sql = "Select from Empleados where id_depar = ?";
		List<Empleados> lista = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(11, idDepar);
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
		sql = "Select sum(salario) from empleados";
		
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas;
	}

	@Override
	public double salarioTotal(int idDepar) {
		sql = "select sum(salario) from empleados where id_depar = ?";
		
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(11, idDepar);
			rs = ps.executeQuery();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
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
