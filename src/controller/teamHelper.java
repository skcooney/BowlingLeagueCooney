package controller;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	 public team searchForTeamById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			team foundTeam = em.find(team.class, idToEdit);
			em.close();
			return foundTeam;
		}
	 
	 public void deleteTeam(team toDelete) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<team> typedQuery = em.createQuery("select at from team at where aw.id = :selectedId", team.class);
			typedQuery.setParameter("selectedId", toDelete.getTeamId());
			typedQuery.setMaxResults(1);
			team result = typedQuery.getSingleResult();
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}
		public List<team> showAllTeams() {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			TypedQuery<team> allResults = em.createQuery("select at from team at ", team.class );
			List<team> allTeams = allResults.getResultList();
			em.close();
			return allTeams;
		}
		 public team searchforTeamByName(String teamName) {
				// TODO Auto-generated method stub
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				TypedQuery<team> typedQuery = em.createQuery("select tn from team tn where tn.teamName = :selectedTeam", team.class);
				typedQuery.setParameter("selectedTeam", teamName);
				typedQuery.setMaxResults(1);
				team result = typedQuery.getSingleResult();
				em.close();
				return result;
				
			}
		 public List<team> viewAllTeamsWithPlayers() {
			 EntityManager em = emfactory.createEntityManager();
			 TypedQuery<team> allResults = em.createQuery("select t.teamName, p.firstName from team t join Player p on teamId = p.teamId", team.class);
			 List<team> allTeams = allResults.getResultList();
			 em.close();
			 return allTeams;
			 
		 }
}
