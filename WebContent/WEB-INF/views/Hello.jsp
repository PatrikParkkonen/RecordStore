<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
    <form method="get">
        Enter your name: <input type="text" name="nimi" /> <input type="submit" value="Submit" />
    </form>

    <c:if test="${ param.nimi.length() > 0 }">
        <h1>Hello <c:out value="${ param.nimi.toUpperCase() }" /></h1>
    </c:if>
    <c:if test="${ param.nimi.length() == 0 }">
        <h1>Hi anonymous!</h1>
    </c:if>
</body>
</html>