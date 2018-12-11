<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<h1>
<c:out value="${ albumartist }" />
</h1>
	<c:forEach items="${ albums }" var="album">
				<li><a href="/RecordStore/tracks?albumid=${ album.getId() }">
					<c:out value="${ album.getTitle() }" />
					</a>
				</li>
			</c:forEach>

</body>
</html>