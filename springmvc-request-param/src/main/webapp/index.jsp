<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/13
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>五种数据提交（绑定）的方式</h1>
    <form action="${pageContext.request.contextPath}/basicParam" method="post">
        <fieldset>
            <legend>1.单个数据提交</legend>
            姓名：<input type="text" name="name" /> <br />
            年龄：<input type="text" name="age" /> <br />
            <input type="submit" value="提交">
        </fieldset>
    </form>
   <br><hr>
    <form action="${pageContext.request.contextPath}/objectParam" method="post">
        <fieldset>
            <legend>2.对象数据提交</legend>
            姓名：<input type="text" name="name" /> <br />
            年龄：<input type="text" name="age" /> <br />
            <input type="submit" value="提交">
        </fieldset>
    </form>
    <br><hr>
    <a href="${pageContext.request.contextPath}/pathParam/中国/22" >3.动态占位符提交数据（只限于超链接）</a>
    <br><hr>
    <a href="${pageContext.request.contextPath}/reqParam?myname=马斯克" >4.请求参数名称与形参名称不一致</a>
    <br><hr>
    <a href="${pageContext.request.contextPath}/servletParam?name=马斯克" >5.使用HttpServletRequest对象提取</a>
    <br><hr>
    <%--可以用POSTMAN发送JSON
        http://localhost:8080/jsonParam
        {'name':'张三','age':'24'}
    --%>
    <a href="${pageContext.request.contextPath}/jsonParam" >6.发送JSON数据</a>
    <hr>
    <h1>从Web后端携带数据到Web前端</h1>
    <form action="${pageContext.request.contextPath}/showParam" method="post">
        <fieldset>
            <legend>1.携带数据</legend>
            姓名：<input type="text" name="name" /> <br />
            年龄：<input type="text" name="age" /> <br />
            <input type="submit" value="提交">
        </fieldset>
    </form>
</body>
</html>
