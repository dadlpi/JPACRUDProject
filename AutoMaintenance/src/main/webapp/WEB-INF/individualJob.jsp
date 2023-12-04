<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auto Maintenance Individual Job</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<div class="container">
<a href="home.do">Return Home</a>

<h1>Job Details</h1>
<h5>Database ID #${individualJob.id}</h5>
<h5>Name of Job: ${individualJob.nameOfJob}</h5>
<h5>Interval Between Job: ${individualJob.intervalBetweenJob}</h5>
<h5>Creator: ${individualJob.creatorId}</h5>
<h5>Create Date: ${individualJob.createDate}</h5>
<h5>Modifier: ${individualJob.modifierId}</h5>
<h5>Modify Date: ${individualJob.modifyDate}</h5>
<h5>Active Indicator: ${individualJob.activeInd}</h5>
<blockquote>Job Description: ${individualJob.description}</blockquote>
<hr>

<form action="updateForm.do?theJobId=${individualJob.id}" method="POST">
    <input type="submit" value="Update Job" />
  </form>
  <br>
<form action="deleteJob.do?jobId=${individualJob.id}" method="POST">
    <input type="submit" value="Delete Job" />
  </form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</div> 

</body>
</html>