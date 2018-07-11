<%@page import="beans.Usuario"%>
<%@page import="beans.Tema"%>
<%@page import="java.util.List"%>
<%@page import="dao.TemasDAOImpls"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Temas</title>
</head>
<body>
<%if((Usuario)session.getAttribute("usuario") == null) { %>
<small><a class="iniciarsesion" href="index.jsp">Iniciar Sesion</a></small>
<div style="clear:both"></div>
<small><a class="iniciarsesion" href="index.jsp">Administrador</a></small>
<div style="clear:both"></div>
<%} %>
<%List<Tema> mistemas = (List<Tema>)request.getAttribute("temas");%>
<h1>Listado de temas . . . elige uno</h1>
<form action="GestionLibros?opcion=verlibros" method="post">
	<fieldset><legend>Elegir un tema</legend>
	<%for (Tema ele: mistemas) {%>
	<div>
		<input type = "radio" name="idTema" value="<%=ele.getIdTema()%>"> <%=ele.getDescTema()%>
	</div>
	<%} %>
	 
</fieldset>	
<input type="submit"  value="enviar"> <br><br>
</form>
<% if (request.getAttribute("menexistente") != null) { %>
         <h3><%= request.getAttribute("menexistente") %></h3>
            <% } %>           
<a href="carrito.jsp">Ver Carrito</a><br>
<a href="bienvenida.jsp">Menu</a><br>
<a href="GestionCarrito?opcion=desconn">Cerrar sesion</a>
</body>
</html>