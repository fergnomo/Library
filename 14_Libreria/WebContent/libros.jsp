<%@page import="beans.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LIBRINHOS</title>
</head>
<body>
<%if((Usuario)session.getAttribute("usuario") == null) { %>
<small><a class="iniciarsesion" href="index.jsp">Iniciar Sesion</a></small>
<div style="clear:both"></div>
<small><a class="iniciarsesion" href="index.jsp">Administrador</a></small>
<div style="clear:both"></div>
<%} %>
	<%List<Libro> lista = (List<Libro>)request.getAttribute("libros"); %>
	<h1>Lista de libros . . . elige los que quieras agregar al carrito</h1>
	<% if(lista == null || lista.isEmpty()){
		lista = new ArrayList<Libro>();
	}%>
	<form action="GestionCarrito?opcion=add" method="post">
	<fieldset><legend>Elegir libros</legend>
	<%for(Libro ele: lista) {%>
		<div>
		 <input type="checkbox" name="isbn" value="<%=ele.getIsbn()%>"> <%=ele.getTitulo()%>
		</div>
	<%} %>
	</fieldset>
	 <input type="submit"  value="enviar"><br><br>
	</form>
	<a href="carrito.jsp">Ver carrito</a><br>
	<a href="bienvenida.jsp">Menu</a><br>
<a href="GestionCarrito?opcion=desconn">Cerrar sesion</a>
</body>
</html>