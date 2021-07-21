package relacionamento.one_to_many;

import infra.DataAccessObject;
import modelo.classe_one_to_many.Pedido;
import modelo.classe_one_to_many.ItemDoPedido;

public class SelectPedido {

	public static void main(String[] args) {

		DataAccessObject<Pedido> dao = new DataAccessObject<Pedido>(Pedido.class);

		Pedido pedido = dao.selectRegistro(1L);

		for (ItemDoPedido item : pedido.getItens()) {
			System.out.println("Data: " + item.getPedido().getData() + " - Pedido " + item.getPedido().getId() + " => "
					+ item.getQuantidade() + " " + item.getProduto().getNome());
		}

		dao.fecharDAO();
	}
}
