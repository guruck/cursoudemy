package jpa.teste.umPraMuitos;

import jpa.model.infra.DAO;
import jpa.model.umPraMuitos.Pedido;

public class ObterPedidos {
	public static void main(String[] args) {
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		Pedido pedido = dao.findById(9L);
		pedido.getItens().forEach(System.out::println);
		dao.close();

	}
}
