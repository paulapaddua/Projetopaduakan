<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Cliente"%>
<%@ page import="controller.Controlador"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="tabela.css">
</head>
<body>

	<%
	ArrayList<Cliente> Lista = (ArrayList<Cliente>) request.getAttribute("clientes");
	System.out.println(Lista);
	%>

	<h1>Agenda de Contatos</h1>

	<a href="index.html" class="Botao">Início</a>

	<table id="tabela">
		<thead>
			<tr>
				<th>Nome</th>
				<th>cpf</th>
				<th>Email</th>
				<th>Celular</th>
				<th>Adulto</th>
				<th>Opção</th>
			</tr>
		</thead>

		<tbody>
			<%
			for (int i = 0; i < Lista.size(); i++) {
			%>
			<tr>
				<td><%=Lista.get(i).getNome()%></td>
				<td><%=Lista.get(i).getCpf()%></td>
				<td><%=Lista.get(i).getEmail()%></td>
				<td><%=Lista.get(i).getCelular()%></td>
				<td><%=Lista.get(i).getAdulto()%></td>
				<td><a href="select?idcon=<%=Lista.get(i).getIdcon()%>"
					class="Botao">Editar</a> <a
					href="delete?idcon=<%=Lista.get(i).getIdcon()%>" class="Botao">Apagar</a>
				</td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
</body>
</html>