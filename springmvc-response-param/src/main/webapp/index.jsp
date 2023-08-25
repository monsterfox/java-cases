<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
      $(document).ready(function(){
        $("button").click(function(){
          $.ajax({
            url:"returnVoid",
            type: "POST",
            data:{
              name:"张三",
              age:18
            },
            success:function (data){
              var jsonobject = JSON.parse(data);
              alert("用户名:" + jsonobject.name + "年龄："+jsonobject.age);
            }
          })
        });
      });
    </script>

    　　<script type="text/javascript">
    function showUser() {
      //使用jQuery封装的ajax()发送ajax请求
      $.ajax({
        url:"${pageContext.request.contextPath}/list",
        type:"get",
        dataType:"json",
        success:function (userList){
          var data = ""
          $.each(userList, function (i, user){
            data += user.name + " ---- " + user.age + "<br>"
          })
          //将拼接好的数据回显在div中
          $("#userDiv").html(data)
        }
      })
    }
  </script>
  </head>
  <body>
    <h1>控制器方法的返回值类型（服务端到客户端的参数传递）</h1>
    <a href="modelAndView?name=tom&pwd=123">1.modelAndView</a>
    <br><br>
    <a href="string?name=tom&pwd=123">2.String</a>
    <br><br>
    <div id="div1"><h2>使用 jQuery AJAX 获取服务端数据</h2></div>
    <button>3.void</button>


    <br><br><br>
    <a href="javascript:showUser()">4.object-发送ajax请求，获取用户信息列表</a><br>

    <div id="userDiv">div，用来显示服务器返回的数据</div>

  <hr />


  </body>
</html>
