
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Sửa thông tin</title>
</head>
<body>
<form:form method="post" enctype="multipart/form-data" modelAttribute="student">
    <table>
        <tr>
            <td>Avatar</td>
            <td><form:input path="avatar" type="file"/></td>
        </tr>
        <tr>
            <td>Student Name</td>
            <td><form:input path="studentName"/></td>
        </tr>

        <tr>
            <td>Address</td>
            <td><form:input path="address"/></td>
        </tr>

        <tr>
            <td>Birthday</td>
            <td><form:input path="birthday" type="date"/></td>
        </tr>

        <tr>
            <td>Phone Number</td>
            <td><form:input path="phoneNumber"/></td>
        </tr>

        <tr>
            <td>Sex</td>
            <td><form:input path="sex"/></td>
        </tr>

    </table>
    <button>Save</button>
</form:form>

</body>
</html>
