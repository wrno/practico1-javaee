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
 * Servlet implementation class RegistrarCiudadano
 */
@WebServlet("/RegistrarCiudadano")
public class RegistrarCiudadano extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private CiudadanoNegocioRemote ciudadanoRemoto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarCiudadano() {
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
			String email = request.getParameter("email").toString();
			int ci = Integer.parseInt(request.getParameter("ci"));
			ciudadanoRemoto.registrarCiudadano(email, ci);
			request.setAttribute("exito", true);
		}catch(Exception e) {
			if(request.getParameter("email").isEmpty() || request.getParameter("ci").isEmpty()) {
				request.setAttribute("errorMessage", "Debe ingresar e-mail y cédula de identidad.");
			}else {
				request.setAttribute("errorMessage", e.getMessage());
			}
			request.setAttribute("email", request.getParameter("email"));
			request.setAttribute("ci", request.getParameter("ci"));
			request.setAttribute("exito", false);
		}
		request.getServletContext().getRequestDispatcher("/registrar.jsp").forward(request, response);
	}

}
