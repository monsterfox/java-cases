<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/3/22
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>用户列表</title>
    <!-- 新 Bootstrap5 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css">

    <!--  popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.staticfile.org/popper.js/2.9.3/umd/popper.min.js"></script>

    <!-- 最新的 Bootstrap5 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <h2>用户列表</h2>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toAddUser">添加用户</a>
    <table class="table">
        <thead class="table-dark">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>余额</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.balance}</td>
                <td>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/toModifyUser/${user.id}">修改</a>
                    <a class="btn btn-danger" onclick="return confirm('确认删除吗?');" href="${pageContext.request.contextPath}/deleteUser/${user.id}">删除</a>
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/toTransfer/${user.id}">转账</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
