package controller;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import model.team;



public class teamHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueCooney");
	

	public void insertTeam(team toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	
}
