<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<form action = "artistsearch" method = "GET">
         Search for artist: <input type = "text" name = "artistname">
         <br />
        
         <input type = "submit" value = "Submit" />
      </form>
	<ul>
				<c:forEach items="${ artists }" var="artist">
					<li><a href="/RecordStore/albums?artistid=${ artist.getId() }"><c:out
								value="${ artist.getName() }" /></a></li>
				</c:forEach>
			</ul>
			<form action = "" method = "POST">
				Add: <input type = "text" name = "artistname">
				<br />
				
				<input type = "submit" value = "Submit" />
			</form>


</body>
</html>