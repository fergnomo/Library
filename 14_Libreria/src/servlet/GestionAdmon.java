package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import beans.Libro;
import beans.Pedido;
import beans.Tema;
import beans.Usuario;
import dao.LibrosDAOImpl;
import dao.PedidoDAOImpl;
import dao.TemasDAOImpls;
import dao.UsuarioDAOImpl;


@WebServlet("/GestionAdmon")
public class GestionAdmon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GestionAdmon() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession users = request.getSession();
		switch(request.getParameter("opcion")) {
		case "temas":
			TemasDAOImpls tema = new TemasDAOImpls();
			Tema mitema = new Tema();
			mitema.setIdTema(Long.parseLong(request.getParameter("idTema")));
			mitema.setDescTema(request.getParameter("descTema"));
			mitema.setAbreviatura(request.getParameter("abreviatura"));
			tema.insert(mitema);
			if(tema.insert(mitema) == 1) {
				request.getRequestDispatcher("admon.jsp").forward(request, response);
				
			}else {
				request.setAttribute("menexistente", "Tema ya existente");
				request.getRequestDispatcher("admon.jsp").forward(request, response);
			
			}
			break;
		case "libros":
			LibrosDAOImpl libro = new LibrosDAOImpl();
			Libro milibro = new Libro();
			TemasDAOImpls mitema2 = new TemasDAOImpls();
			Tema tema2 = mitema2.findByID(Long.parseLong(request.getParameter("idTema")));
			milibro.setIsbn(request.getParameter("isbn"));
			milibro.setTitulo(request.getParameter("titulo"));
			milibro.setAutor(request.getParameter("autor"));
			milibro.setPrecioUnitario(BigDecimal.valueOf(Double.parseDouble(request.getParameter("precioUnitario"))));
			milibro.setStock(BigDecimal.valueOf(Long.parseLong(request.getParameter("stock"))));
			if(tema2 == null) {
				request.setAttribute("temexistente", "Tema no existe");
				request.getRequestDispatcher("admon.jsp").forward(request, response);
			}else {
			milibro.setTema(tema2);
			libro.insert(milibro);
			if(libro.insert(milibro) == 1) {
				request.getRequestDispatcher("admon.jsp").forward(request, response);
			}else {
				request.setAttribute("libexistente", "Libro ya existente");
				request.getRequestDispatcher("admon.jsp").forward(request, response);
				}
			}
			break;
		case "fechas":
			PedidoDAOImpl mipedido = new PedidoDAOImpl();
			//Pedido pedido = new Pedido();
			String dia = request.getParameter("fechaAlta");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = new Date();
			try {
				fecha = sdf.parse(dia);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			List<Pedido> pedidos = mipedido.pedidosFecha(fecha);
			request.setAttribute("pedidos", pedidos);
			request.getRequestDispatcher("pedido.jsp").forward(request, response);
			break;
		case"clientes":
			UsuarioDAOImpl misusers = new UsuarioDAOImpl();
			List<Usuario> usuus = misusers.findAll();
			users.setAttribute("clientes", usuus);
			request.getRequestDispatcher("admon.jsp").forward(request, response);
			break;
		case"datos":
			PedidoDAOImpl pdao = new PedidoDAOImpl();
			Object[] estadisticas = pdao.findPedidosByUsuario(request.getParameter("us"));
			request.setAttribute("estadisticas", estadisticas);
			request.getRequestDispatcher("datos.jsp").forward(request, response);
			break;
			/*
			case"eliminar":
			((List<Usuario>)users.getAttribute("clientes")).remove(Integer.parseInt(request.getParameter("us")));;
			request.getRequestDispatcher("admon.jsp").forward(request, response);
			break;
			*/
		}
	}		
}

