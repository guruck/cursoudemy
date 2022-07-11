package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/wm?verifyServerCertificate=false&useSSL=true";
		final String usuario = "devmedia"; 
		final String senha = "devmedia";
		Connection con = DriverManager.getConnection(url, usuario, senha);
		System.out.println("conexão efetuada com sucesso.");
		con.close();
	}

}
