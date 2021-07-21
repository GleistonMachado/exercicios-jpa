package consultas.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class DeleteUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entityManager = emf.createEntityManager();
		
		Usuario usuario = entityManager.find(Usuario.class, 5L);
		
		if(usuario != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.merge(usuario));
			entityManager.getTransaction().commit();
		}
		
		entityManager.close();
		emf.close();
	}
}
