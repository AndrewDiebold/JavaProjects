<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
<h2>Add New Employee</h2>

<h3 id="project4message">${project4message}<h3>
<c:remove var="project4message"/>
<br />
<form action="/java112/employeeAddAction" method="post">
    <label>First Name</label> <input type="text" name="firstName"/><br /><br />
    <label>Last Name</label> <input type="text" name="lastName"/> <br /><br />
    <label>Social Security Number</label> <input type="text" name="socialSecurityNumber"/> <br /><br />
    <label>Department</label> <input type="text" name="department"/> <br /><br />
    <label>Room Number</label> <input type="text" name="roomNumber"/> <br /><br />
    <label>Phone Number</label> <input type="text" name="phoneNumber"/> <br /><br />
    <input type="submit" name="" value="Submit" />
</form>


</div>
