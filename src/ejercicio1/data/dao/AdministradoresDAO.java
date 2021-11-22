package ejercicio1.data.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import ejercicio1.business.AdministradoresDTO;
import ejercicio1.data.common.BDConnection;
import ejercicio2.display.javabean.BDBean;

public class AdministradoresDAO {
	public int insertarAdministrador(AdministradoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
				
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
				
			PreparedStatement ps = con.prepareStatement(prop.getProperty("insertarAdmin"));
			ps.setString(1, user.getNombre());
			ps.setString(2, user.getApellidos());
			ps.setString(3, user.getNick());
			ps.setString(4, user.getCorreo());
			ps.setString(5, user.getContrasena());
			ps.setTimestamp(6, Timestamp.valueOf(user.getFechaRegistro()));
				
			status = ps.executeUpdate();
			
			dbconnection.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int borrarAdministrador(AdministradoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("deleteAdmin"));
			ps.setString(1, user.getCorreo());
			
			status = ps.executeUpdate();
			
			dbconnection.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int actualizarAdministradorNombre(AdministradoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("updateAdminNombre"));
			ps.setString(1, user.getNombre());
			ps.setString(2, user.getCorreo());
			
			status = ps.executeUpdate();
			
			dbconnection.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int actualizarAdministradorApellidos(AdministradoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("updateAdminApellidos"));
			ps.setString(1, user.getApellidos());
			ps.setString(2, user.getCorreo());
			
			status = ps.executeUpdate();
			
			dbconnection.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int actualizarAdministradorNick(AdministradoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("updateAdminNick"));
			ps.setString(1, user.getNick());
			ps.setString(2, user.getCorreo());
			
			status = ps.executeUpdate();
			
			dbconnection.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int actualizarAdministradorContrasena(AdministradoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("updateAdminContrasena"));
			ps.setString(1, user.getContrasena());
			ps.setString(2, user.getCorreo());
			
			status = ps.executeUpdate();
			
			dbconnection.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}
	
	public ArrayList<AdministradoresDTO> consultarDatos(BDBean datos) {
		Statement stmt = null;
		AdministradoresDTO user = null;
		ArrayList<AdministradoresDTO> result = new ArrayList<AdministradoresDTO>();
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(prop.getProperty("selectAdmin"));
			
			while(rs.next()){
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String nick = rs.getString("nick");
				String correo = rs.getString("correo");
				
				user = new AdministradoresDTO();
				user.setNombre(nombre);
				user.setApellidos(apellidos);
				user.setNick(nick);
				user.setCorreo(correo);
				
				result.add(user);
			}
			
			dbconnection.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public AdministradoresDTO consultarUsuario(AdministradoresDTO user, BDBean datos) {
		AdministradoresDTO result = null;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("selectUserAdmin"));
			ps.setString(1, user.getCorreo());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String nick = rs.getString("nick");
				String correo = rs.getString("correo");
				
				result = new AdministradoresDTO();
				result.setNombre(nombre);
				result.setApellidos(apellidos);
				result.setNick(nick);
				result.setCorreo(correo);
			}
			
			dbconnection.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public AdministradoresDTO consultarLogin(AdministradoresDTO user, BDBean datos) {
		AdministradoresDTO result = new AdministradoresDTO();
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("loginAdmin"));
			ps.setString(1, user.getCorreo());
			
			ResultSet rs = ps.executeQuery();
						
			while(rs.next()){
				String contrasena = rs.getString("contrasena");
				String correo = rs.getString("correo");
				
				result = new AdministradoresDTO();
				result.setContrasena(contrasena);
				result.setCorreo(correo);
			}
			
			dbconnection.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
}