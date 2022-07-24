package jpa.teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;

import jpa.model.basico.Usuario;
public class ObterUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoudemy");
		EntityManager em = emf.createEntityManager();
		
//		Usuario user = em.find(Usuario.class, 5L);
//		System.out.println(user.toString());
		
//		String jpql = "SELECT u FROM Usuario u";
//		TypedQuery<Usuario> query = em.createQuery(jpql,Usuario.class);
//		query.setMaxResults(5);
		
		List<Usuario> usuarios = em
				.createQuery("SELECT u FROM Usuario u",Usuario.class)
				.setMaxResults(5)
				.getResultList();
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.toString());
		}
		
		em.close();
		emf.close();
	}

}
