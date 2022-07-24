package jpa.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import jpa.model.basico.Usuario;
import jpa.model.infra.DAO;
public class RemoverUsuario {

	public static void main(String[] args) {
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoudemy");
//		EntityManager em = emf.createEntityManager();
		DAO<Usuario> dao = new DAO<>();
		EntityManagerFactory emf = DAO.getEmf();
		EntityManager em = dao.getEm();
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
