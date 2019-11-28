<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>查询所有用户</h3>

<c:forEach var="item" items="${list}">
    <tr>
        <td id="${item.id }" style="width: 10px;">${item.id }</td>
        <td id="${item.username }" style="width: 30px;">${item.username }</td>
        <td id="${item.PASSWORD }" style="width: 100px;">${item.PASSWORD }</td>
    </tr></br>
</c:forEach>

<%--${list}--%>
</body>
</html>