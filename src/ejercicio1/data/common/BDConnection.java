package ejercicio1.data.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ejercicio2.display.javabean.BDBean;

public class BDConnection {

	protected Connection connection = null;

	public Connection getConnection(BDBean datos) {
		try {
			System.out.println("Driver Class: " + datos.getDriver());
			Class.forName(datos.getDriver());
			this.connection = (Connection) DriverManager.getConnection(datos.getURL(), datos.getUSUARIO(), datos.getPASSWORD());
			//System.out.println("Conexion abierta");
		} catch (SQLException e) {
			System.err.println("Conexion fallida");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver no encontrado");
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.connection;
	}

	public void closeConnection() {
		try {
			if (this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				//System.out.println("Conexion cerrada");
			}
		} catch (SQLException e) {
			System.err.println("Error al cerrar la conexion");
			e.printStackTrace();
		}
	}
}
