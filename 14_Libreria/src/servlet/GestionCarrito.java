package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionIdListener;

import beans.DetallePedido;
import beans.Libro;
import beans.Pedido;
import beans.Usuario;
import dao.DetallePedidoDAOImpl;
import dao.LibroDAO;
import dao.LibrosDAOImpl;
import dao.PedidoDAOImpl;

/**
 * Servlet implementation class GestionCarrito
 */
@WebServlet("/GestionCarrito")
public class GestionCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession micarri = request.getSession();
		RequestDispatcher rd;
		switch(request.getParameter("opcion")) {
		case "add":
			if(micarri.getAttribute("usuario")!=null) {
				List<Libro> lista = (List<Libro>) micarri.getAttribute("carrito");
				LibrosDAOImpl micarrito = new LibrosDAOImpl();
				if(request.getParameterValues("isbn") != null) {
				if(lista == null)
					lista = new ArrayList<Libro>();
				for(String ele: request.getParameterValues("isbn")) {
					Libro libro = micarrito.findByID(ele);
					if(!lista.contains(libro))
						lista.add(libro);
				}
				}else {
					request.setAttribute("menexistente", "Elige libros para añadir al carrito");
					request.getRequestDispatcher("GestionLibros?opcion=vertemas").forward(request, response);
				}
					
				micarri.setAttribute("carrito", lista);
				request.getRequestDispatcher("GestionLibros?opcion=vertemas").forward(request, response);
				
				}else {
				Usuario user = new Usuario();
				user.setIdUsuario("invitado");
				micarri.setAttribute("invitado", user);	
				List<Libro> lista2 = (List<Libro>) micarri.getAttribute("carrito");
				LibrosDAOImpl micarrito = new LibrosDAOImpl();
				if(request.getParameterValues("isbn") != null) {
				if(lista2 == null)
					lista2 = new ArrayList<Libro>();
				for(String ele: request.getParameterValues("isbn")) {
					Libro libro = micarrito.findByID(ele);
					if(!lista2.contains(libro))
						lista2.add(libro);
				}
				}else {
					request.setAttribute("menexistente", "Elige libros para añadir al carrito");
					request.getRequestDispatcher("GestionLibros?opcion=vertemas").forward(request, response);
				}
					
				micarri.setAttribute("carrito", lista2);
				request.getRequestDispatcher("GestionLibros?opcion=vertemas").forward(request, response);
			}
			break;
		
		case "vaciar":
			((List<Libro>)micarri.getAttribute("carrito")).clear();
			request.getRequestDispatcher("GestionLibros?opcion=vertemas").forward(request, response);
			break;
		case "eliminar":
			((List<Libro>)micarri.getAttribute("carrito")).remove(Integer.parseInt(request.getParameter("lib")));;
			request.getRequestDispatcher("carrito.jsp").forward(request, response);
			break;
		case "detalles":
			if((Usuario)micarri.getAttribute("usuario")!=null || micarri.getAttribute("invitado")==null) {
			Pedido pedido = new Pedido();
			PedidoDAOImpl pdao = new PedidoDAOImpl();
			DetallePedidoDAOImpl ddao = new DetallePedidoDAOImpl();
			//pedido.setDetallePedidos(null);
			//pedido.setIdPedido((long)(Math.random()*10000000));
			pedido.setFechaAlta(new Date());
			pedido.setUsuario((Usuario)micarri.getAttribute("usuario"));
			pedido.setDireccionEntrega(((Usuario)micarri.getAttribute("usuario")).getDireccion());
			//request.getParameter("direccion")
			//((Usuario)micarri.getAttribute("usuario")).getDireccion()
			pdao.insert(pedido);
			//System.out.println("si sale esto añade");
			List<DetallePedido> misdetalles = (List<DetallePedido>)micarri.getAttribute("detalless");
			
			if(misdetalles == null) {
			misdetalles = new ArrayList<DetallePedido>();
			
			for(Libro ele: (List<Libro>)micarri.getAttribute("carrito")) {
			DetallePedido detalle = new DetallePedido();
			detalle.setPedido(pedido);
			detalle.setCantidad(BigDecimal.valueOf(1));
			detalle.setFechaAlta(pedido.getFechaAlta());
			detalle.setPrecioVenta(ele.getPrecioUnitario());
			//BigDecimal.valueOf((Double)(micarri.getAttribute("precioTOTAL")))
			detalle.setLibro(ele);
			misdetalles.add(detalle);
			ddao.insert(detalle);
			}
			micarri.setAttribute("detalless",misdetalles);
			request.getRequestDispatcher("detallespedidos.jsp").forward(request, response);	
			}
			}else {
				micarri.getAttribute("carrito");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			break;
		case "comprar":
			Pedido pedido2 = new Pedido();
			PedidoDAOImpl pdao2 = new PedidoDAOImpl();
			DetallePedidoDAOImpl ddao2 = new DetallePedidoDAOImpl();
			//pedido.setDetallePedidos(null);
			//pedido.setIdPedido((long)(Math.random()*10000000));
			pedido2.setFechaAlta(new Date());
			pedido2.setUsuario((Usuario)micarri.getAttribute("usuario"));
			pedido2.setDireccionEntrega(((Usuario)micarri.getAttribute("usuario")).getDireccion());
			//request.getParameter("direccion")
			//((Usuario)micarri.getAttribute("usuario")).getDireccion()
			//pdao2.insert(pedido2);
			//System.out.println("si sale esto no");
			List<DetallePedido> misdetalles2 = (List<DetallePedido>) micarri.getAttribute("detalless");
			//List<DetallePedido> misdetalles = (List<DetallePedido>)micarri.getAttribute("detalless");
			if(misdetalles2 == null) {
			misdetalles2 = new ArrayList<DetallePedido>();
			
			for(Libro ele2: (List<Libro>)micarri.getAttribute("carrito")) {
			DetallePedido detalle2 = new DetallePedido();
			detalle2.setPedido(pedido2);
			detalle2.setCantidad(BigDecimal.valueOf(1));
			detalle2.setFechaAlta(pedido2.getFechaAlta());
			detalle2.setPrecioVenta(ele2.getPrecioUnitario());
			//BigDecimal.valueOf((Double)(micarri.getAttribute("precioTOTAL")))
			detalle2.setLibro(ele2);
			misdetalles2.add(detalle2);
			ddao2.insert(detalle2);
			}
			micarri.setAttribute("detalless",misdetalles2);
			}
			//micarri.removeAttribute("detalles");
			micarri.removeAttribute("carrito");
			micarri.removeAttribute("detalless");
			request.setAttribute("menexistente", "BUENA COMPRA COMPAÑER@");
			request.setAttribute("apagar", "Te toca pagar: " + micarri.getAttribute("precioTOTAL")  + " EUROS");
			request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
			break;	
			
		case "desconn":
			micarri.removeAttribute("carrito");
			micarri.removeAttribute("usuario");
			micarri.removeAttribute("invitado");
			micarri.removeAttribute("libros");
			micarri.removeAttribute("precioTOTAL");
			micarri.invalidate();
			request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
			
			break;
			
		}
	}
}
