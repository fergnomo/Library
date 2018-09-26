<%@page import="beans.DetallePedido"%>
<%@page import="beans.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedidos</title>
</head>
<body>
<%List<Pedido> cesta = (List<Pedido>)request.getAttribute("pedidos");%>

<table border="0">
 
 <%if(cesta != null) {%>
  <%for(int i = 0; i<cesta.size();i++) {%>
  <tr>
	<td><h2>Pedido: <%=cesta.get(i).getIdPedido() %></h2></td>
  </tr>
  
<tr>
  	<th>Titulo</th><th>Autor</th>
  </tr>
 
   <tr>	
   			
   			<% for(DetallePedido ele: cesta.get(i).getDetallePedidos()) {%>
  			<td><%= ele.getLibro().getTitulo()%></td>
  			<td><%= ele.getLibro().getAutor()%></td>
  		
    	</tr>
   <%} %>
   <%} %>
   <%} %>
</table>
		<nav>
    	 <ul>      
       <li><a href="bienvenida.jsp">Volver al Menú</a></li>
       <li><a href="GestionCarrito?opcion=desconn">Cerrar sesion</a></li>
       	</ul>
       	</nav>
</body>
</html>