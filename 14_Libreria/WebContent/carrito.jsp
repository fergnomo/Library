<%@page import="beans.Usuario"%>
<%@page import="beans.Libro"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Carrito</title>
</head>
<body>
<%if((Usuario)session.getAttribute("usuario") == null) { %>
<small><a class="iniciarsesion" href="index.jsp">Iniciar Sesion</a></small>
<div style="clear:both"></div>
<small><a class="iniciarsesion" href="index.jsp">Administrador</a></small>
<div style="clear:both"></div>
<%} %>
<center><h2>Carrito de: <%if((Usuario)session.getAttribute("usuario")!=null) {%> <%=((Usuario)session.getAttribute("usuario")).getNombre().toUpperCase()%><%} %> </h2></center>

<%List<Libro> cesta = (List<Libro>)session.getAttribute("carrito");
double importeTotal = 0;%>
<table border="1">
<tr>
  	<th>ISBN</th><th>Autor</th><th>Precio</th><th>Titulo</th><th>Tema</th><th>Eliminar</th>
  </tr>
  
 <%if(cesta != null) {%>
  <%for(int i = 0; i<cesta.size();i++) {%>
   <tr>
  			<td><%= cesta.get(i).getIsbn()%></td>
    		<td><%= cesta.get(i).getAutor()%></td>
    		<td><%= cesta.get(i).getPrecioUnitario()%></td>
    		<td><%= cesta.get(i).getTitulo()%></td>
    		<td><%= cesta.get(i).getTema().getDescTema()%></td>
    		<th><a href="GestionCarrito?opcion=eliminar&lib=<%=i%>">Eliminar</a></th>
    	</tr>
    	<%importeTotal += cesta.get(i).getPrecioUnitario().doubleValue();%>
   <%} %>
   <%} %>
</table>
		<h2>Importe total : <%=importeTotal%></h2>
		<%session.setAttribute("precioTOTAL", importeTotal);%>
		<nav>
    	 <ul>   
    	<li><a href="GestionCarrito?opcion=detalles">Comprar</a></li>
       <li><a href="GestionCarrito?opcion=vaciar">Vaciar</a></li>
       <li><a href="GestionLibros?opcion=vertemas">Ver Temas</a></li>
       <li><a href="bienvenida.jsp">Menu</a></li>
       <li><a href="GestionCarrito?opcion=desconn">Cerrar sesion</a></li>
       	</ul>
       	</nav>
</body>
</html>