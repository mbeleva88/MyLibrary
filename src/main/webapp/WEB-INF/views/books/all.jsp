<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Books</title>
</head>
<body>
	<h2>${author}/List of Books</h2>
	<table width="700">
		<tr>
		<td> <c:choose>
					<c:when test="${isEmpty}">
							<p><font size="2">List is empty !</font></p>	
						</c:when>
        		<c:otherwise>
		<tr>
			<td colspan="2">${name}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>Status</td>
		</tr>
		
		<c:forEach items="${books}" var="book">
		 <tr>
				<td>${book.title}</td>
				<td>${book.status}</td>
				<td>
					<form:form action="books/${book.book_id}" method="GET">
						<input type="submit" value="Edit Book" />
					</form:form>
				</td>
				<td>
					<form:form action="books/${book.book_id}" method="DELETE">
						<input type="submit" value="Delete Book" />
					</form:form>
				</td>
				<td>
					<form:form action="books/${book.book_id}/comments/new" method="GET">
						<input type="submit" value="Add New Comment" />
					</form:form>
				</td>
				<td>
					<form:form action="books/${book.book_id}/comments" method="GET">
						<input type="submit" value="Show All Comments" />
					</form:form></td></tr>
					</c:forEach>
					</c:otherwise>
					</c:choose>
						</tr> 	
	</table>
	<br />
	<a href="<c:url value='/authors/${author_id}/books/new' />">Add New Book</a>
	<br /> Go back to
	<a href="<c:url value='/' />">Home</a>
</body>
</html>