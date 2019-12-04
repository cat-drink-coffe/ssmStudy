<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>用户详情</h3>
<table border="1" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>密码</th>
    </tr>
    <tr>
        <td>${user.id }</td>
        <td>${user.username }</td>
        <td>${user.password }</td>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/users/findUsers">返回</a>
<%--${list}--%>
</body>
</html>