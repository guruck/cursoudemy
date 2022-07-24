package jpa.model.muitosPraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl014_sobrinhos")
public class Sobrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Integer idade;
	
	private Double peso;
	
	@ManyToMany(mappedBy="sobrinhos",cascade=CascadeType.PERSIST)
	private List<Tio> tios;
	
	public Sobrinho() {}
	
	public Sobrinho(String nome,Integer idade) {
		super();
		this.setNome(nome);
		this.setIdade(idade);
		this.setPeso(peso);
	}
	public Sobrinho(String nome,Integer idade, Double peso) {
		this(nome,idade);
		this.setPeso(peso);
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
	
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Tio> getTios() {
		if (tios == null) tios = new ArrayList<>();
		return tios;
	}

	@Override
	public String toString() {
		return "Sobrinho [id=" + id + ", nome=" + nome + "]";
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
		Sobrinho other = (Sobrinho) obj;
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

	public void addTio(Tio tio) {
		if(tio !=null && !getTios().contains(tio)) {
			tios.add(tio);
			if(!tio.getSobrinhos().contains(this)) {
				tio.addSobrinho(this);
			}
		}
	}

	
}
