package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Artwork;
import model.ListItem;
import model.Player;
import model.team;

public class PlayerHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueCooney");
	public void insertPlayer(Player toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
		
	}
	public List<Player> showAllPlayers() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Player> allResults = em.createQuery("select ap from Player ap ", Player.class );
		List<Player> allPlayer = allResults.getResultList();
		em.close();
		return allPlayer;
	}

	public List<team> showAllTeams() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<team> allResults = em.createQuery("select at from team at ", team.class );
		List<team> allTeams = allResults.getResultList();
		em.close();
		return allTeams;
	}
	

	 public void deletePlayer(Player toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select ap from Player ap where aw.id = :selectedId", Player.class);
		typedQuery.setParameter("selectedId", toDelete.getPlayerId());
		typedQuery.setMaxResults(1);
		Player result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	 
	 
	 public Player searchForPlayerById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			Player foundPlayer = em.find(Player.class, idToEdit);
			em.close();
			return foundPlayer;
		}
	
	 
	/* public void updateArt(Artwork toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
			
		}
*/

}
