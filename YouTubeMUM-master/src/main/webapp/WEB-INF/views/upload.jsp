<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
<h1>${headerMessage}</h1>

<h1>Video Upload</h1>
<form:form method="post" action="upload" enctype="multipart/form-data" modelAttribute = "upload">
    <input type="file" name="file" /><br />
    <table>
        <tr>
            <td><form:label path="userId">User Id</form:label></td>
            <td><form:input path="userId"/></td>
        </tr>
        <tr>
            <td><form:label path="videoDescription">Video Description</form:label></td>
            <td><form:input path="videoDescription"/></td>
        </tr>

    </table>
    <br /> <input type="submit" value="Upload" />
</form:form>

</body>
</html>




