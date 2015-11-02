<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Add new author</title>
</head>
<body>
	<div class="container">
		<form:form modelAttribute="author" role="form">
			<form:input type="hidden" path="author_id" id="author_id" />
			<div class="form-group">
				<label for="name">Name: </label>
				<form:input path="name" id="name" />
				<form:errors path="name" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="country">Country: </label>
				<form:input path="country" id="country" />
				<form:errors path="country" cssClass="error" />
			</div>
			<c:choose>
				<c:when test="${edit}">
					<form:form action="/authors/${author.author_id}" method="PUT">
						<button type="submit" class="btn btn-default">Edit Author</button>
					</form:form>
				</c:when>
				<c:otherwise>
					<form:form action="/authors/new" method="GET">
						<button type="submit" class="btn btn-default">Add Author</button>
					</form:form>
				</c:otherwise>
			</c:choose>
		</form:form>
		<br /> <br /> Go back to <a href="<c:url value='/' />">Home</a>
	</div>
</body>
</html>