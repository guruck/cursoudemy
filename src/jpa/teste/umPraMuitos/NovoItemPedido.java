package jpa.teste.umPraMuitos;

import java.util.List;
import java.util.Random;

import jpa.model.basico.Produto;
import jpa.model.infra.DAO;
import jpa.model.umPraMuitos.ItemPedido;
import jpa.model.umPraMuitos.Pedido;

public class NovoItemPedido {

	public static void main(String[] args) {
		DAO<Object> dao = new DAO<>();
		DAO<Produto> daoProduto = new DAO<>(Produto.class);
		List<Produto> lista = daoProduto.getAll();
		
		Pedido pedido001 = new Pedido();
//		
//		// ItemPedido(Pedido , Produto , quantidade)
//		ItemPedido item1 = new ItemPedido(pedido001,lista.get(1),10);

		dao.openTransaction();
		for(Produto produto: lista) {
			Integer i = new Random().nextInt(10) + 1;
			dao.include(new ItemPedido(pedido001,produto,i));
		}
		dao.closeTransaction();
		
		dao.close();
		daoProduto.close();
	}
}
