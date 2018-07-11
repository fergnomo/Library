<%@page import="beans.DetallePedido"%>
<%@page import="java.util.List"%>
<%@page import="beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedido</title>
</head>
<body>
<center><h2>Pedido de: <%=((Usuario)session.getAttribute("usuario")).getNombre().toUpperCase()%></h2></center>

<%List<DetallePedido> cesta = (List<DetallePedido>)session.getAttribute("detalless");%>
<table border="0">
<tr>
  	<th>Pedido</th><th>Direccion</th><th>Usuario</th><th>Libro</th><th>Cantidad</th><th>Precio</th><th>Fecha</th>
  </tr>
  
 <%if(cesta != null) {%>
  <%for(int i = 0; i<cesta.size();i++) {%>
   <tr>
  			<td><%= cesta.get(i).getPedido().getIdPedido()%></td>
  			<td><%= cesta.get(i).getPedido().getDireccionEntrega()%></td>
  			<td><%= cesta.get(i).getPedido().getUsuario()%></td>
    		<td><%= cesta.get(i).getLibro().getTitulo()%></td>
    		<td><%= cesta.get(i).getCantidad()%></td>
    		<td><%= cesta.get(i).getPrecioVenta()%></td>
    		<td><%= cesta.get(i).getFechaAlta()%></td>
    	</tr>
   <%} %>
   <%} %>
</table>
		<nav>
    	 <ul>      
    	<li><a href="GestionCarrito?opcion=comprar">Tramitar pedido</a></li>
       <li><a href="GestionLibros?opcion=vertemas">Ver Temas</a></li>
       <li><a href="GestionCarrito?opcion=desconn">Cerrar sesion</a></li>
       	</ul>
       	</nav>
</body>
</html>