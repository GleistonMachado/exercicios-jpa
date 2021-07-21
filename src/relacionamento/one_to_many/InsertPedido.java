package relacionamento.one_to_many;

import infra.DataAccessObject;
import modelo.basico.Produto;
import modelo.classe_one_to_many.ItemDoPedido;
import modelo.classe_one_to_many.Pedido;

public class InsertPedido {

	public static void main(String[] args) {
		
		DataAccessObject<Object> dao = new DataAccessObject<Object>();
		
		Pedido pedido = new Pedido();
		Produto produto = new Produto("Cadeira", 1099.99);
		Produto produto2 = new Produto("Monitor", 679.99);
		Produto produto3 = new Produto("Teclado", 249.99);
		ItemDoPedido item = new ItemDoPedido(pedido, produto, 3);
		ItemDoPedido item2 = new ItemDoPedido(pedido, produto2, 3);
		ItemDoPedido item3 = new ItemDoPedido(pedido, produto3, 3);
		
		dao.abrirTransacao()
			.inserir(produto)
			.inserir(produto2)
			.inserir(produto3)
			.inserir(pedido)
			.inserir(item)
			.inserir(item2)
			.inserir(item3)
			.fecharTransacao()
			.fecharDAO();
	}
}
