package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DataAccessObject<E> {

	private static EntityManagerFactory emf;

	private EntityManager entityManager;

	private Class<E> classe;

	// Sera criado somente uma vez, assim que a classe for carregada.
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// TODO Criar um arquivo de log, usando a api log4j ou outra similar
		}
	}

	// Construtor que determina que o atributo classe pode ser null
	public DataAccessObject() {
		this(null); 
	}

	// Construtor que que cria o EntityManager
	public DataAccessObject(Class<E> classe) {
		this.classe = classe;
		entityManager = emf.createEntityManager();
	}
	
	/*
	 * Métodos relacionado ao Transaction
	*/
	public DataAccessObject<E> abrirTransacao() {
		entityManager.getTransaction().begin();
		return this;
	}

	public DataAccessObject<E> fecharTransacao() {
		entityManager.getTransaction().commit();
		return this;
	}

	public DataAccessObject<E> inserir(E instancia) {
		entityManager.persist(instancia);
		return this;
	}

	public DataAccessObject<E> abrirIncluirFechar(E instancia) {
		return this.abrirTransacao().inserir(instancia).fecharTransacao();
	}

	/* 
	 * Seleciona um unico registro no banco de dados
	*/
	public E selectRegistro(Object id) {
		return entityManager.find(classe, id);
	}

	public List<E> selectTodos(int limit, int offset) { 
		if (classe == null) {
			throw new UnsupportedOperationException("Classe está nula");
		}

		String jpql = "select entidade from " + classe.getName() + "entidade";

		TypedQuery<E> query = entityManager.createQuery(jpql, classe);
		query.setMaxResults(limit);    // Quantida de registros a serem retonardos
		query.setFirstResult(offset); // Apartir de qual Indice sera buscado
		
		return query.getResultList();
	}

	public List<E> selectTodos() {
		return this.selectTodos(10, 0);
	}

	/* 
	 * Método usado para o Named Query
	*/
	public List<E> consultar(String nomeConsulta, Object... params) {
		TypedQuery<E> query = entityManager.createNamedQuery(nomeConsulta, classe);

		for (int i = 0; i < params.length; i += 2) {
			query.setParameter(params[i].toString(), params[i + 1]); // params[i].toString() pega a chave e params[i + 1 pega o valor do atributo
		}

		return query.getResultList();
	}

	/* 
	 * Método usado para o Named Query Native
	*/
	public E consultarApenasUm(String nomeConsulta, Object... params) {
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}

	public void fecharDAO() {
		entityManager.clear();
	}

}
