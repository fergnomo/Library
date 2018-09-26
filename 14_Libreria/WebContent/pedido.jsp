<%@page import="beans.Pedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedidos</title>
</head>
<body>
<%List<Pedido> mispedidos = (List<Pedido>)request.getAttribute("pedidos");%>
<h1> . . Listado de pedidos . . </h1>
<form action="GestionAdmon?opcion=fechas" method="post">
	<fieldset><legend>Pedidos</legend>
	<%for (Pedido ele: mispedidos) {%>
	<div>
		<p><%=ele%>"</p>
	</div>
	<%} %>
	 
</fieldset>	
<a href="admon.jsp">Volver admon</a> 
</form>
</body>
</html>