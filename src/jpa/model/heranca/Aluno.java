package jpa.model.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "tbl017_alunos")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) //cria 2 tabelas com todos os atributos
//@Inheritance(strategy=InheritanceType.JOINED) //cria 2 tabelas relacionadas
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //default cria um tabelao
@DiscriminatorColumn(name="tipo",length=2,discriminatorType=DiscriminatorType.STRING) //define o "tipo" para registrar e distinguir as heranças no JPA quando não é a estrategia TABLE_PER_CLASS 
@DiscriminatorValue("AL")
public class Aluno {
	
	@Id
	private Long matricula;
	private String nome;
	
	public Aluno() {}

	
	public Aluno(Long matricula, String nome) {
		super();
		this.setMatricula(matricula);
		this.setNome(nome);
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	
}
