package jpa.model.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AB")
public class AlunoBolsista extends Aluno {

	private Double bolsa;
	
	public AlunoBolsista() {
		
	}

	public AlunoBolsista(Long matricula, String nome,Double bolsa) {
		super(matricula,nome);
		this.setBolsa(bolsa);
	}

	public Double getBolsa() {
		return bolsa;
	}

	public void setBolsa(Double bolsa) {
		this.bolsa = bolsa;
	}
	
	
}
