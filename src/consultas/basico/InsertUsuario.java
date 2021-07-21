package consultas.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class InsertUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entityManager = emf.createEntityManager();
		
		// Usuario novoUsuario = new Usuario("Gleiston Machado", "gleiston@gmail.com");
		Usuario novoUsuario = new Usuario("Fulano", "fulano@gmail.com");
		
		entityManager.getTransaction().begin();
		entityManager.persist(novoUsuario);
		entityManager.getTransaction().commit();
		
		System.out.println("O Id gerado foi: "  + novoUsuario.getId());
		
		entityManager.close();
		emf.close();
	}
}
