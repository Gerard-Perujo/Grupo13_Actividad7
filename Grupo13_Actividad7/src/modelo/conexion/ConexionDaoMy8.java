package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDaoMy8 {
	
	private static Connection conn;
	private static String url, user, pasword;
	
	public ConexionDaoMy8() {
		
		url = "jdbc:mysql://localhost:3307/clientes_proyectos_empleados_2023?serverTimezone=UTC";
		user = "root";
		pasword = "root";
		
		try {
			conn = DriverManager.getConnection(url, user, pasword);
			System.out.println("Conexion Establecida");
		} catch (SQLException e) {
			System.out.println("Conexion no Establecida");
			e.printStackTrace();
		}
			
			
		
	}

	public static Connection conectar() {
		if ( conn == null)
			new ConexionDaoMy8();
		return conn;
	}
	
}
