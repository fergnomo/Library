<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Direcciones</title>
</head>
<body>
<form action="GestionCliente?opcion=altaDireccion" method="post">
    <fieldset id="temas"><legend>Añadir tema:</legend>
      <div class="personales">
        <input type="text" name="calle" placeholder="Calle">
         <input type="text" name="distrito" placeholder="Distrito">
         <input type="submit"  value="enviar">
         </div>
         <% if (request.getAttribute("menexistente") != null) { %>
         <h3><%= request.getAttribute("menexistente") %></h3>
            <% } %>
         </fieldset>
         </form>
                   <a href="bienvenida.jsp">Volver menu</a>
         
</body>
</html>