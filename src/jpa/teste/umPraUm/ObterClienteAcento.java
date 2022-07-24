package jpa.teste.umPraUm;

import jpa.model.infra.DAO;
import jpa.model.umPraUm.Acento;
import jpa.model.umPraUm.Cliente;

public class ObterClienteAcento {
	public static void main(String[] args) {
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		Cliente cliente = dao.findById(2L);
		System.out.println(cliente.getAcento().toString());
		dao.close();
		
		DAO<Acento> daoA = new DAO<>(Acento.class);
		Acento acentoCliente = daoA.findById(3L);
		System.out.println(acentoCliente.getCliente().toString());
		daoA.close();
	}
}
