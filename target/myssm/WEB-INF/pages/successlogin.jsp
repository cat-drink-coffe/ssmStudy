<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>图片上传</h2>
<form action="/users/saveImg" method="post" enctype="multipart/form-data">
    图片:<input type="file" name="upload"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>