package consultas.named_query;

import java.util.List;

import infra.DataAccessObject;
import modelo.classe_many_to_many.Ator;
import modelo.classe_many_to_many.Filme;

public class SelectFilmes {

	public static void main(String[] args) {
		
		DataAccessObject<Filme> dao = new DataAccessObject<Filme>(Filme.class);
		
		List<Filme> filmes = dao.consultar("obterFilmesComNotaMaiorQue", "nota", 8.0);
		
		for(Filme filme : filmes) {
			System.out.println(filme.getNome());
			
			for(Ator ator : filme.getAtores()) {
				System.out.println(ator.getNome());
			}
			
			System.out.println();
		}
	}
}
