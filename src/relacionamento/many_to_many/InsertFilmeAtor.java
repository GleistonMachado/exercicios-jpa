package relacionamento.many_to_many;

import infra.DataAccessObject;
import modelo.classe_many_to_many.Ator;
import modelo.classe_many_to_many.Filme;

public class InsertFilmeAtor {

	public static void main(String[] args) {
		
		Filme filmeA = new Filme("Star Wars Ep 4", 8.7);
		Filme filmeB = new Filme("O Fugitivo", 9.7);
		
		Ator atorA = new Ator("Harrison Ford");
		Ator atrizA = new Ator("Carrie Fisher");
		
		filmeA.adicionarAtor(atorA);
		
		filmeA.adicionarAtor(atrizA);
		
		filmeB.adicionarAtor(atorA);
		
		DataAccessObject<Filme> dao = new DataAccessObject<Filme>();
		
		// Qunado inserir o filmeA tambem será inserido o filmeB, 
		// devido os dois filmes terem um ator em comum(Harrison Ford)
		dao.abrirIncluirFechar(filmeA);
 	}
}
