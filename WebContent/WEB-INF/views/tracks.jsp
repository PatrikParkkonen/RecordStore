<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<h1>
Test
</h1>
	<c:forEach items="${ tracks }" var="track">
				<ul>
					<c:out value="${ track.getName() }" />
				</ul>
			</c:forEach>

</body>
</html>