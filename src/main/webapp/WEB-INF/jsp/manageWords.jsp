<!DOCTYPE HTML>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Entrypage for NaoRobot</title>


<link rel="stylesheet" href="/css/bootstrap.min.css">

</head>
<body>

	<%@include file="header.jsp"%>
	<div class="container">
		<div class="container mt-3 mb-3" style="min-height: 700px">
			<div class="row">
				<div class="col">

					<table class="table table-striped shadow">
						<thead>
							<tr style="background-color: #DCDCDC;">
								<th scope="col">#</th>
								<th scope="col">Key</th>
								<th scope="col">Value</th>
								<th scope="col">Manage</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${wordMemory.words}" var="word"
								varStatus="status">
								<!--<tr>
								<form action="/robotSaySomething" method="POST">
									<th scope="row">1</th>
									<td name="key">Master</td>
									<td><input type="hidden" name="value"
										value="Murat Ugur Selcuk">Murat Ugur Selcuk </input></td>
									<td><input name="BUmaster" type="submit"
										value="let me say it!"></input></td>
								</form>
							</tr>
							<tr>
								<form action="/robotSaySomething" method="POST">
									<th scope="row">2</th>
									<td name="key">Owner</td>
									<td><input type="hidden" name="value"
										value="Chair of Software Engineering University of Mannheim">Chair of Software Engineering University of Mannheim</input></td>
									<td><input name="BUmaster" type="submit"
										value="let me say it!"></input></td>
								</form>
							</tr>-->
								<tr>

									<form action="/robotSaySomething" method="POST">
										<th scope="row">${status.index+1}</th>
										<td><input type="hidden" name="key" value="${word.key}"></input>${word.key}</td>
										<td><input type="hidden" name="value"
											value="${word.value}">${word.value}</input></td>
										<td><input class="btn btn-primary" name="speak"
											type="submit" value="speak"></input><input name="remove"
											class="btn btn-secondary" type="submit" value="remove"></input></td>
									</form>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>




	<script src="/js/popper.min.js"></script>
	<script src="/js/jquery-3.2.1.slim.min.js"></script>

	<script src="/js/bootstrap.min.js"></script>
</body>
</html>