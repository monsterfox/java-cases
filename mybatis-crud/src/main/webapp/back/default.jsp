<%@page import="com.foxbill.dao.FoodMapper" %>
<%@page import="com.foxbill.pojo.Food" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.foxbill.util.MyBatisUtil" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>菜品管理</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        .table img {
            width: 180px;
            height: 225px;
        }
        thead tr th{
            background-color: lightgoldenrodyellow;
            font-size: 16px !important;
            text-align: center !important;
        }
        tbody tr td{
            line-height: 225px !important;
            text-align: center !important;
        }
    </style>
</head>
<body data-spy="scroll" data-target="#myScrollspy">

<%
    SqlSession sqlSession = MyBatisUtil.getSqlSession();
    FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
    List<Food> foodList = foodMapper.getAllFood();
%>
<div class="container-fluid">
    <%@include file="head.jsp"%>
    <div class="container ">

        <div class="row" style="margin-bottom: 20px;">
            <div class="col-xs-2 col-xs-offset-10">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/back/addFood.jsp">添加菜品</a>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <table class="table table-borderd table-hover">
                    <thead>
                    <tr>
                        <th>菜品编号</th>
                        <%--<th>类别编号</th>--%>
                        <th>菜品名称</th>
                        <th>菜品单价</th>
                        <th>菜品销量</th>
                        <th>菜品图片</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (int i = 0; i < foodList.size(); i++) {
                            Food f = foodList.get(i);
                    %>
                    <tr>
                        <td><%=f.getFid() %>
                        </td>
<%--                        <td><%=f.getCid() %>
                        </td>--%>
                        <td><%=f.getFname() %>
                        </td>
                        <td><%=f.getFprice() %>
                        </td>
                        <td><%=f.getFsellCount() %>
                        </td>
                        <td align="center"><img class="img-thumbnail"
                                                src="${pageContext.request.contextPath}/foodImg/<%=f.getFimage() %>"/>
                        </td>
                        <td><a href="${pageContext.request.contextPath}/service?action=toUpdateFood&fid=<%=f.getFid() %>" class="btn btn-info">修改</a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/service?action=deleteFood&fid=<%=f.getFid() %>" onclick="return confirm('确认删除该菜品吗？');" class="btn btn-danger">删除</a></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>