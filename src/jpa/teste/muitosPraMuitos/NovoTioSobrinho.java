package jpa.teste.muitosPraMuitos;

import jpa.model.infra.DAO;
import jpa.model.muitosPraMuitos.Sobrinho;
import jpa.model.muitosPraMuitos.Tio;

public class NovoTioSobrinho {

	public static void main(String[] args) {
		
		Tio tia1 = new Tio("Maria",45);
		Tio tio1 = new Tio("Joao",38);

		Sobrinho sob1 = new Sobrinho("Pedro",9);
		Sobrinho sob2 = new Sobrinho("Ana",11);
/*
 * Linhas foram removidas pela nova implementação que
 * realiza a persistencia de ambos os lados na funcao de addTio
 * ou addSobrinho e também por conta do cascade = CascadeType.PERSIST
 * que insere o sobrinho ou tio se um dos lados não existir 
 */
		
		tia1.addSobrinho(sob1);
//		sob1.getTios().add(tia1);
		tia1.addSobrinho(sob2);
//		sob2.getTios().add(tia1);
		tio1.addSobrinho(sob1);
//		sob1.getTios().add(tio1);
		tio1.addSobrinho(sob2);
//		sob2.getTios().add(tio1);
		
		DAO<Object> dao = new DAO<>();
		
// como estão em cascata, basta adicionar 1 elemento para add todos
		dao.includeAtomic(tia1);
//		dao.openTransaction()
//			.include(tia1)
//			.include(tio1)
//			.include(sob1)
//			.include(sob2)
//			.closeTransaction();
		dao.close();
	}
}
