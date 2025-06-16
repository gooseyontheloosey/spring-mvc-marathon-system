<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<h1> Marathons - RAW DATA </h1>
<c:forEach var="marathon" items="${marathons}">
    <h2> Marathon <c:out value="${marathon.getId()}"/> </h2>
    <p> <c:out value="${marathon.toString()}"/> </p>
</c:forEach>
</body>
</html>