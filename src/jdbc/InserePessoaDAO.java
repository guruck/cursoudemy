package jdbc;

public class InserePessoaDAO {
	
	public static void main(String[] args){
		ModelDAO dao = new ModelDAO();
		
		String sql = "Insert Into `wm`.`tbl006_pessoas`(`pessoa_nome`) Values (?)";
		System.out.println(dao.incluir(sql, "Djalma Dultra"));
		System.out.println(dao.incluir(sql, "Otavio Mesquita"));
		System.out.println(dao.incluir(sql, "Pjama de Coelho"));
		System.out.println(dao.incluir(sql, "Bicicleteiro Alemão"));
		
		dao.close();
	}
}
