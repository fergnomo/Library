package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;
import dao.UsuarioDAOImpl;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//HttpSession misession;
    public Login() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
			
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		HttpSession carro = request.getSession();
		switch(request.getParameter("opcion")) {
		case "validar":
			if(carro.getAttribute("carrito") != null && carro.getAttribute("invitado") !=null) {
				UsuarioDAOImpl usuario = new UsuarioDAOImpl();
				Usuario miuser = usuario.findByID(request.getParameter("idUsuario"));
				if(miuser != null) {
				if(miuser.getTipoUsuario().equals("ADMON") && miuser.getPassword().equals(request.getParameter("password"))) {	
					HttpSession user = request.getSession();
					user.setAttribute("usuario", miuser);
					//user.getAttribute("carrito");
					request.getRequestDispatcher("GestionCarrito?opcion=detalles").forward(request, response);					
				}	
				else {
					if(miuser.getPassword().equals(request.getParameter("password"))) {
					HttpSession user = request.getSession();
					user.setAttribute("usuario", miuser);
					request.getRequestDispatcher("GestionCarrito?opcion=detalles").forward(request, response);
					}else {
						request.setAttribute("menexistente", "Usuario no exite");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
						
				}
				}else {
					request.setAttribute("menexistente", "Usuario no exite");
					request.getRequestDispatcher("index.jsp").forward(request, response);				
			}
			}else {
				UsuarioDAOImpl usuario = new UsuarioDAOImpl();
				Usuario miuser = usuario.findByID(request.getParameter("idUsuario"));
				if(miuser != null) {
				if(miuser.getTipoUsuario().equals("ADMON") && miuser.getPassword().equals(request.getParameter("password"))) {	
					HttpSession user = request.getSession();
					user.setAttribute("usuario", miuser);
					//user.getAttribute("carrito");
					request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
					
				}
					
				else {
					if(miuser.getPassword().equals(request.getParameter("password"))) {
					HttpSession user = request.getSession();
					user.setAttribute("usuario", miuser);
					request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
					}else {
						request.setAttribute("menexistente", "Usuario no exite");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
						
				}
				
				}else {
					request.setAttribute("menexistente", "Usuario no exite");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
		}
			break;
		case "registrar":
			UsuarioDAOImpl usuario2 = new UsuarioDAOImpl();
			Usuario miuser2 = new Usuario();
			miuser2.setIdUsuario(request.getParameter("idUsuario"));
			miuser2.setPassword(request.getParameter("password"));
			miuser2.setNombre(request.getParameter("nombre"));
			miuser2.setApellido(request.getParameter("apellido"));
			miuser2.setDireccion(request.getParameter("direccion"));
			miuser2.setFechaAlta(new Date(new java.util.Date().getTime()));
			miuser2.setTipoUsuario(request.getParameter("idUsuario"));
			if(usuario2.insert(miuser2) == 1) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}else {
				request.setAttribute("menexistente", "Usuario ya existente");
				request.getRequestDispatcher("registro.jsp").forward(request, response);		
			}
			break;
		}
	}
}
