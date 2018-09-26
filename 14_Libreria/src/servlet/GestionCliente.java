package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Direccion;
import beans.Pedido;
import beans.Tema;
import beans.Usuario;
import dao.DireccionDAOImpl;
import dao.PedidoDAOImpl;
import dao.TemasDAOImpls;

/**
 * Servlet implementation class GestionCliente
 */
@WebServlet("/GestionCliente")
public class GestionCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCliente() {
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
		HttpSession cliente = request.getSession();
		RequestDispatcher rd;
		switch(request.getParameter("opcion")) {
		case "altaDireccion":
			DireccionDAOImpl dic = new DireccionDAOImpl();
			Direccion midic = new Direccion();
			midic.setCalle(request.getParameter("calle"));
			midic.setDistrito(request.getParameter("distrito"));
			midic.setUsuario((Usuario)cliente.getAttribute("usuario"));
			dic.insert(midic);
			if(dic.insert(midic) == 1) {
				request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
				
			}else {
				request.setAttribute("menexistente", "Direccion ya existente");
				request.getRequestDispatcher("altaDireccion.jsp").forward(request, response);
			
			}
			break;
		case"pedidos":
			PedidoDAOImpl pdao = new PedidoDAOImpl();
			List<Pedido> pedidos = pdao.findPedidos(((Usuario)cliente.getAttribute("usuario")).getIdUsuario());
			request.setAttribute("pedidos", pedidos);
			request.getRequestDispatcher("pedidosCliente.jsp").forward(request, response);
			break;
		}
		
	}

}
