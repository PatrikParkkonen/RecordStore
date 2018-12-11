<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<c:choose>
		<c:when test="${ artist.getName() != null }">

			<h1>
				<c:out value="${ artist.getName() }"></c:out>
			</h1>
			<jsp:include page="albumlist.jsp">
			<jsp:param value="${ albums }" name="albums" />
			</jsp:include>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${ artists }" var="artist">
					<li><a href="/RecordStore/artists?id=${ artist.getId() }"><c:out
								value="${ artist.getName() }" /></a></li>
				</c:forEach>
			</ul>
		</c:otherwise>

	</c:choose>



</body>
</html>