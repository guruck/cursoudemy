package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas {
	
	public static void main(String[] args) throws SQLException {
		Connection con = FactoryConection.getConection();
		System.out.println("conexão efetuada com sucesso.");
		
		String sql = "SELECT * FROM `wm`.`tbl006_pessoas`";
		Statement stmt1 = con.createStatement();
		ResultSet resultado = stmt1.executeQuery(sql);
		
		List<Pessoa> pessoas = new ArrayList<>();
		while(resultado.next()) {
			pessoas.add(new Pessoa(resultado.getInt("pessoa_id"),resultado.getString("pessoa_nome")));
		}
		for (Pessoa p : pessoas) System.out.println(p.getId()+"==>"+p.getNome());
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o nome para busca:");
		String nome = entrada.next();
		sql = "SELECT * FROM `wm`.`tbl006_pessoas` WHERE `pessoa_nome` LIKE ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nome +"%");
		ResultSet resultado2 = stmt.executeQuery();
		
		List<Pessoa> pessoas2 = new ArrayList<>();
		while(resultado2.next()) {
			pessoas2.add(new Pessoa(resultado2.getInt("pessoa_id"),resultado2.getString("pessoa_nome")));
		}
		for (Pessoa p2 : pessoas2) System.out.println(p2.getId()+"==>"+p2.getNome());
	
		entrada.close();
		con.close();
	}
}
