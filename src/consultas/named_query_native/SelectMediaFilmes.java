package consultas.named_query_native;

import infra.DataAccessObject;
import modelo.named_query.NotaFilme;

public class SelectMediaFilmes {

	public static void main(String[] args) {
		
		DataAccessObject<NotaFilme> dao = new DataAccessObject<>(NotaFilme.class);
		
		NotaFilme nota = dao.consultarApenasUm("obterMediaGeralDosFilmes");
		
		System.out.println("Media dos filmes : " + nota.getMedia());
		
		dao.fecharDAO();
	}
}
