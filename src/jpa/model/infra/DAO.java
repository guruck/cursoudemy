package jpa.model.infra;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jdbc.FactoryConection;

public class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;

	static {
		try {
			Map<String, String> properties = new HashMap<String, String>();
			Properties prop = getProperties();
			final String url = prop.getProperty("banco.url") +
					prop.getProperty("banco.server") + 
					prop.getProperty("banco.port") + 
					prop.getProperty("banco.database") + 
					prop.getProperty("banco.details");
			properties.put("javax.persistence.jdbc.driver", prop.getProperty("banco.jdbc.driver"));
			properties.put("javax.persistence.jdbc.url", url);
			properties.put("javax.persistence.jdbc.user", prop.getProperty("banco.user"));
			properties.put("javax.persistence.jdbc.password", prop.getProperty("banco.pswd"));
			properties.put("hibernate.dialect", prop.getProperty("hibernate.dialect"));
			properties.put("hibernate.show_sql", prop.getProperty("hibernate.show_sql"));
			properties.put("hibernate.format_sql", prop.getProperty("hibernate.format_sql"));
			properties.put("hibernate.hbm2ddl.auto", prop.getProperty("hibernate.hbm2ddl.auto"));

			emf = Persistence.createEntityManagerFactory("cursoudemy",properties);
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
	
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/.properties";
		prop.load(FactoryConection.class.getResourceAsStream(caminho));
		return prop;
	}
	//criado apenas para substituir no pacote basico nao necessário
	public static EntityManagerFactory getEmf() {
		return emf;
	}
	public EntityManager getEm() {
		return em;
	}
	
}
