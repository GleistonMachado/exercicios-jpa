package consultas.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class SelectUsuario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entityManager = emf.createEntityManager();

		Usuario usuario = entityManager.find(Usuario.class, 1L);

		System.out.println("Id : "+ usuario.getId() +" -> "+ usuario.getNome());

		entityManager.close();
		emf.close();
	}

}
