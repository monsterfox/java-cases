<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023/8/2
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/search" method="post">
            姓名：<input type="text" name="name">
            年龄：<input type="text"  name="age">
            余额：<input type="text" name="balance">
            <input type="submit" value="提交" />
</form>
</body>
</html>
