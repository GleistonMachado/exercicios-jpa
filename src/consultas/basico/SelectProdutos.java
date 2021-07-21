package consultas.basico;

import java.util.List;

import infra.ProdutoDAO;
import modelo.basico.Produto;

public class SelectProdutos {

	public static void main(String[] args) {

		ProdutoDAO dao = new ProdutoDAO();

		List<Produto> produtos = dao.selectTodos();

		for (Produto produto : produtos) {
			System.out.println("Id : " + produto.getId() + " -> Produto " + ": " + produto.getNome());
		}

		double totalPreco = produtos.stream()
				.map(produto -> produto.getPreco())
				.reduce(0.0, (preco, acc) -> preco + acc).doubleValue();

		System.out.println("Valor total: R$ " + totalPreco);

		dao.fecharDAO();

	}

}
