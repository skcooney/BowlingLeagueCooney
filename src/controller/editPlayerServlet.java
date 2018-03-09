package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;

/**
 * Servlet implementation class editPlayerServlet
 */
@WebServlet("/editPlayerServlet")
public class editPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String act = request.getParameter("doThisToPlayer");
		PlayerHelper ph = new PlayerHelper();
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
			
		} else if (act.equals("Delete Player")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Player playerToDelete = ph.searchForPlayerById(tempId);
			//System.out.println("Temp ID:" + tempId);
			ph.deletePlayer(playerToDelete);
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
						
		
		} else if (act.equals("Add new Player")) {
			getServletContext().getRequestDispatcher("/addPlayer.html").forward(request, response);

		}

	}

}