package consultas.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class UpdateUsuarioUm {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entityManager = emf.createEntityManager();

		entityManager.getTransaction().begin();
		Usuario usuario = entityManager.find(Usuario.class, 7L);  //  Pega o usuário através do id
		usuario.setEmail("gleiston@gmail.com");   // Seta o novo valor de e-mail usando o metodo Setter da classe Usuario
		usuario.setNome("Gleiston");             // Seta o novo valor de nome usando o metodo Setter da classe Usuario
		entityManager.merge(usuario);           // Faz o a atualização
		entityManager.getTransaction().commit();

		entityManager.close();
		emf.close();
	}
}
