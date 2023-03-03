package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.conexion.ConexionDaoMy8;

public class AbstractConexionMy8 {
	
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected String sql;
	protected int filas;
	
	
	public AbstractConexionMy8() {
		conn = ConexionDaoMy8.conectar();
	}

}
