package consultas.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class UpdateUsuarioTres {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entityManager = emf.createEntityManager();
		
		entityManager.getTransaction().begin();
		Usuario usuario = entityManager.find(Usuario.class, 7L);
		
		// Retira o objeto do estado gerenciado, assim você sera obrigado a chamar o metodo merge()	
		entityManager.detach(usuario);
		
		usuario.setNome("Gleiston");
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		emf.close();
		
	}
	
}
