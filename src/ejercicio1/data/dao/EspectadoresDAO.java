package ejercicio1.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

import ejercicio1.business.EspectadoresDTO;
import ejercicio1.data.common.BDConnection;
import ejercicio2.display.javabean.BDBean;

public class EspectadoresDAO {
	public int insertarEspectador(EspectadoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("insertarEspectador"));
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
	
	public int borrarEspectador(EspectadoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("deleteEspectador"));
			ps.setString(1, user.getCorreo());
			
			status = ps.executeUpdate();
			
			dbconnection.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return status;
	}
	
	public int actualizarEspectadorNombre(EspectadoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("updateEspectadorNombre"));
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
	
	public int actualizarEspectadorApellidos(EspectadoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("updateEspectadorApellidos"));
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
	
	public int actualizarEspectadorNick(EspectadoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("updateEspectadorNick"));
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
	
	public int actualizarEspectadorContrasena(EspectadoresDTO user, BDBean datos) {
		int status = 0;
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("updateEspectadorContrasena"));
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
	
	public ArrayList<EspectadoresDTO> consultarDatos(BDBean datos) {
		Statement stmt = null;
		EspectadoresDTO user = new EspectadoresDTO();
		ArrayList<EspectadoresDTO> result = new ArrayList<EspectadoresDTO>();
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(prop.getProperty("selectEspectador"));
			
			while(rs.next()){
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String nick = rs.getString("nick");
				String correo = rs.getString("correo");
				
				user = new EspectadoresDTO();
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
	
	public EspectadoresDTO consultarUsuario(EspectadoresDTO user, BDBean datos) {
		EspectadoresDTO result = new EspectadoresDTO();
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("selectUserEspectador"));
			ps.setString(1, user.getCorreo());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String nick = rs.getString("nick");
				String correo = rs.getString("correo");
				String fechaRegistro = rs.getString("fechaRegistro");
				String ultimaConexion = rs.getString("ultimaConexion");
				
				result = new EspectadoresDTO();
				result.setNombre(nombre);
				result.setApellidos(apellidos);
				result.setNick(nick);
				result.setCorreo(correo);
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime dateTime = LocalDateTime.parse(fechaRegistro, formatter);
				result.setFechaRegistro(dateTime);
				
				formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				dateTime = LocalDateTime.parse(ultimaConexion, formatter);
				result.setUltimaConexion(dateTime);
			}
			
			dbconnection.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public EspectadoresDTO consultarLogin(EspectadoresDTO user, BDBean datos) {
		EspectadoresDTO result = new EspectadoresDTO();
		
		try{
			Properties prop = new Properties();
			prop = datos.getSQL();
			
			BDConnection dbconnection = new BDConnection();
			Connection con = dbconnection.getConnection(datos);
			
			PreparedStatement ps = con.prepareStatement(prop.getProperty("loginEspectador"));
			ps.setString(1, user.getCorreo());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String contrasena = rs.getString("contrasena");
				String correo = rs.getString("correo");
				
				result = new EspectadoresDTO();
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