package tse2023.grupo16.practico1;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tse2023.grupo16.practico1.data.CiudadanosRemote;
import tse2023.grupo16.practico1.datatypes.DtCiudadano;

/**
 * Servlet implementation class Ciudadano
 */
@WebServlet("/Ciudadano")
public class Ciudadano extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB CiudadanosRemote ciudadanos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ciudadano() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("ci") != null) {
			try {
				int ci = Integer.parseInt(request.getParameter("ci"));
				DtCiudadano ciudadano = ciudadanos.buscarCiudadanoCi(ci);
				request.setAttribute("ciudadano", ciudadano);
			}catch(Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
			}
			request.getRequestDispatcher("ciudadano.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+ "/Ciudadanos");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
