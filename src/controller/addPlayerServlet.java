package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Player;
import model.Team;

/**
 * Servlet implementation class addPlayerServlet
 */
@WebServlet("/addPlayerServlet")
public class addPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String screenName = request.getParameter("screenName");
		String teamName = request.getParameter("teamName");
		Team team;
		
		TeamHelper th = new TeamHelper();
		PlayerHelper ph = new PlayerHelper();
		if(th.findTeamByName(teamName) == null){
			team = new Team(teamName);
			th.insertTeam(team);
		}else {
			team =th.findTeamByName(teamName);
		}
		Player player = new Player(firstName, lastName, phoneNumber, screenName, team);
		ph.insertPlayer(player);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}
	}
		