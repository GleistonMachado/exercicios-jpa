package consultas.heranca;

import infra.DataAccessObject;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class InsertAluno {

	public static void main(String[] args) {

		Aluno aluno1 = new Aluno(123L, "Gleiston");
		AlunoBolsista aluno2 = new AlunoBolsista(456L, "Fabiana", 2000.00);

		DataAccessObject<Aluno> alunoDAO = new DataAccessObject<>();
		alunoDAO.abrirIncluirFechar(aluno1);
		alunoDAO.abrirIncluirFechar(aluno2);
		alunoDAO.fecharDAO();

	}
}
