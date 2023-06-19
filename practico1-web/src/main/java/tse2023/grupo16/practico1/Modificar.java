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
 * Servlet implementation class Modificar
 */
@WebServlet("/Modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB CiudadanoNegocioRemote ciudadanos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modificar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("ci") != null) {
			try {
				int ci = Integer.parseInt(request.getParameter("ci"));
				request.setAttribute("ciudadano", ciudadanos.buscarCiudadanoCi(ci));
			}catch(Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
			}
			request.getRequestDispatcher("/modificar.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/Ciudadanos");
		}
	}

}
