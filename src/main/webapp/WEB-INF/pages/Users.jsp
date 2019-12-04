<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>查询所有用户</h3>
<table border="1" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>密码</th>
        <th colspan="3">操作</th>
    </tr>
    <c:forEach var="item" items="${list}">
        <tr>
            <td>${item.id }</td>
            <td>${item.username }</td>
            <td>${item.password }</td>
            <td><a href="${pageContext.request.contextPath}/users/edit?id=${item.id}">编辑</a></td>
            <td><a href="${pageContext.request.contextPath}/users/delete?id=${item.id}">删除</a></td>
            <td><a href="${pageContext.request.contextPath}/users/findUserById?id=${item.id}">详情</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td> <a href="${pageContext.request.contextPath}/users/addgo">新增</a> </td>
    </tr>
</table>
<%--${list}--%>
</body>
</html>