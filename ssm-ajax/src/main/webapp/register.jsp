<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023/8/18
  Time: 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>原始注册方式</title>
</head>
<body>
    <form action="registerOld" method="post">
        <input type="text" id="username" name="username" />
        <span id="msg" style="color: red">${msg}</span><br>
        <input type="password" name="password" /><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
