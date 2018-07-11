package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import beans.Tema;
import dao.LibrosDAOImpl;
import dao.TemasDAOImpls;

/**
 * Servlet implementation class GestionLibros
 */
@WebServlet("/GestionLibros")
public class GestionLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GestionLibros() {
        super();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(request.getParameter("opcion")) {
		case "vertemas":
			TemasDAOImpls mistemas = new TemasDAOImpls();
			List<Tema> temas = mistemas.findAll();
			request.setAttribute("temas", temas);
			request.getRequestDispatcher("temas.jsp").forward(request, response);
		case "verlibros":
			if(request.getParameter("idTema") != null) {
			LibrosDAOImpl mislibros = new LibrosDAOImpl();
			List<Libro> libros = mislibros.librosTema(Long.parseLong(request.getParameter("idTema")));
			request.setAttribute("libros", libros);
			request.getRequestDispatcher("libros.jsp").forward(request, response);
		}else {
			request.setAttribute("menexistente", "Elige algun tema");
			request.getRequestDispatcher("GestionLibros?opcion=vertemas").forward(request, response);
		}
		}
	}

}
