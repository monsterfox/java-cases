<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/17
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>登录</h1>
    <form action="${pageContext.request.contextPath}/login" method="post">
        账号：<input type="text" name="username" /><br>
        密码：<input type="password" name="password" /><br>
        <input type="submit" value="提交">
    </form>
    ${msg}
</body>
</html>
