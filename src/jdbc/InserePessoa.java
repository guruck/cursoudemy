package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserePessoa {

	
	public static void main(String[] args) throws SQLException {
		Connection con = FactoryConection.getConection();
		System.out.println("conexão efetuada com sucesso.");
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o nome:");
		String nome = entrada.nextLine();
		
		String sql = "Insert Into `wm`.`tbl006_pessoas`(`pessoa_nome`) Values (?);";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		System.out.println(stmt.toString());
		stmt.execute();
		System.out.println("Registro "+ nome + ", inserido com sucesso");
		entrada.close();
		con.close();
	}
}
