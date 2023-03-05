package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Proyecto;

public class ProyectoDaoImplMy8 extends AbstractConexionMy8 implements ProyectoDao{

	@Override
	public int altaProyecto(Proyecto proyecto) {
		sql = "insert into proyectos values (?,?,?,?,?,?,?,?,?,?,?)";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, proyecto.getIdProyecto());
			ps.setString(2, proyecto.getDescripcion());
			ps.setDate(3, proyecto.getFechaInicio());
			ps.setDate(4, proyecto.getFechaFinPrevisto());
			ps.setDate(5, proyecto.getFechaFinReal());
			ps.setDouble(6, proyecto.getVentaPrevisto());
			ps.setDouble(7, proyecto.getCostesPrevisto());
			ps.setDouble(8, proyecto.getCosteReal());
			ps.setString(9, proyecto.getEstado());
			ps.setInt(10, proyecto.getJefeProyecto());
			ps.setString(11, proyecto.getCif());
			
			filas = ps.executeUpdate();
			filas = 1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarProyecto(String idProyecto) {
		sql = "delete from proyectos where id_proyecto = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			
			filas = ps.executeUpdate();
			filas= 1;	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarProyecto(Proyecto proyecto) {
		sql = "update proyectos set Descripcion =?,"
				+ "Fecha_Inicio=?,"
				+ "Fecha_Fin_Previsto=?,"
				+ "Fecha_Fin_Real=?,"
				+ "Venta_Previsto=?,"
				+ "Costes_Previsto=?,"
				+ "Coste_Real=?,"
				+ "Estado=?,"
				+ "Jefe_Proyecto=?,"
				+ "Cif=?,"
				+ "where id_proyecto =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, proyecto.getDescripcion());
			ps.setDate(2, proyecto.getFechaInicio());
			ps.setDate(3, proyecto.getFechaFinPrevisto());
			ps.setDate(4, proyecto.getFechaFinReal());
			ps.setDouble(5, proyecto.getVentaPrevisto());
			ps.setDouble(6, proyecto.getCostesPrevisto());
			ps.setDouble(7, proyecto.getCosteReal());
			ps.setString(8, proyecto.getEstado());
			ps.setInt(9, proyecto.getJefeProyecto());
			ps.setString(10, proyecto.getCif());
			ps.setString(11, proyecto.getIdProyecto());
			
			filas = ps.executeUpdate();
			filas = 1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Proyecto buscarUno(String idProyecto) {
		sql = "select * from proyectos where id_proyecto =?";
		Proyecto pro = null;{
			try {
				ps= conn.prepareStatement(sql);
				ps.setString(1, idProyecto);
				rs= ps.executeQuery();
				if (rs.next()) {
					pro = new Proyecto();
					pro.setIdProyecto(rs.getString("id_proyecto"));
					pro.setDescripcion(rs.getString("Descripcion"));
					pro.setFechaInicio(rs.getDate("Fecha_Inicio"));
					pro.setFechaFinPrevisto(rs.getDate("Fecha_Fin_Previsto"));
					pro.setFechaFinReal(rs.getDate("Fecha_Fin_Real"));
					pro.setVentaPrevisto(rs.getDouble("Venta_Previsto"));
					pro.setCostesPrevisto(rs.getDouble("Costes_Previsto"));
					pro.setCosteReal(rs.getDouble("Coste_Real"));
					pro.setEstado(rs.getString("Estado"));
					pro.setJefeProyecto(rs.getInt("Jefe_Proyecto"));
					pro.setCif(rs.getString("Cif"));
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return pro;
		}
	}

	@Override
	public List<Proyecto> buscarTodos() {
		sql = "select * from proyectos";
		
		List<Proyecto> lista = new ArrayList<>();
		ProyectoDao podao = new ProyectoDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Proyecto pro = new Proyecto();
				pro.setIdProyecto(rs.getString("id_proyecto"));
				pro.setDescripcion(rs.getString("Descripcion"));
				pro.setFechaInicio(rs.getDate("Fecha_Inicio"));
				pro.setFechaFinPrevisto(rs.getDate("Fecha_Fin_Previsto"));
				pro.setFechaFinReal(rs.getDate("Fecha_Fin_Real"));
				pro.setVentaPrevisto(rs.getDouble("Venta_Previsto"));
				pro.setCostesPrevisto(rs.getDouble("Costes_Previsto"));
				pro.setCosteReal(rs.getDouble("Coste_Real"));
				pro.setEstado(rs.getString("Estado"));
				pro.setJefeProyecto(rs.getInt("Jefe_Proyecto"));
				pro.setCif(rs.getString("Cif"));
				
				lista.add(pro);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		sql = "select * from proyectos where id_proyecto like ?";
		
		List<Proyecto> lista = new ArrayList<>();
		ProyectoDao podao = new ProyectoDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, estado + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Proyecto pro = new Proyecto();
				pro.setIdProyecto(rs.getString("id_proyecto"));
				pro.setDescripcion(rs.getString("Descripcion"));
				pro.setFechaInicio(rs.getDate("Fecha_Inicio"));
				pro.setFechaFinPrevisto(rs.getDate("Fecha_Fin_Previsto"));
				pro.setFechaFinReal(rs.getDate("Fecha_Fin_Real"));
				pro.setVentaPrevisto(rs.getDouble("Venta_Previsto"));
				pro.setCostesPrevisto(rs.getDouble("Costes_Previsto"));
				pro.setCosteReal(rs.getDouble("Coste_Real"));
				pro.setEstado(rs.getString("Estado"));
				pro.setJefeProyecto(rs.getInt("Jefe_Proyecto"));
				pro.setCif(rs.getString("Cif"));
				lista.add(pro);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
sql = "select * from proyectos where id_proyecto like ?";
		
		List<Proyecto> lista = new ArrayList<>();
		ProyectoDao podao = new ProyectoDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Proyecto pro = new Proyecto();
				pro.setIdProyecto(rs.getString("id_proyecto"));
				pro.setDescripcion(rs.getString("Descripcion"));
				pro.setFechaInicio(rs.getDate("Fecha_Inicio"));
				pro.setFechaFinPrevisto(rs.getDate("Fecha_Fin_Previsto"));
				pro.setFechaFinReal(rs.getDate("Fecha_Fin_Real"));
				pro.setVentaPrevisto(rs.getDouble("Venta_Previsto"));
				pro.setCostesPrevisto(rs.getDouble("Costes_Previsto"));
				pro.setCosteReal(rs.getDouble("Coste_Real"));
				pro.setEstado(rs.getString("Estado"));
				pro.setJefeProyecto(rs.getInt("Jefe_Proyecto"));
				pro.setCif(rs.getString("Cif"));
				lista.add(pro);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		sql = "select * from proyectos where jefe_proyecto = ? and estado=?";
		
		List<Proyecto> lista = new ArrayList<>();
		ProyectoDao podao = new ProyectoDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, jefeProyecto + '%');
			ps.setString(1, estado + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Proyecto pro = new Proyecto();
				pro.setIdProyecto(rs.getString("id_proyecto"));
				pro.setDescripcion(rs.getString("Descripcion"));
				pro.setFechaInicio(rs.getDate("Fecha_Inicio"));
				pro.setFechaFinPrevisto(rs.getDate("Fecha_Fin_Previsto"));
				pro.setFechaFinReal(rs.getDate("Fecha_Fin_Real"));
				pro.setVentaPrevisto(rs.getDouble("Venta_Previsto"));
				pro.setCostesPrevisto(rs.getDouble("Costes_Previsto"));
				pro.setCosteReal(rs.getDouble("Coste_Real"));
				pro.setEstado(rs.getString("Estado"));
				pro.setJefeProyecto(rs.getInt("Jefe_Proyecto"));
				pro.setCif(rs.getString("Cif"));
				lista.add(pro);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public double importesVentaProyectosTerminados() {
		sql = "select sum(venta_previsto) as importes from proyectos";
		double importes = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				importes = rs.getDouble("importes");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return importes;
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		sql = "select sum(venta_previsto) - sum(coste_real) as margen from proyectos";
		double margen = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				margen = rs.getDouble("margen");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return margen;
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		sql = "select (Fecha_Fin_Previsto) - (now.getTime) as dias_restantes from proyectos";
		int dias_restantes = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dias_restantes = rs.getInt("margen");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dias_restantes;
	}

}
