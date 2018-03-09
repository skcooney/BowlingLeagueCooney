package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;

/**
 * Servlet implementation class editTeamServlet
 */
@WebServlet("/editTeamServlet")
public class editTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editTeamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		String act = request.getParameter("doThisToTeam");
		TeamHelper th = new TeamHelper();
		PlayerHelper ph = new PlayerHelper();
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
		
		}  else if (act.equals("Delete Team and Players on Team")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Team teamToDelete = th.searchForTeamById(tempId);
			ph.deleteAllPlayersOnteam(teamToDelete);
			th.deleteTeam(teamToDelete);
			getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
				
			
		}else if (act.equals("Add New Team")) {
			getServletContext().getRequestDispatcher("/addTeam.html").forward(request, response);
			
		
			}

		}
	}

