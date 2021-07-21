package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_aluno", length = 10, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("normal")
public class Aluno {

	/* strategy = InheritanceType.TABLE_PER_CLASS  -> Para cada classe concreta sera criada uma tabela.
	   strategy = InheritanceType.SINGLE_TABLE     -> Sera criada uma unica tabela com os atributos de ambas as classes.
	   strategy = InheritanceType.JOINED           -> Sera criada ambas tabelas relacianado as classes contendo atributos separadas
	   
	   OBS: Qunado for @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
	   não é nescessario a criação do @DiscriminatorColumn() e @DiscriminatorValue().
	*/
	
	@Id
	private Long matricula;

	private String nome;

	public Aluno() {

	}

	public Aluno(Long matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
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

}


