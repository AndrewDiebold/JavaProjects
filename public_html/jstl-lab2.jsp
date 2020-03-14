<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>



<html>
  <head>


      <title>Lab jstl lab 2</title>
      <style>
      table, th, td {
          border: 1px solid black;
          padding: 5px;
      }

      </style>
  </head>

  <body>
      <table>
      <c:forEach var="packersQBs" items="${packersQBs}"  >
          <tr><td>${packersQBs}</td></tr>
      </c:forEach>
  </table>



      <a href="/java112">Home</a>
  </body>
</html>
