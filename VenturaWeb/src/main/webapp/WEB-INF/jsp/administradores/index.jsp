<%@page import="br.edu.infnet.venturaWEB.model.domain.Criterio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VenturaHR</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<H1>Seja bem vindo ${usuario.getNome()}</H1>
	
	<div class="container">

		<c:if test="${not empty message}">
			<div class="alert alert-success">
				<strong>Atenção!</strong> ${message}
			</div>
		</c:if>

		<c:if test="${not empty vagas}">
		<h4>Quantidade de vagas cadastradas no sistema: ${vagas.size()}!!!</h4>

		<hr>

		<table class="table table-striped">
			<thead>
			<tr>
				<th>Id do Anunciante</th>
				<th>Id</th>
				<th>Cargo</th>
				<th>Cidade</th>
				<th>Forma de Contrato</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="v" items="${vagas}">
				<tr>
					<td>${v.idUsuario}</td>
					<td>${v.id}</td>
					<td>${v.cargo}</td>
					<td>${v.cidade}</td>
					<td>${v.formaContratacao}</td>
					<td><a href="/vaga/${v.id}/excluir">Excluir</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</c:if>

		<c:if test="${empty vagas}">
			<h4>Não existem vagas cadastrados!!!</h4>
		</c:if>
	</div>

</body>
</html>