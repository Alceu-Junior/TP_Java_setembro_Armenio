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
	  <h2>Cadastro de Vaga</h2>
	  <form action="/vaga/cadastro/envio" method="post">

			<div class="form-group">
			  <label>Cargo:</label>
			  <input type="text" class="form-control" value="pedreiro"  name="cargo">
			</div>

			<div class="form-group">
			  <label>Cidade:</label>
			  <input type="text" class="form-control" value="poços de caldas" name="cidade">
			</div>

			<div class="form-group">
			  <label>Forma de Contratação:</label>
			  <input type="text" class="form-control" value="CLT" name="formaContratacao">
			</div>

		  <c:forEach begin="1" end="${quantidadeDeCriterios}">
				<h3>Criterio</h3>
			  <div class="form-group">
				  <label>Descrição:</label>
				  <input type="text" class="form-control" value="Um job" name="descricao">
			  </div>

			  <div class="form-group">
				  <label>Perfil:</label>
				  <input type="number" class="form-control" value="1" name="perfil">
			  </div>

			  <div class="form-group">
				  <label>Peso:</label>
				  <input type="number" class="form-control" value="1" name="peso">
			  </div>

		  </c:forEach>

		  <button type="submit" class="btn btn-default">Cadastrar</button>

	  </form>
	</div>

</body>
</html>