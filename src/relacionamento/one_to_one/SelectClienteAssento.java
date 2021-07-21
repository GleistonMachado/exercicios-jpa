package relacionamento.one_to_one;

import infra.DataAccessObject;
import modelo.classe_one_to_one.Assento;
import modelo.classe_one_to_one.Cliente;

public class SelectClienteAssento {

	public static void main(String[] args) {
		
		// Acessando o assento a partir de um consulta feita pelo id do cliente
		DataAccessObject<Cliente> daoCliente = new DataAccessObject<>(Cliente.class);
		Cliente cliente = daoCliente.selectRegistro(1L);
		System.out.println("Nome: "+ cliente.getNome() +" - Assento: "+ cliente.getAssento().getNome());
		daoCliente.fecharDAO();
		
		// Acessando o cliente a partir de um consulta feita pelo id do assento
		DataAccessObject<Assento> daoAssento = new DataAccessObject<>(Assento.class);
		Assento assento = daoAssento.selectRegistro(4l);
		System.out.println("Nome: "+ assento.getCliente().getNome() + " - Assento: " + assento.getNome());
		daoAssento.fecharDAO();
	}
}
