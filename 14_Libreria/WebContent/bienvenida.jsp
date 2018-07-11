<%@page import="beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOLA</title>
</head>
<body>
<%if((Usuario)session.getAttribute("usuario") == null) { %>
<small><a class="iniciarsesion" href="index.jsp">Iniciar Sesion</a></small>
<div style="clear:both"></div>
<small><a class="iniciarsesion" href="index.jsp">Administrador</a></small>
<div style="clear:both"></div>
<%} %>
<center><H1>BIENVENID@ <%if((Usuario)session.getAttribute("usuario")!=null) {%> <%=((Usuario)session.getAttribute("usuario")).getNombre().toUpperCase()%><%} %> A LA LIBRERIA MIS LIBROS </H1></center>
<center><h2>¿Que desea hacer?</h2></center>
<fieldset>
<% if (request.getAttribute("menexistente") != null) { %>
         <h3><%= request.getAttribute("menexistente") %></h3>
            <% } %>    
<% if (request.getAttribute("apagar") != null) { %>
         <h3><%= request.getAttribute("apagar") %></h3>
            <% } %>  
          
    
	<a href="GestionLibros?opcion=vertemas">Ver Temas</a><br>
	<%if((Usuario)session.getAttribute("usuario") != null) { %>
	<a href="carrito.jsp">Ver Carrito</a><br>
	<%} %>
	<%if((Usuario)session.getAttribute("usuario") != null && ((Usuario)session.getAttribute("usuario")).getTipoUsuario().equals("ADMON") ) { %>
		<a href="GestionAdmon?opcion=clientes">Menu admon</a><br>
		<%} %>
	<%if((Usuario)session.getAttribute("usuario") != null) { %>
	<a href="GestionCarrito?opcion=desconn">Cerrar sesion</a>
	<%} %>

</fieldset>
</body>
</html>
