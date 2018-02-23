package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.team;



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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String teamName = request.getParameter("teamName");
		String teamType = request.getParameter("teamType");
		String perferredNight = request.getParameter("preferredNight");
		
		
		team t = new team(teamName, teamType, perferredNight);
		teamHelper dao = new teamHelper();
		dao.insertTeam(t);
		
		getServletContext().getRequestDispatcher("/addTeam.html").forward(request, response);
	}

}
