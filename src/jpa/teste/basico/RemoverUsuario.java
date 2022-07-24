package jpa.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;

import jpa.model.basico.Usuario;
public class RemoverUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoudemy");
		EntityManager em = emf.createEntityManager();
		
		Usuario user = em.find(Usuario.class, 5L);
		System.out.println(user.toString());

		if (user != null) {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		}
		em.close();
		emf.close();
	}

}
