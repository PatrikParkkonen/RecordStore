<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<h1>
<c:out value="${ track.getComposer() }" />
</h1><table style="border-collapse: separate; border-spacing: 10px;" >
<tr>
<th>ID</th>
<th>Name</th>
<th>Genre</th>
<th>Length</th>
</tr>
	<c:forEach items="${ tracks }" var="track">
				<tr>
					<td>${ track.getId() }</td>
					<td>${ track.getName() }</td>
					<td>${ track.getGenreName() }</td>
					<td>${ track.getMilliseconds() }</td>
				
				</tr>
			</c:forEach>
			</table>

</body>
</html>