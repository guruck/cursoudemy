package jpa.teste.muitosPraMuitos;

import jpa.model.consulta.SobrinhoPeso;
import jpa.model.infra.DAO;

public class ObterSobrinho {

	public static void main(String[] args) {
		
//		DAO<Sobrinho> dao = new DAO<>(Sobrinho.class);
//
//		List<Sobrinho> sobs = dao.getLista(
//				"obterSobrinhosMaiorIdade", "idade",8);
//				
//		System.out.println("Nome: " + sobs.get(1).getNome()
//				+" tios:" + sobs.get(1).getTios().toString());
//		
//		dao.close();
		
		DAO<SobrinhoPeso> dao2 = new DAO<>(SobrinhoPeso.class);
		SobrinhoPeso mi = dao2.getUm("obterSobrinhosMediaPeso");
		System.out.println(mi.getMedia());
		dao2.close();
	}
}
