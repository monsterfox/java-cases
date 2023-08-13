<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        hr{
            margin: 50px auto;
        }
    </style>
</head>
<body>
    <h1>五种数据提交（绑定）的方式</h1>
    <form action="${pageContext.request.contextPath}/singleParam" method="post">
        <fieldset>
            <legend>1.基本数据类型</legend>
            姓名：<input type="text" name="name" /> <br />
            年龄：<input type="text" name="age" /> <br />
            <input type="submit" value="提交">
        </fieldset>
    </form>
   <br><hr>
    <form action="${pageContext.request.contextPath}/objectParam" method="post">
        <fieldset>
            <legend>2.对象类型</legend>
            姓名：<input type="text" name="name" /> <br />
            年龄：<input type="text" name="age" /> <br />
            <input type="submit" value="提交">
        </fieldset>
    </form>
    <br><hr>
    <form action="${pageContext.request.contextPath}/objectPropertyParam" method="post">
        <fieldset>
            <legend>3.对象类型（对象属性）</legend>
            姓名：<input type="text" name="name" /> <br />
            年龄：<input type="text" name="age" /> <br />
            国家：<input type="text" name="address.country" /> <br />
            城市：<input type="text" name="address.city" /> <br />
            <input type="submit" value="提交">
        </fieldset>
    </form>
    <br><hr>
    <a href="${pageContext.request.contextPath}/pathParam/中国/22" >4.动态占位符/路径变量提交数据（只限于超链接）</a>
    <br><hr>
    <h3>5.请求参数名称与形参名称不一致</h3>
    &nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/reqParam?myname=马斯克" >5-1.请求参数名称与形参名称不一致-GET</a>
    <br><br>
    <form action="reqParam" method="post">
        <fieldset>
            <legend>5-2.请求参数名称与形参名称不一致-POST</legend>
            姓名：
            <input type="text" name="myname" />
            <input type="submit" value="提交">
        </fieldset>
    </form>

    <br><hr>
    <h3>6.请求参数名称与形参名称不一致</h3>
    &nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/servletParam?name=马斯克" >6-1.使用HttpServletRequest对象提取-GET</a>
    <br><br>
    <form action="servletParam" method="post">
        <fieldset>
            <legend>6-2.使用HttpServletRequest对象提取-POST</legend>
            姓名：
            <input type="text" name="name" />
            <input type="submit" value="提交">
        </fieldset>
    </form>
    <hr>

    <%--可以用POSTMAN发送JSON
        http://localhost:8080/jsonParam
        {'name':'张三','age':'24'}
    --%>
    <a href="${pageContext.request.contextPath}/jsonParam" >7.发送JSON数据</a>

    <br><hr>
    <form action="arrayParam" method="post">
        <fieldset>
            <legend>8.数组类型</legend>
            爱好：
            <input type="checkbox" name="hobby" value="篮球" />篮球
            <input type="checkbox" name="hobby" value="足球" />足球
            <input type="checkbox" name="hobby" value="排球" />排球
            <input type="checkbox" name="hobby" value="铅球" />铅球
            <input type="submit" value="提交">
        </fieldset>
    </form>

</body>
</html>
