<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<h1>
Test
</h1><table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Composer</th>
<th>Length</th>
</tr>
	<c:forEach items="${ tracks }" var="track">
				<tr>
					<td>${ track.getId() }</td>
					<td>${ track.getName() }</td>
					<td>${ track.getComposer() }</td>
					<td>${ track.getMilliseconds() }</td>
				
				</tr>
			</c:forEach>
			</table>

</body>
</html>