package dw;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NameServlet
 */
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameServlet() {
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
		// create or retrieve previous session
		HttpSession session = request.getSession(true);
		Integer counter = (Integer)session.getAttribute("counter");
		if (counter==null) counter = new Integer(0);
		counter = counter + 1;
		session.setAttribute("counter", counter);  // update counter in HttpSession
		String name = request.getParameter("name");  // user name
		int lucky = new Random().nextInt(10000);
		request.setAttribute("lucky", lucky);   // pass name, lucky number and visits to JSP
		request.setAttribute("name", name); 
		System.out.println("lucky="+lucky);
		request.setAttribute("visits", counter);
		request.getRequestDispatcher("nameoutput.jsp").forward(request, response);
	}

}
