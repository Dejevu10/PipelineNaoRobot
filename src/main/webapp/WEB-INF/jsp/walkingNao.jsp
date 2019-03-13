<!DOCTYPE HTML>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Nao moves</title>


<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/individualCss.css">

</head>
<body>

	<%@include file="header.jsp"%>
	<div class="container">
		<div class="container mt-3 mb-3 align-middle"
			style="min-height: 700px">
			<div class="row" style="height: 100px; margin-top: 90px">
				<div class="col "></div>
				<div class="col">
					<a href="/letNaoWalkF" role="button"
						class="btn w-100 h-100 btn-light"><img style="height: 100px"
						src="/img/robot-forward.png" alt="F"></a>
				</div>
				<div class="col "></div>
			</div>
			<div class="row" style="height: 100px; margin: 25px 0 25px 0">
				<div class="col">
					<a href="/letNaoWalkL" role="button" class="btn w-100 h-100 btn-light"><img
						style="height: 100px" src="/img/robot-left.png" alt="L"></a>
				</div>
				<div class="col ">
					<a href="/letNaoTurnRight" role="button" class="zoom btn w-100 h-100 btn-light"><img
						style="height: 100px;" src="/img/robot-turn.jpg" alt="Turn-Right"></a>
				</div>
				<div class="col ">
					<a href="/letNaoWalkR" role="button" class="btn w-100 h-100 btn-light"><img
						style="height: 100px" src="/img/robot-right.png" alt="R"></a>
				</div>
			</div>
			<div class="row" style="height: 100px">
				<div class="col "></div>
				<div class="col ">
					<a href="/letNaoWalkB" role="button" class="btn btn-light w-100 h-100"><img
						style="height: 100px" src="/img/robot-backward.png" alt="B"></a>
				</div>
				<div class="col "></div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>




	<script src="/js/popper.min.js"></script>
	<script src="/js/jquery-3.2.1.slim.min.js"></script>

	<script src="/js/bootstrap.min.js"></script>
</body>
</html>