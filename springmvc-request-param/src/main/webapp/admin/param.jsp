<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>param.jsp</h1>
    从控制台查看请求参数是否绑定到处理器方法的参数上。
    <br>req-name:${requestScope.req-name}
    <br>model-name:${requestScope.model-name}
    <br>map-name:${requestScope.map-name}
    <br>modelMap-name:${requestScope.modelMap-name}
</body>
</html>
