package jpa.model.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	static {
		try {
			emf = Persistence.createEntityManagerFactory("cursoudemy");
		} catch (Exception e) {
			// TODO gerar LOG
			System.out.println(e.getMessage());
		}
	}
	public DAO() {
		this(null);		
	}
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> openTransaction(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> closeTransaction(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> include(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public E findById(Object id){
		return em.find(classe,id);
	}
	
	public DAO<E> includeAtomic(E entidade){
		return this.openTransaction().include(entidade).closeTransaction();
	}
	
	public List<E> getAll(){
		return getAllpag(100,0);
	}
	
	public List<E> getLista(String nomeConsulta, Object... params){
		
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta,classe);
		for (int i = 0; i < params.length; i+=2) {
			query.setParameter(params[i].toString(), params[i+1].toString());
		}
		return query.getResultList();
	}
	
	public E getUm(String nomeConsulta, Object... params){
		List<E> lista = getLista(nomeConsulta,params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	public List<E> getAllpag(int length, int offset){
		if(classe == null) {
			throw new UnsupportedOperationException("ClasseNull");
		}
		String jpql ="SELECT e FROM " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql,classe);
		query.setMaxResults(length).setFirstResult(offset);
		
		return query.getResultList();
	}
	
	public void close() {
		em.close();
	}
}
