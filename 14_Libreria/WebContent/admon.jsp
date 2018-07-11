<%@page import="beans.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador</title>
</head>
<body>
<form action="GestionAdmon?opcion=temas" method="post">
    <fieldset id="temas"><legend>Añadir tema:</legend>
      <div class="personales">
        <input type="text" name="idTema" placeholder="Id Tema">
         <input type="text" name="descTema" placeholder="Descripcion">
         <input type="text" name="abreviatura" placeholder="Abreviatura">
         <input type="submit"  value="enviar">
         </div>
         <% if (request.getAttribute("menexistente") != null) { %>
         <h3><%= request.getAttribute("menexistente") %></h3>
            <% } %>
         </fieldset>
         </form>
<form action="GestionAdmon?opcion=libros" method="post">
    <fieldset id="libros"><legend>Añadir libro:</legend>
      <div class="personales">
        <input type="text" name="isbn" placeholder="ISBN">
         <input type="text" name="titulo" placeholder="Titulo">
         <input type="text" name="autor" placeholder="Autor"><br>
         <input type="text" name="precioUnitario" placeholder="Precio">
         <input type="text" name="stock" placeholder="Stock">
         <input type="text" name="idTema" placeholder="Id Tema">
         <input type="submit"  value="enviar">
         </div>
         <% if (request.getAttribute("libexistente") != null) { %>
         <h3><%= request.getAttribute("libexistente") %></h3>
            <% } %>
            <% if (request.getAttribute("temexistente") != null) { %>
         <h3><%= request.getAttribute("temexistente") %></h3>
            <% } %>
         </fieldset>
         </form>    
<form action="GestionAdmon?opcion=fechas" method="post">
<fieldset id="fechas"><legend>Buscar por fecha:</legend>
      <div class="personales">
       <input id="date" type="date" name="fechaAlta">
         <input type="submit"  value="enviar">
         </div>
         </fieldset>
         </form>     
<form action="GestionAdmon?opcion=datos" method="post">
<fieldset id="datos"><legend>Datos cliente:</legend>
      <div class="personales">
        <input type="text" name="idUsuario" placeholder="Id Usuario">
         <input type="submit" value="enviar">
         </div>
         </fieldset>
         </form> 
<form action="GestionAdmon?opcion=clientes" method="post">
<fieldset>
<%List<Usuario> cli= (List<Usuario>)session.getAttribute("clientes");%>
<table border="1">
<tr>
  	<th>ID</th><th>Pass</th><th>Nombre</th><th>Apellido</th><th>Direccion</th><th>Fecha de Alta</th><th>Tipo</th>
  </tr>
  
 <%if(cli != null) {%>
  <%for(int i = 0; i<cli.size();i++) {%>
   <tr>
  			<td><%= cli.get(i).getIdUsuario()%></td>
    		<td><%= cli.get(i).getPassword()%></td>
    		<td><%= cli.get(i).getNombre()%></td>
    		<td><%= cli.get(i).getApellido()%></td>
    		<td><%= cli.get(i).getDireccion()%></td>
    		<td><%= cli.get(i).getFechaAlta()%></td>
    		<td><%= cli.get(i).getTipoUsuario()%></td>
    		<th><a href="GestionAdmon?opcion=datos&us=<%=cli.get(i).getIdUsuario()%>">Datos</a></th>
    		<%-- <th><a href="GestionAdmon?opcion=eliminar&us=<%=i%>">Eliminar</a></th> --%>
    	</tr>
   <%} %>
   <%} %>
</table>
</fieldset>
</form>
          <a href="bienvenida.jsp">Volver menu</a>
</body>
</html>