<%@page import="beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Datos</title>
</head>
<body>
<center><h2> Estadisticas </h2></center>

<%Object[] stats = (Object[])request.getAttribute("estadisticas");%>
<table border="1">
 <tr>
  	<th>Libros totales</th><th>Temas</th><th>Total gastado</th>
  </tr>
  
 <%if(stats != null) {%>
  <tr>
  <%for(int i = 0; i<stats.length; i++) {%>
   
  			<td><%= stats[i]%></td>
  
 
   <%} %>
   </tr>
   <%} %>
</table>
		<nav>
    	 <ul>      
       <li><a href="GestionAdmon?opcion=clientes">Admon</a></li>
       <li><a href="GestionCarrito?opcion=desconn">Cerrar sesion</a></li>
       	</ul>
       	</nav>
</body>
</html>