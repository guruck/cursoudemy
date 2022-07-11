package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FactoryConection {

	public static Connection getConection(){
		try {
			Properties prop = getProperties();
			final String url = prop.getProperty("banco.url") +
					prop.getProperty("banco.server") + 
					prop.getProperty("banco.port") + 
					prop.getProperty("banco.database") + 
					prop.getProperty("banco.details");
			return DriverManager.getConnection(url, 
					prop.getProperty("banco.user"), 
					prop.getProperty("banco.pswd"));
		} catch (SQLException | IOException e ) {
			throw new RuntimeException(e);
		}
	}
	
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/.properties";
		prop.load(FactoryConection.class.getResourceAsStream(caminho));
		return prop;
	}
}
