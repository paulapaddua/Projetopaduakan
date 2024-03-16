<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<body>

	<form action="update" method="get">
		<table>

			<tr>
				<td><input id="nome" type="text" name="nome"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>

			<tr>
				<td><input id="cpf" type="text" name="cpf"
					value="<%out.print(request.getAttribute("cpf"));%>"></td>
			</tr>

			<tr>
                <td>
                        
		<input id="email" type="email" name="email"
				value="<%out.print(request.getAttribute("email"));%>">
			</td>
			</tr>


			<tr>
                <td>
                        
			<input id="celular" type="number" name="celular"
				value="<%out.print(request.getAttribute("celular"));%>">
			</td>
			</tr>

			<tr>
				<td>
                        
			<input id="adulto" type="text" name="adulto"
				value="<%out.print(request.getAttribute("adulto"));%>">
			</td>
			</tr>
			</table>
			<input class="Botao" type="submit" value="Salvar">
    </form>
</body>
</html>