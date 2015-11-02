<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>List of Comments</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
        }
    </style>
 
</head>
<body>
    <h2>${author}/${book}/List of Comments</h2>  
    <table width="400">
        	   <tr>
        	   <td><c:choose>
					<c:when test="${isEmpty}">
							<p><font size="2">List is empty !</font></p>	
						</c:when>
        		<c:otherwise>
        		<tr>
            <td>Comment</td>
        	</tr>
				<c:forEach items="${comments}" var="comment">
				<tr>
            <td>${comment.comment}</td>	
						<td><form:form action="comments/${comment.comment_id}" method="GET">
						<input type="submit" value="Edit Comment" />
					</form:form></td>
					<td><form:form action="comments/${comment.comment_id}" method="DELETE">
						<input type="submit" value="Delete Comment" />
					</form:form></td>
					</tr></c:forEach>
						</c:otherwise>
					</c:choose></td>
            </tr>
        
    </table>
    <br/>
    <a href="<c:url value='../${book_id}/comments/new' />">Add New Comment</a>
    <br /> Go back to
	<a href="<c:url value='../${author_id}' />">Books</a>
</body>
</html>