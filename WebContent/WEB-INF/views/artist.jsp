<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<form action = "artistsearch" method = "GET">
         Name: <input type = "text" name = "artistname">
         <br />
        
         <input type = "submit" value = "Submit" />
      </form>
	<ul>
				<c:forEach items="${ artists }" var="artist">
					<li><a href="/RecordStore/albums?artistid=${ artist.getId() }"><c:out
								value="${ artist.getName() }" /></a></li>
				</c:forEach>
			</ul>


</body>
</html>