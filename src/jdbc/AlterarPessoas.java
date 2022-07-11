package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarPessoas {

	public static void main(String[] args) throws SQLException {
		
		String select = "SELECT * FROM `wm`.`tbl006_pessoas` WHERE `pessoa_id` = ?";
		String update = "UPDATE `wm`.`tbl006_pessoas` SET `pessoa_nome`= ? WHERE `pessoa_id` = ?";
		
		Connection con = FactoryConection.getConection();
		System.out.println("conexão efetuada com sucesso.");
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o id para busca:");
		Integer id = entrada.nextInt();
		entrada.nextLine();	
		
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		
		ResultSet resSelect = stmt.executeQuery();
		if (resSelect.next()) {
		    Pessoa p2 = new Pessoa(resSelect.getInt("pessoa_id"),resSelect.getString("pessoa_nome"));
		    System.out.println(p2);
			System.out.println("Informe o nome para alteracao:");
			String nome = entrada.nextLine();
			p2.setNome(nome);
			
			stmt.close();
			
			stmt = con.prepareStatement(update);
			stmt.setString(1, p2.getNome());
			stmt.setInt(2, p2.getId());
			stmt.execute();
			stmt.close();
			System.out.println("registro alterado com sucesso");
		}else {
			System.out.println("Pessoa não encontrada para alteracao");
		}
		entrada.close();
		con.close();
	}
}
