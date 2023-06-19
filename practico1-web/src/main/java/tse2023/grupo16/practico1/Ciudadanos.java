package tse2023.grupo16.practico1;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tse2023.grupo16.practico1.negocios.CiudadanoNegocioRemote;

/**
 * Servlet implementation class Ciudadanos
 */
@WebServlet("/Ciudadanos")
public class Ciudadanos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB CiudadanoNegocioRemote ciudadanos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ciudadanos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("ciudadanos", this.ciudadanos.listarCiudadanos());
		}catch(Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
		}
		request.getRequestDispatcher("/ciudadanos.jsp").forward(request, response);
	}

}
