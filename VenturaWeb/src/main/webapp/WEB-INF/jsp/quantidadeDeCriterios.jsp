<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>App Times - Cadastro de Tecnico!!!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		  <h2>Quanto critérios esta vaga tem?</h2>
		  <form action="/vaga/cadastro" method="get">

			<div class="form-group">
			  <input type="number" class="form-control"  name="quantidadeDeCriterios">
			</div>

			  <button type="submit" class="btn btn-default">Próximo</button>
		  </form>
	</div>

</body>
</html>