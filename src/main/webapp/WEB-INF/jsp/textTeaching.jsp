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
					<form>
						<div class="form-group">
							<label for="keyInput">Key</label> <input type="text"
								class="form-control" id="exampleInputEmail1"
								placeholder="Enter key identifier (only one word and in case of availability it overwrites the old value)">

						</div>
						<div class="form-group">
							<label for="valueInput">Value</label> <input type="text"
								class="form-control" id="valueInput"
								placeholder="Value (Can be any kind of text)">
						</div>
						<button type="submit" class="btn btn-primary">Add</button>
					</form>
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