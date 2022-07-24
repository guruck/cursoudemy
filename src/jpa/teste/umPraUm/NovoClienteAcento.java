package jpa.teste.umPraUm;

import jpa.model.infra.DAO;
import jpa.model.umPraUm.Acento;
import jpa.model.umPraUm.Cliente;

public class NovoClienteAcento {

	public static void main(String[] args) {
		
		Cliente novoCliente = new Cliente("Pamela");
		Acento novoAcento = new Acento("Potrona19D");
		novoCliente.setAcento(novoAcento);
		
//		DAO<Acento> daoA = new DAO<>(Acento.class);
//		daoA.includeAtomic(novoAcento).close();
//		
//		DAO<Cliente> dao = new DAO<>(Cliente.class);
//		dao.includeAtomic(novoCliente).close();
		
		DAO<Object> dao = new DAO<>();
		dao.openTransaction()
		.include(novoAcento)
		.include(novoCliente)
		.closeTransaction()
		.close();
		
		System.out.println(novoCliente.getId() + " : " + novoCliente.getAcento().getId());

	}
}
