package relacionamento.many_to_many;

import infra.DataAccessObject;
import modelo.classe_many_to_many.Sobrinho;
import modelo.classe_many_to_many.Tio;

public class InsertTioSobrinho {

	public static void main(String[] args) {
		
		Tio tia1 = new Tio("Maria");
		Tio tio2 = new Tio("João");
		
		Sobrinho sobrinho1 = new Sobrinho("Carlos");
		Sobrinho sobrinho2 = new Sobrinho("Luis");
		
		tia1.getSobrinhos().add(sobrinho1);
		sobrinho1.getTios().add(tia1);
		
		tia1.getSobrinhos().add(sobrinho2);
		sobrinho2.getTios().add(tia1);
		
		tio2.getSobrinhos().add(sobrinho1);
		sobrinho1.getTios().add(tio2);
		
		tio2.getSobrinhos().add(sobrinho2);
		sobrinho2.getTios().add(tio2);
		
		DataAccessObject<Object> dao = new DataAccessObject<Object>();
		
		dao.abrirTransacao()
			.inserir(tia1)
			.inserir(tio2)
			.inserir(sobrinho1)
			.inserir(sobrinho2)
			.fecharTransacao()
			.fecharDAO();
	}
}
