package consultas.basico;

import infra.DataAccessObject;
import modelo.basico.Produto;

public class InsertProduto {

	public static void main(String[] args) {
		
		Produto produto = new Produto("Monitor",899.99);
		
		DataAccessObject<Produto> dao = new DataAccessObject<>(Produto.class);
		
		dao.abrirTransacao()
			.inserir(produto)
			.fecharTransacao()
			.fecharDAO();
		
		// dao.abrirIncluirFechar(produto).fecharDAO();
		
		System.out.println("Id do produto: " + produto.getId());
	}
	
}
