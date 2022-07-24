package jpa.model.umPraMuitos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jpa.model.basico.Produto;

@Entity
@Table(name = "tbl012_itens_pedidos")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Pedido pedido;
	
	//padrão ToOne FetchType.EAGER -> carrega imediatamente na consulta
	@ManyToOne(fetch = FetchType.EAGER) 
	private Produto produto;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false)
	private Double preco;
	
	
	public ItemPedido() {}
			
	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
		super();
		this.setPedido(pedido);
		this.setProduto(produto);
		this.setQuantidade(quantidade);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		if (produto != null && this.preco == null ) this.preco = produto.getPreco();
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", pedido=" + pedido + ", produto=" + produto + ", quantidade=" + quantidade
				+ ", preco=" + preco + "]";
	}
		
}
