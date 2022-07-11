package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoas {

	public static void main(String[] args) throws SQLException {
		
		String delete = "DELETE FROM `wm`.`tbl006_pessoas` WHERE `pessoa_id` = ?";
				
		Connection con = FactoryConection.getConection();
		System.out.println("conexão efetuada com sucesso.");
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o id para busca:");
		Integer id = entrada.nextInt();
		entrada.nextLine();	
		
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		
		Integer resSelect = stmt.executeUpdate();
		if (resSelect > 0) {
		    stmt.close();
			System.out.println("registro "+ id +" deletado com sucesso");
		}else {
			System.out.println("Pessoa não encontrada para exclusao");
		}
		entrada.close();
		con.close();
	}
}
