package consultas.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class SelectUsuarios {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager entityManager = emf.createEntityManager();
		
		/* Primeiro exemplo: jpql(Java Persistence Query Lannguage) */
		String jpql = "select u from Usuario u";  // Retorna todos os registros da tabela Usuario
		
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);  // Consulta com tipo
		
		query.setMaxResults(5);  // Limita a quantidade de registros a serem retornado
		
		List<Usuario> usuarios = query.getResultList(); 
		
		for(Usuario usuario: usuarios) {
			System.out.println("Id: " + usuario.getId() + " -> Nome: "+ usuario.getNome() +" - E-mail: " + usuario.getEmail());
		}
		
		entityManager.close();
		emf.close();
		
		/* Segundo exemplo: 
		List<Usuario> usuarios = entityManager
				.createQuery("select user from Usuario user", Usuario.class)
				.setMaxResults(5)
				.getResultList();
		
		for(Usuario usuario: usuarios) {
			System.out.println("Id : "+ usuario.getId() +" -> Nome: "+ usuario.getNome() +" - E-mail: " + usuario.getEmail());
		}
		
		entityManager.close();
		emf.close();
		*/
		
		
	}
}
