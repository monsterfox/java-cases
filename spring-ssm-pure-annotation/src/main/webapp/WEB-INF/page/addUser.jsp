<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/23
  Time: 7:19
  To change tdis template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap5 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css">

    <!--  popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.staticfile.org/popper.js/2.9.3/umd/popper.min.js"></script>

    <!-- 最新的 Bootstrap5 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <h2>添加用户</h2>
    <form action="${pageContext.request.contextPath}/addUser" method="post">
        <table class="table">
            <tbody>
            <tr><td>姓名</td><td><input type="text" name="name" /></td></tr>
            <tr><td>年龄</td><td><input type="text" name="age" /></td></tr>
            <tr><td>余额</td><td><input type="text" name="balance" /></td></tr>
            <tr><td colspan="2"><input type="submit" value="提交" class="btn btn-primary" /></td></tr>
            </tbody>
        </table>
    </form>

</div>
</body>
</html>
