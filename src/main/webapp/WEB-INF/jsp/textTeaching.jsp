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


	<div class="modal fade" id="textTeach" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Teach me new words!</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="/addNewWord" method="POST">
					<div class="modal-body">
						<div class="form-group row">
							<label class="col-sm-2">Key:</label><input
								class="form-control form-control col-sm-10" type="text"
								name="key" value="${key}" placeHolder="One keyword (e.g Master)">
							<small class="form-text text-muted ml-2 mr-2"> If this
								key already exists it will be overwritten with the new value!</small>
						</div>
						<div class="form-group row">
							<label class="col-sm-2">Value:</label><input
								class="form-control form-control col-sm-10" value="${value}"
								type="text" name="value" placeHolder="Any value as text">
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="Add word">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script src="/js/popper.min.js"></script>
	<script src="/js/jquery-3.2.1.slim.min.js"></script>

	<script src="/js/bootstrap.min.js"></script>
</body>
</html>