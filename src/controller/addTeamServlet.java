package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;



/**
 * Servlet implementation class addTeamServlet
 */
@WebServlet("/addTeamServlet")
public class addTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String teamName = request.getParameter("teamName");
		String teamType = request.getParameter("teamType");
		String perferredNight = request.getParameter("preferredNight");
		TeamHelper th = new TeamHelper();
		Team t = new Team(teamName, teamType, perferredNight);
		th.insertTeam(t);
		
		getServletContext().getRequestDispatcher("/addTeam.html").forward(request, response);
	}

}
