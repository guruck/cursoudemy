package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

	public static void main(String[] args) throws SQLException {

		Connection con = FactoryConection.getConection();
		System.out.println("conexão efetuada com sucesso.");
		
		Statement stmt = con.createStatement();
		String query = "CREATE DATABASE IF NOT EXISTS `wm` DEFAULT CHARACTER SET UTF8;";
		stmt.execute(query);
		System.out.println("Banco `wm` criado com sucesso.");
		
		con.close();
	}

}
