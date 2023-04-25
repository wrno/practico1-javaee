package tse2023.grupo16.practico1;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tse2023.grupo16.practico1.datatypes.DtCiudadano;
import tse2023.grupo16.practico1.negocios.CiudadanoNegocioRemote;

/**
 * Servlet implementation class GuardarModificacion
 */
@WebServlet("/GuardarModificacion")
public class GuardarModificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB CiudadanoNegocioRemote ciudadanos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarModificacion() {
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
		if(request.getParameter("ci") != null) {
			try {
				int ciOriginal = Integer.parseInt(request.getParameter("ci"));
				int ciNueva = Integer.parseInt(request.getParameter("ciNueva"));
				String emailNuevo = request.getParameter("emailNuevo");
				DtCiudadano ciudadanoViejo = ciudadanos.buscarCiudadanoCi(ciOriginal);
				ciudadanos.modificarEmail(ciudadanoViejo.getEmail(), emailNuevo);
				ciudadanos.modificarCi(ciudadanoViejo.getCi(), ciNueva);
				response.sendRedirect(request.getContextPath() + "/Ciudadano?ci=" + ciNueva);
			}catch(Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				request.getRequestDispatcher("/Modificar").forward(request, response);
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/Ciudadanos");
		}
	}

}
