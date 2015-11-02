<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>My Library</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2 class="text-center"><b>
				List of Authors
			</b></h2>
		</div>
		<table width="600">
			<tr>
		<td> <c:choose>
					<c:when test="${isEmpty}">
							<p><font size="2">List is empty !</font></p>	
						</c:when>
        		<c:otherwise>
			
			<thead>
				<tr>
					<th>Author name</th>
					<th>Country</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${authors}" var="author">
					<tr>
						<td>${author.name}</td>
						<td>${author.country}</td>
						<td><form:form action="${author.author_id}" method="GET">
								<button type="submit" class="btn btn-default">Edit
									Author</button>
							</form:form></td>
						<td><form:form action="${author.author_id}" method="DELETE">
								<button type="submit" class="btn btn-default">Delete
									Author</button>
							</form:form></td>
							<td><form:form action="${author.author_id}/books"
								method="GET">
								<button type="submit" class="btn btn-default">Show All Books</button>
							</form:form></td>	
					</tr>
				</c:forEach>
			</tbody>
			</c:otherwise>
					</c:choose></td>	
            </tr>				
		</table>
		<br /> <a href="<c:url value='/authors/new' />">Add New Author</a> <br />
		Go back to <a href="<c:url value='/' />">Home</a>
	</div>
</body>
</html>