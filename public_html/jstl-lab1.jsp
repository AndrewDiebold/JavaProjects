<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>



<html>
  <head>


      <title>Lab jstl lab 1</title>
  </head>

  <body>

      <c:set var="goPack" value="aaronRodgers" scope="session" />

      <c:out value="${goPack}" />


      <p><a href="/java112">Home</a></p>
  </body>
</html>
