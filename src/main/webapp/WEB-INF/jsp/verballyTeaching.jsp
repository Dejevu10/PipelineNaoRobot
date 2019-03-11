<!DOCTYPE HTML>
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
					<div class="card-deck">
						<button type="button" class="btn m-2">
							<div class="card shadow"
								style="width: 18rem; background-color: #DCDCDC">

								<img src="/img/nao4.png" class="card-img-top"
									alt="Image is not available">
								<div class="card-body">
									<p class="card-text">Teach me something verbally</p>
								</div>
							</div>
						</button>

						<button type="button" class="btn m-2">
							<div class="card shadow"
								style="width: 18rem; background-color: #DCDCDC">

								<img src="/img/nao4.png" class="card-img-top"
									alt="Image is not available">
								<div class="card-body">
									<p class="card-text">Teach me something with text</p>
								</div>
							</div>
						</button>

						<button type="button" class="btn m-2">
							<div class="card shadow"
								style="width: 18rem; background-color: #DCDCDC">

								<img src="/img/nao4.png" class="card-img-top"
									alt="Image is not available">
								<div class="card-body">
									<p class="card-text">Let me walk!</p>
								</div>
							</div>
						</button>

					</div>
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