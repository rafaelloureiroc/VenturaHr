<%@page import="br.edu.infnet.VenturaHr.*"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.infnet.VenturaHr.model.Usuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<title>VenturaHr</title>
</head>
<body>
	<%
	Usuario usuario = (Usuario)request.getAttribute("user"); 
	List<Usuario> usuarios = (List<Usuario>)request.getAttribute("ListaUsuario");
	int qtde = usuarios != null? usuarios.size() : 0;
	
	%>
	 
	<div class="container">	
		<h4>Realize o cadastramento de usuarios:</h4>

		<form action="usuario" method="get">
			<button type="submit">Novo usuario</button>
		</form>

	  	<%if(qtde > 0){%>
		  	<p>Quantidade de usuario cadastrados: <%=qtde%></p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			      </tr>
			    </thead>
			    <tbody>
				<%for(Usuario u: usuarios) {%>
			      <tr>
			        <td><%=u.getNome()%></td>
			        <td><%=u.getEmail()%></td>
				<%}%>
			    </tbody>
			    <tfoot>
			    </tfoot>
		  	</table>
	  	<%} else {%>
	  		<p>Não há usuarios</p>            
	  	<%}%>
	</div>
</body>
</html>