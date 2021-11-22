package ejercicio2.display.javabean;

import java.io.InputStream;
import java.util.Properties;

public class BDBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String DRIVER = "";
	private String URL = "";
	private String USUARIO = "";
	private String PASSWORD = "";
	private Properties prop = null;
	private InputStream fichero = null;
	
	public String getDriver() {
		return DRIVER;
	}
	
	public void setDriver(String driver) {
		DRIVER = driver;
	}
	
	public String getURL() {
		return URL;
	}
	
	public void setURL(String url) {
		URL = url;
	}
	
	public String getUSUARIO() {
		return USUARIO;
	}
	
	public void setUSUARIO(String usuario) {
		USUARIO = usuario;
	}
	
	public String getPASSWORD() {
		return PASSWORD;
	}
	
	public void setPASSWORD(String password) {
		PASSWORD = password;
	}
	
	public Properties getSQL() {
		try {
			prop = new Properties();
			prop.load(fichero);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	public void setFichero(InputStream f) {
		fichero = f;
	}
}