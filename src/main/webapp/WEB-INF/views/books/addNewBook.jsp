<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add New Book</title>
</head>
<body>
	<form:form modelAttribute="book">
		<form:input type="hidden" path="book_id" id="book_id" />
		<table>
			<tr>
				<td><label for="title">Title: </label></td>
				<td><form:input path="title" id="title" /></td>
				<td><form:errors path="title" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="status">Status: </label></td>
				<td><form:input path="status" id="status" /></td>
				<td><form:errors path="status" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><c:choose>
						<c:when test="${edit}">
							<form:form action="${book.book_id}" method="PUT">
								<input type="submit" value="Edit Book" />
							</form:form>
						</c:when>
						<c:otherwise>
							<form:form action="new" method="POST">
								<input type="submit" value="Add Book" />
							</form:form>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br /> Go back to
	<a href="<c:url value='/' />">Home</a>
</body>
</html>