package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoas {

	public static void main(String[] args) throws SQLException {

		Connection con = FactoryConection.getConection();
		System.out.println("conexão efetuada com sucesso.");
		
		Statement stmt = con.createStatement();
		String query = "CREATE TABLE IF NOT EXISTS `tbl006_pessoas` ("
				+ "`pessoa_id` INT NOT NULL AUTO_INCREMENT,"
				+ "`pessoa_nome` VARCHAR(120) NOT NULL,"
				+ "PRIMARY KEY (`pessoa_id`) USING BTREE"
				+ ")COLLATE='utf8_general_ci' ENGINE=InnoDB;";
		stmt.execute(query);
		System.out.println("tabela `pessoas` criada com sucesso.");
		
		con.close();
	}

}
