<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auto Maintenance Job Lister</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<div class="container">
<form action="CreateJob.do" method="GET">
    Job Name:
    <input type="text" name="name"/> 
    Interval
    <input type="number" name="interval"/> 
    <input class="btn btn-success" type="submit" value="Create Job" />
  </form>

<hr>

<h1>Auto Maintenance Jobs List</h1>



<!--  <a href="GetIndividualJob.do?jobId=${individualAutoJob.id}">${individualAutoJob.nameOfJob}</a>
${individualFilm.releaseYear}-->
<table class="table">
				<thead>
					<tr>
						<th>Job ID</th>
						<th>Name of Job</th>
						<th>Interval Between Job</th>
						<th>Creator</th>
						<th>Create Date</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach var="individualAutoJob" items="${autoJobList}">
					<tr>
							<td>${individualAutoJob.id}</td>
							<td><a href="GetIndividualJob.do?jobId=${individualAutoJob.id}">${individualAutoJob.nameOfJob}</a></td>
							<td>${individualAutoJob.intervalBetweenJob}</td>
							<td>${individualAutoJob.creatorId}</td>
							<td>${individualAutoJob.createDate}</td>
					</tr>
				</c:forEach>
				</tbody>
</table>				
				

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</div> 

</body>
</html>