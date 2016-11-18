package cst;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Hangman
 */
public class Hangman extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public class Game{
		String word = "apple";
		String correct = "";   // the correct letters that have been guessed so far
		String badGuesses = "";   // the incorrect guesses
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hangman() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get previous HttpSession or create a new one
		HttpSession session = request.getSession(true);
		Game g = (Game) session.getAttribute("GAME");
		if (g == null) {
			// new game started, no previous HttpSession
			g = new Game();
			session.setAttribute("GAME",  g);
			String display = display(g);
			request.setAttribute("DISPLAY",  display);
			request.setAttribute("FILECOUNT", 1 );
			request.setAttribute("DISPLAY",  display);
			request.setAttribute("FILECOUNT", 1+g.badGuesses.length() );
			request.getRequestDispatcher("hgcont.jsp").forward(request, response);
			return;
			
		} else {
			// continue previous game
		    String guess = request.getParameter("guess"); // get the user guess
			boolean correct = false;
			if (guess !=null && guess.length() == 1 ) {
					 // user entered a new guess of a single letter
					 if (g.word.indexOf(guess) >= 0){
						 // a correct guess
						 g.correct = g.correct+guess;
						 correct = true;
					 } else {
						 // a bad guess
						 g.badGuesses = g.badGuesses + guess;
						 correct = false;
					 }
			} else {
				// guess is not valid. 
				// no guess was entered, the user just hit submit 
				// the guess was more than 1 letter 
				
			}
			// create string of correctly guessed letters and underscore for letters still to be guessed
			String display = display(g);
			request.setAttribute("DISPLAY",  display);
			// FILECOUNT indicates the gif file to display
			request.setAttribute("FILECOUNT", 1+g.badGuesses.length() );
			
			if (win(g)){
				// game is won
				session.invalidate(); // delete HttpSession
				request.getRequestDispatcher("hgwin.jsp").forward(request, response);
			} else if (g.badGuesses.length() >= 6) {
				// game lost
				request.setAttribute("DISPLAY",  g.word);
				session.invalidate();   // delete HttpSession
				request.getRequestDispatcher("hglose.jsp").forward(request, response);
			} else {
				// continue game
				if (correct) {
					request.getRequestDispatcher("hgcont.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("hgcontmiss.jsp").forward(request, response);
				}
			}
		}

	  }
	
	private String display(Game g) {
		String result = "";
		for (int i=0; i< g.word.length(); i++){
			char c = g.word.charAt(i);
			if (g.correct.indexOf(c) >= 0){
				// this letter has been correctly guess, so display i8t
				result = result + c + " ";
			} else {
				// this letter has not been guessed yet
				result = result + "_ ";
			}
		}
		return result;
	}
	
	private boolean win(Game g) {
		for (int i=0; i< g.word.length(); i++) {
			if (g.correct.indexOf(g.word.charAt(i)) < 0 ) {
				return false;
			}
		}
		return true;
	}

}
