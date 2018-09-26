<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
<form action="Login?opcion=validar" method="post">
    <fieldset id="datos-personales"><legend>Iniciar Sesion:</legend>
      <div class="personales">
        <input type="text" name="idUsuario" placeholder="Usuario">
         <input type="password" name="password" placeholder="Password">
         <input type="submit"  value="enviar">
         </div>
         </fieldset>
         </form>
          <% if (request.getAttribute("menexistente") != null) { %>
         <h3><%= request.getAttribute("menexistente") %></h3>
            <% } %>
       <a href="registro.jsp">Registrate</a>	
       	
</body>
</html>