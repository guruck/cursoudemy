package jpa.model.muitosPraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl013_tios")
public class Tio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	private Integer idade;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
			name="tbl01314_tios_sobrinhos",
			joinColumns = @JoinColumn(name="tio_id",referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name="sobrinho_id",referencedColumnName="id")
	)
	private List<Sobrinho> sobrinhos;
	
	public Tio() {}
	
	public Tio(String nome,Integer idade) {
		super();
		this.setNome(nome);
		this.setIdade(idade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Sobrinho> getSobrinhos() {
		if (sobrinhos == null) sobrinhos = new ArrayList<>();
		return sobrinhos;
	}

	public void addSobrinho(Sobrinho sobrinho) {
//		System.out.println("ADD: "+ sobrinho.getNome());
//		System.out.println(!getSobrinhos().contains(sobrinho));
		if (sobrinho != null && !getSobrinhos().contains(sobrinho)) {
			sobrinhos.add(sobrinho);
			if(!sobrinho.getTios().contains(this)) {
				sobrinho.addTio(this);
			}
		}
	}

	@Override
	public String toString() {
		return "Tio [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Tio other = (Tio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
