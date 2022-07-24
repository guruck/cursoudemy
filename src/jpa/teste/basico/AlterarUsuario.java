package jpa.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;

import jpa.model.basico.Usuario;
public class AlterarUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoudemy");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Usuario user = em.find(Usuario.class, 5L);
		System.out.println(user.toString());
		
		user.setNome("Loira do Tchan");
		em.merge(user); //opcional no caso do objeto estar no estado gerenciado
		em.getTransaction().commit();		
		em.close();
		emf.close();
	}

}
