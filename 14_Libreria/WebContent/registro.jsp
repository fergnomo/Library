<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro</title>
</head>
<body>
<form action="Login?opcion=registrar" method="post">
    <fieldset id="datos-personales"><legend>Registro:</legend>
      <div class="personales">
        <input type="text" name="idUsuario" placeholder="Id Usuario"><br>
         <input type="text" name="password" placeholder="Contraseña"><br>
         <input type="text" name="nombre" placeholder="Nombre"><br>
         <input type="text" name="apellido" placeholder="Apellido"><br>
         <input type="text" name="direccion" placeholder="Direccion"><br>
         <input type="submit" name="enviar" value="validar">         
         </div>
         </fieldset>
         </form>
          
       <a href="bienvenida.jsp">Volver inicio</a>
       <% if (request.getAttribute("menexistente") != null) { %>
         <h3><%= request.getAttribute("menexistente") %></h3>
            <% } %>
</body>
</html>