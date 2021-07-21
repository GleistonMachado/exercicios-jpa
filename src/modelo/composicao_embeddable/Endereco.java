package modelo.composicao_embeddable;

import javax.persistence.Embeddable;

/*
 * @Embeddable -> N�o ser� criada uma atabela no banco de dados, 
 * mas quem criar um atributo do tipo Endere�o, 
 * tera acesso aos seus atributos.
 */
@Embeddable
public class Endereco {

	private String logradouro;
	
	private String complemento;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
}
