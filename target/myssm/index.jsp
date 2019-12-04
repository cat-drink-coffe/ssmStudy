<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/users/findUsers">测试查询</a>
<hr>
<form method="post" action="${pageContext.request.contextPath}/users/insert">
    用户：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    <input type="submit" value="注册"><br>
</form>
<hr>
<form method="post" action="${pageContext.request.contextPath}/users/login">
    用户：<input type="text" name="username"><br>
    密码：<input type="text" name="password"><br>
    <input type="submit" value="登录"><br>
</form>
<hr>
</body>
</html>