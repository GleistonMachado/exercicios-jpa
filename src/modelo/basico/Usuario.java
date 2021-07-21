package modelo.basico;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Transient;

@Entity
public class Usuario {

	@Id // Determina que a tabela id será a tabela Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Determina que a tabela id será auto increment
	private Long id;

	// Se usa o @Column quando se quer alterar valores padrões e
	// quando o nome da coluna sera diferente a do atributo
	// @Column(name = "name", nullable = false)
	private String nome;

	// O @Transient  -> determina que o atributo nao sera criado(mapeado) no banco de dados
	@Column(unique = true) // Determina que o email nao podera ser repetido.
	private String email;

	public Usuario() {

	}

	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
