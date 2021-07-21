package consultas.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class UpdateUsuarioDois {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Usuario usuario = em.find(Usuario.class, 1L);
		usuario.setNome("Gleiston");

		// Objeto por padrão esta no estado gerenciado, ou seja: toda alteração na
		// Classe usuario, gerara uma atualização no banco de dados.
		// Obs: desta maneira não nescessita chamar o metodo merge().
		// em.merge(usuario);

		em.getTransaction().commit();

		System.out.println(usuario.getNome());

		em.close();
		emf.close();

	}
}
