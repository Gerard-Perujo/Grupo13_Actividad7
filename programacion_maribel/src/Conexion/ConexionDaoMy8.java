package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDaoMy8 {
	private static String url, username, password;
	private static Connection conn;
	
	private ConexionDaoMy8() {
		url = "jdbc:mysql://localhost:3306/clientes_proyectos_empleados_2023?serverTimezone=UTC";
		username= "root";
		password= "root";
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("OK");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NO");
		}
	}
	
	public static Connection getConexion() {
		if (conn==null) {
			new ConexionDaoMy8();
		}
		return conn;
	}
	
	

}
