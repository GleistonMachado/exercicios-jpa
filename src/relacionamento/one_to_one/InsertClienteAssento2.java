package relacionamento.one_to_one;

import infra.DataAccessObject;
import modelo.classe_one_to_one.Assento;
import modelo.classe_one_to_one.Cliente;

public class InsertClienteAssento2 {

	public static void main(String[] args) {

		Assento assento = new Assento("4D");
		Cliente cliente = new Cliente("Maria", assento);

		DataAccessObject<Cliente> dao = new DataAccessObject<Cliente>(Cliente.class);

		// Sera criado tanto o cliente, quanto o assento, pelo fato de que na
		// classe Cliente o atributo assento esta defido com o
		// @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
		dao.abrirIncluirFechar(cliente);
	}
}
