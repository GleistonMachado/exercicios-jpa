package relacionamento.one_to_one;

import infra.DataAccessObject;
import modelo.classe_one_to_one.Assento;
import modelo.classe_one_to_one.Cliente;

public class InsertClienteAssento1 {
	
	public static void main(String[] args) {
		
		Assento assento = new Assento("16A");
		Cliente cliente = new Cliente("Ana Maria", assento);
		
		DataAccessObject<Object> dao = new DataAccessObject<Object>();
		
		dao.abrirTransacao()
			.inserir(assento)
			.inserir(cliente)
			.fecharTransacao()
			.fecharDAO();
		
	}
}
