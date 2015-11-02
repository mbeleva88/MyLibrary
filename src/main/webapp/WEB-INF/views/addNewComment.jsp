<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add New Comment</title>
</head>
<body>
	<form:form modelAttribute="comments">
		<form:input type="hidden" path="comment_id" id="comment_id" />
		<table>
			<tr>
				<td><label for="comment">Comment: </label></td>
				<td><form:input path="comment" id="comment" /></td>
				<td><form:errors path="comment" cssClass="error" /></td>
			</tr>
			<tr>
					<td colspan="3"><c:choose>
						<c:when test="${edit}">
							<form:form action="comment/${comment.comment_id}" method="PUT">
								<input type="submit" value="Edit Comment" />
							</form:form>
						</c:when>
						<c:otherwise>
							<form:form action="comment/new" method="POST">
								<input type="submit" value="Add Comment" />
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