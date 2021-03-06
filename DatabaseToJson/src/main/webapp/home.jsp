<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="index.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<div class="container-sm">

		<form action="entry" method="post">
			<div class="input-group mb-3">
				<input type="text" class="form-control" placeholder="Name"
					aria-label="Name" aria-describedby="name-id" name="name">
			</div>
			<div class="input-group mb-3">
				<input type="text" class="form-control" placeholder="Age"
					aria-label="Age" aria-describedby="age-id" name="age">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<br>
		<button type="button" class="btn btn-success" id="values-btn">Get
			Values</button>
		<br>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Age</th>

				</tr>
			</thead>
			<tbody id="display">
			</tbody>
		</table>
	</div>
	<script type="text/javascript" src="script.js"></script>
</body>
</html>