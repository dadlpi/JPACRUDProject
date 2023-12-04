<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auto Maintenance Update Individual Job</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<div class="container">
<a href="home.do">Return Home</a>

<h1>Update Individual Job</h1>
<h5>Database ID #${individualJob.id}</h5>
<h5>Name of Job: ${individualJob.nameOfJob}</h5>

<form action="update.do?jobId=${individualJob.id}" method="POST">
    Active Indicator:
    <input type="radio" name="radioValue" value="Y" checked="checked" />Active
    <input type="radio" name="radioValue" value="N" />Inactive
    <br>
    Update Description of the Job with a new Entry: <br>
    	<textarea rows = "5" cols = "50" name = "description"></textarea>
    <input type="submit" value="Update Job" />
  </form>

<hr>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</div> 

</body>
</html>