<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>知识点管理模块页面</title>
	<meta http-equiv="pragma" knowlege="no-cache">
	<meta http-equiv="cache-control" knowlege="no-cache">
	<meta http-equiv="expires" knowlege="0">    
	<meta http-equiv="keywords" knowlege="keyword1,keyword2,keyword3">
	<meta http-equiv="description" knowlege="This is my page">
	<%@include file="/common/common.jsp" %>
	<style type="text/css">
		*{font-family:'Microsoft yahei';}
		
/* 		.content{width:100%;height:100px;background:#9933cc;margin-bottom:60px;} */
		.top{width:100%;height:60px;background:#15171F;position:absolute;top:0;}
		.main{width:1140px;height:60px;margin:0 auto;}
		.logo{width:103px;height:28px;float:left;margin:20px 0 0 16px;}
		.nav{width:500px;height:60px;float:left;margin-left:100px;}
		.nav ul li{float:left;line-height:60px;padding:0 26px;text-align:center;font-size:14px;}
		.nav .hid{width:100%;position:absolute;left:0;background:#00cece;display:none;}
		.nav .hov:hover{background:#00cece;}
		.nav .hov:hover .hid{display:block;}
		.nav .hid ul{width:1140px;margin:0 auto;}
		.nav .hid ul a{color:#000;}
		.nav .hid ul a:hover{color:#fff;text-decoration:underline;}
		
		.login{height:30px;float:right;margin:14px 20px 0 0;}
		.login a{padding:2px 5px;height:28px;color:#fff;font-size:14px;line-height:30px;}
		.login a i{margin-right:5px}
		.login .a1{float:left;border:1px solid #666;margin-right:10px}
		.login .a2{float:left;background:#5580FB;border:1px solid #5580FB}
		.login .a1:hover{background:#5580FB;}

		.fixed{position:fixed;top:0;}

  	</style>
 </head>
 <body>
<!-- 	<div class="content"></div> -->
	<!-- <div class="top">
		<div class="main">
			<div class="logo"></div>
			<div class="nav">
				<ul>
					<li><a href="#">首页</a></li>
					<li class="hov">
						<a href="#">课程</a>
						<div class="hid">
							<ul>
								<li><a href="#">网页制作</a></li>
								<li><a href="#">ps</a></li>
								<li><a href="#">摄影</a></li>
								<li><a href="#">淘宝电商</a></li>
								<li><a href="#">Java</a></li>
								<li><a href="#">CAD制图</a></li>
								<li><a href="#">影视后期</a></li>
								<li><a href="#">C++/PHP</a></li>
							</ul>
						</div>
					</li>
					<li class="hov">
						<a href="#">老师</a>
						<div class="hid">
							<ul>
								<li><a href="http://wpa.qq.com/msgrd?v=3&uin=635900003&site=qq&menu=yes">冰淇淋老师</a></li>
								<li><a href="#">阿飞老师</a></li>
								<li><a href="#">清心老师</a></li>
								<li><a href="#">零曦老师</a></li>
								<li><a href="#">木子老师</a></li>
								<li><a href="#">黄河老师</a></li>
								<li><a href="#">晴雪老师</a></li>
								
							</ul>
						</div>
					</li>
					<li><a href="#">论坛</a></li>
					<li><a href="#">咨询</a></li>
					<li><a href="#">公告</a></li>
				</ul>
			</div>
			<div class="login">
				<a href="" class="a1"><i class="fa fa-paper-plane"></i>登录</a><a href="" class="a2"><i class="fa fa-user-plus"></i>注册</a>
			</div>
		</div>
	</div>
	
	<div style="width:100%;height:500px;background:#ffccff;"></div>
	<div style="width:100%;height:500px;background:#ffcc66;"></div>
	<div style="width:100%;height:500px;background:#99cc33;"></div>
	<div style="width:100%;height:500px;background:#66ff99;"></div>
	<div style="width:100%;height:500px;background:#cccc66;"></div>
	<div style="width:100%;height:500px;background:#3366cc;"></div>
	 -->
	
	
	<div style="width:200px;height:200px">
		
				id:<input type="text" id="id"><br>
				name:<input type="text" id="name"><br>
				<input type="button" value="提交" onclick="tm_update(this)">
		</div>
	<script>
		//var topCon = $(".content").height();
		$(window).scroll(function(){
			var topScr = $(window).scrollTop();
			if(topScr > 0){
				$(".top").addClass("fixed");
			}else{
				$(".top").removeClass("fixed");
			}
		});
		
		function tm_update(obj){
			var id = $("#id").val();
			var name = $("#name").val();
			var params = {id:id,name:name};
// 			alert(jsonToString(params));
			$.ajax({
				type:"post",
				url:"/tmblog/admin/knowlege/update",
				data:params,
				success:function(data){
					alert(data);
				}
			});
		}
	</script>

 </body>
</html>
