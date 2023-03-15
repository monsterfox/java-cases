<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/15
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>日期数据提交（绑定）的方式</h1>
    <div>日期类型不能自动注入到方法的参数中。需要单独做转换处理。使用@DateTimeFormat注解，需要在springmvc.xml文件中添加&lt;mvc:annotation-driven/&gt;标签。</div>

    <h2>单个日期处理-@DateTimeFormat</h2>
    <a href="${pageContext.request.contextPath}/testDate?date=2021-02-08" >发送日期数据1</a>
    <br><hr>
    <form action="${pageContext.request.contextPath}/testDate2" method="post">
        <fieldset>
            <legend>对象数据提交-绑定日期类型属性</legend>
            姓名：<input type="text" name="name" /> <br />
            出生日期：<input type="date" name="birthday" /> <br />
            <input type="submit" value="提交">
        </fieldset>
    </form>
    <br><br><hr>
    <h2>全局日期处理-@InitBinder</h2>
    <a href="${pageContext.request.contextPath}/testDate3?date=2021-02-08" >发送日期数据2</a>
</body>
</html>
