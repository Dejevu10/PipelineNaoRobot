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
	<div class="container">
		<div class="container-fluid">
			<h1 class="mt-3">
				<span class="badge badge-secondary"
					style="background-color: #DCDCDC;">Thesis: Supporting
					Continuous Deployment for Cyber Physical Systems</span>
			</h1>

		</div>

		<div class="row">
			<div class="col">
				<div class="container">
					<nav class="navbar navbar-expand-lg navbar-dark mt-3"
						style="background-color: #bb1133;">
						<a class="navbar-brand" href="#" style="cursor: default;">Login</a>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarNavDropdown"
							aria-controls="navbarNavDropdown" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNavDropdown">

						</div>
					</nav>
				</div>
				<div class="container">
					<div class="jumbotron mt-3" style="background-color: #DCDCDC">
						<h1 class="display-4">Hello, I am Nao!</h1>
						<img src="/img/nao3.png" class="rounded mx-auto d-block"
							style="width: 330px; height: 400px;"
							alt="Image could not be displayed">
						<p class="lead">${connection}</p>
						<hr class="my-4">
						<form action="/start">
							<div class="form-group">
								<label for="naoIP">Nao's IP</label> <input type="text"
									name="naoIP" class="form-control" id="nao-ip"
									aria-describedby="emailHelp"
									placeholder="Enter IP (Example: 198.168.1.1)">
							</div>
							<div class="form-group">
								<label for="naoPort">Nao's Port</label> <input type="text"
									name="naoPort" class="form-control" id="nao-port"
									placeholder="Enter Port (Example: 8080)">
							</div>
							<button type="submit" class="btn btn-primary"
								style="background-color: #00e600; border-color: #00e600">Start</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	</div>



	<script src="/js/popper.min.js"></script>
	<script src="/js/jquery-3.2.1.slim.min.js"></script>

	<script src="/js/bootstrap.min.js"></script>
</body>
</html>