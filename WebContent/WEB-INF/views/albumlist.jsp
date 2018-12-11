<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<c:forEach items="${ albums }" var="album">
				<ul>
					<c:out value="${ album.getTitle() }" />
				</ul>
			</c:forEach>

</body>
</html>