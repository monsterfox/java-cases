<%@page import="com.foxbill.dao.FoodMapper" %>
<%@page import="com.foxbill.pojo.Food" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改菜品</title>
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
		thead tr td{
			text-align: center !important;
		}
		#preview{width:180px;height:225px;border:1px solid #000;overflow:hidden;}
		#imghead {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);}
	</style>

	<script type="text/javascript">
        //图片上传预览    IE是用了滤镜。
        function previewImage(file)
        {
            var MAXWIDTH  = 260;
            var MAXHEIGHT = 180;
            var div = document.getElementById('preview');
            if (file.files && file.files[0])
            {
                div.innerHTML ='<img id=imghead>';
                var img = document.getElementById('imghead');
                img.onload = function(){
                    var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                    img.width  =  rect.width;
                    img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
                    img.style.marginTop = rect.top+'px';
                }
                var reader = new FileReader();
                reader.onload = function(evt){img.src = evt.target.result;}
                reader.readAsDataURL(file.files[0]);
            }
            else //兼容IE
            {
                var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
                file.select();
                var src = document.selection.createRange().text;
                div.innerHTML = '<img id=imghead>';
                var img = document.getElementById('imghead');
                img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
                div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
            }
        }
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight )
            {
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;

                if( rateWidth > rateHeight )
                {
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else
                {
                    param.width = Math.round(width / rateHeight);
                    param.height = maxHeight;
                }
            }

            param.left = Math.round((maxWidth - param.width) / 2);
            param.top = Math.round((maxHeight - param.height) / 2);
            return param;
        }

	</script>
</head>
<body data-spy="scroll" data-target="#myScrollspy">
<div class="container-fluid">
	<%@include file="head.jsp"%>
	<div class="container">

		<div class="row">
			<div class="col-xs-4 col-xs-offset-4">
				<h2 style="text-align: center;">修改菜品</h2>
			</div>
			<div class="col-xs-1 col-xs-offset-3">
				<a class="btn btn-default" href="${pageContext.request.contextPath}/back/default.jsp">返回</a>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<form action="${pageContext.request.contextPath}/service?action=doUpdateFood" method="post" role="form" enctype="multipart/form-data">
					<input type="hidden" name="fid" value="${food.fid}">
					<table class="table table-borderd" align="center" width="500">
						<tr>
							<td>菜品名称：</td>
							<td><input type="text" name="fname" class="form-control" value="${food.fname}" /></td>
						</tr>
						<tr>
							<td>菜品价格：</td>
							<td><input type="text" name="fprice" class="form-control" value="${food.fprice}" /></td>
						</tr>
						<tr>
							<td>菜品销量：</td>
							<td><input type="text" name="fsellCount" class="form-control" value="${food.fsellCount}" readonly /></td>
						</tr>
						<tr>
							<td>菜品图片：</td>
							<td>
								<div id="preview">
									<img id="imghead" class="img-thumbnail" src='<%=request.getContextPath()%>/foodImg/${food.fimage}'>
								</div>
								<input type="file" class="form-control" name="fileName" onchange="previewImage(this)" />
								<input type="text" name="fimage" class="form-control" value="${food.fimage}"  />
							</td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center">
								<input type="submit" class="btn btn-primary" value="修改菜品"/>
								<input type="reset"  class="btn btn-default" value="重置"/>

							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>