package jpa.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import jpa.model.basico.Usuario;
import jpa.model.infra.DAO;
public class NovoUsuario {

	public static void main(String[] args) {
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoudemy");
//		EntityManager em = emf.createEntityManager();
		DAO<Usuario> dao = new DAO<>();
		EntityManagerFactory emf = DAO.getEmf();
		EntityManager em = dao.getEm();		
//		Usuario novo = new Usuario("Jonas Brother","jonas@brother.com");
//		Usuario novo = new Usuario("Xitao Xororo","xitao@xororo.com");
//		Usuario novo = new Usuario("Xuxa Meneguel","xuxa@meneguel.com");
//		Usuario novo = new Usuario("Patati Patata","patati@patata.com");
		Usuario novo = new Usuario("Carla Peres","carla@peres.com");
		em.getTransaction().begin();
		em.persist(novo);
		em.getTransaction().commit();
		
		System.out.println("O registro do usuario foi no id: " + novo.getId());
		em.close();
		emf.close();
	}

}
