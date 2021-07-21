package infra;

import modelo.basico.Produto;

public class ProdutoDAO extends DataAccessObject<Produto> {

	public ProdutoDAO() {
		super(Produto.class);
	}
	
}
