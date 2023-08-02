<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="username"> <br>
    头像：<input type="file" name="picFile"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
