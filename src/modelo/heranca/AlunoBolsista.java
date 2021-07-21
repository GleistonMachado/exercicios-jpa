package modelo.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bolsista")
public class AlunoBolsista extends Aluno {

	private Double valorBolsa;

	public AlunoBolsista() {
		
	}

	public AlunoBolsista(Long matricula, String nome, Double valorBolsa) {
		super(matricula, nome);
		this.valorBolsa = valorBolsa;
	}

	public Double getValorBolsa() {
		return valorBolsa;
	}

	public void setValorBolsa(Double valorBolsa) {
		this.valorBolsa = valorBolsa;
	}

}
