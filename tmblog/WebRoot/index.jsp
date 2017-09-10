<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
 <head>
  <title> New Document </title>
  <meta charset="UFT-8">
  <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <%@include file="/common/common.jsp" %>
  <style type="text/css">
	body,html{font-family:"微软雅黑"}
	.box{width:400px;height:100%;margin-left:130px;margin-top:20px;background:#fafafa;}
	.box .b_title{width:400px;height:100%;color:#fff;background:#111;padding:3px 0;border-bottom:1px solid #fff}
	ul li{margin-top:5px}
	.red{color:red}
	.bai{color:#fff}
	.bred{background:red}
	.abtn{padding:5px 8px;display:inline-block;border-radius:3px}
	.abtn:hover{background:#e41414}
  </style>
 
 </head>
 <body>
	

	
	
	<div class="box">
		<div class="b_title">
			使用fa-*来控制字体大小
		</div>
		<ul class="fa-ul">
		  <li><i class="fa fa-camera-retro fa-lg"></i>fa-lg</li>
		  <li><i class="fa fa-camera-retro fa-2x"></i>fa-2x</li>
		  <li><i class="fa fa-camera-retro fa-3x"></i>fa-3x</li>
		  <li><i class="fa fa-camera-retro fa-4x"></i>fa-4x</li>
		  <li><i class="fa fa-camera-retro fa-5x"></i>fa-5x</li>
		</ul>
	</div>
	
	<div class="box">
		<div class="b_title">
			常用字体标签
		</div>
		<ul class="fa-ul">
		  <li><i class="fa-li fa fa-spinner fa-spin fa-lg"></i>fa fa-spinner fa-spin</li>
		  <li><i class="fa-li fa fa-circle-o-notch fa-spin fa-lg"></i>fa fa-circle-o-notch fa-spin</li>
		  <li><i class="fa-li fa fa-refresh fa-spin fa-lg"></i>fa fa-refresh fa-spin</li>
		  <li><i class="fa-li fa fa-spinner fa-pulse fa-lg"></i>fa fa-spinner fa-pulse</li>
		<br>
		  <li><i class="fa-li fa fa-check-square fa-lg"></i>fa fa-check-square</li>
		  <li><i class="fa-li fa fa-square fa-lg"></i>fa fa-square</li>
		  <li><i class="fa-li fa fa-quote-left fa-lg"></i>fa fa-quote-left</a></li>
		<br>
		  <li><i class="fa-li fa fa-home fa-lg"></i>fa fa-home</li>
		  <li><i class="fa-li fa fa-pencil fa-lg"></i>fa fa-pencil</li>
		  <li><i class="fa-li fa fa-book fa-lg"></i>fa fa-book</a></li>
		  <li><i class="fa-li fa fa-trash-o fa-lg"></i>fa fa-trash-o</a></li>
		  <li><i class="fa-li fa fa-cog fa-lg"></i>fa fa-cog</a></li>
		  <li><i class="fa-li fa fa-bars fa-lg"></i>fa fa-bars</a></li>
		  <li><i class="fa-li fa fa-user fa-lg"></i>fa fa-user</a></li>
		  <li><i class="fa-li fa fa-phone-square fa-lg"></i>fa fa-phone-square</a></li>
		  <li><i class="fa-li fa fa-envelope fa-lg"></i>fa fa-envelope</a></li>
		  <li><i class="fa-li fa fa-heart fa-lg"></i>fa fa-heart</a></li>
		  <li><i class="fa-li fa fa-unlock-alt fa-lg"></i>fa fa-unlock-alt</a></li>
		  <li><i class="fa-li fa fa-comment fa-lg"></i>fa fa-comment</a></li>
		  <li><i class="fa-li fa fa-commenting fa-lg"></i>fa fa-commenting</a></li>
		  <li><i class="fa-li fa fa-upload fa-lg"></i>fa fa-upload</a></li>
		  <li><i class="fa-li fa fa-download fa-lg"></i>fa fa-download</a></li>
		   
		<br>
		  <li><i class="fa-li fa fa-jpy fa-lg"></i>fa fa-jpy</a></li>
		  <li><i class="fa-li fa fa-usd fa-lg"></i>fa fa-usd</a></li>
		<br>
		  <li><i class="fa-li fa fa-arrow-left fa-lg"></i>fa fa-arrow-left</a></li>
		  <li><i class="fa-li fa fa-arrow-right fa-lg"></i>fa fa-arrow-right</a></li>
		  <li><i class="fa-li fa fa-angle-left fa-lg"></i>fa fa-angle-left</a></li>
		  <li><i class="fa-li fa fa-angle-right fa-lg"></i>fa fa-angle-right</a></li>
		  <li><i class="fa-li fa fa-chevron-left fa-lg"></i>fa fa-chevron-left</a></li>
		  <li><i class="fa-li fa fa-chevron-right fa-lg"></i>fa fa-chevron-right</a></li>
		<br>
			<li><i class="fa-li fa fa-play fa-lg"></i>fa fa-play</a></li>
			<li><i class="fa-li fa fa-pause fa-lg"></i>fa fa-pause</a></li>
			<li><i class="fa-li fa fa-backward fa-lg"></i>fa fa-backward</a></li>
			<li><i class="fa-li fa fa-forward fa-lg"></i>fa fa-forward</a></li>
			<li><i class="fa-li fa fa-stop fa-lg"></i>fa fa-stop</a></li>
		 <br>
			<li><i class="fa-li fa fa-square fa-lg"></i>fa fa-square</a></li>
			<li><i class="fa-li fa fa-square-o fa-lg"></i>fa fa-square-o</a></li>
			<li><i class="fa-li fa fa-circle fa-lg"></i>fa fa-circle</a></li>
			<li><i class="fa-li fa fa-circle-o fa-lg"></i>fa fa-circle-o</a></li>
		</ul>
	</div>

	<div class="box">
		<div class="b_title">
			实际应用
		</div>
		<a class="abtn bred" href="javascript:void(0);">
		  <i class="fa fa-trash-o bai fa-2x"></i>
		</a>样式：display:inline-block;padding:5px 8px
	</div>

	
	<div class="box">
		<div class="b_title">
			使用fa-rotate-*来控制字体旋转，fa-flip-*控字体制翻转
		</div>
		<ul class="fa-ul">
		  <li><i class="fa-li fa-lg fa fa-shield"></i> normal<br></li>
		  <li><i class="fa-li fa-lg fa fa-shield fa-rotate-90"></i> fa-rotate-90(顺时针旋转90度)<br></li>
		  <li><i class="fa-li fa-lg fa fa-shield fa-rotate-180"></i> fa-rotate-180<br></li>
		  <li><i class="fa-li fa-lg fa fa-shield fa-rotate-270"></i> fa-rotate-270<br></li>
		  <li><i class="fa-li fa-lg fa fa-shield fa-flip-horizontal"></i> fa-flip-horizontal(水平翻转)</li>
		  <li><i class="fa-li fa-lg fa fa-shield fa-flip-vertical"></i> fa-flip-vertical(垂直翻转)</li>
		</ul>
	</div>

	<div class="box">
		<div class="b_title">
			使用fa-stack嵌套使用字体，fa-stack放在父级元素上，底色放在上面，用fa-stack-2x来控制大小，图标放在下面，大小可调
		</div>
		<div class="b_title">
			fa-inverse:可以实现z-index:999的效果，如果背景只是一个框，那就没必要加这个class了
		</div>
		
		<div class="b_title">
			&lt;span class="fa-stack fa-lg"&gt;<br>
			  &nbsp;&nbsp;&nbsp;&nbsp;&lt;i class="fa fa-circle fa-stack-2x"&gt;&lt;/i&gt;<br>
			   &nbsp;&nbsp;&nbsp;&nbsp;&lt;i class="fa fa-bolt fa-stack-1x fa-inverse"&gt;&lt;/i&gt;<br>
			&lt;/span&gt;
		</div>
		<span class="fa-stack fa-lg">
		  <i class="fa fa-circle fa-stack-2x"></i>
		  <i class="fa fa-flag fa-stack-1x fa-inverse"></i>
		</span>
		fa-flag on fa-circle<br>
		<span class="fa-stack fa-lg">
		  <i class="fa fa-camera fa-stack-1x"></i>
		  <i class="fa fa-ban fa-stack-2x red"></i>
		</span>
		fa-ban on fa-camera<br>
		<span class="fa-stack fa-lg">
		  <i class="fa fa-square-o fa-stack-2x"></i>
		  <i class="fa fa-twitter fa-stack-1x"></i>
		</span>
		fa-twitter on fa-square-o<br>
		<span class="fa-stack fa-lg">
		  <i class="fa fa-square-o fa-stack-2x"></i>
		  <i class="fa fa-user  fa-stack-1x"></i>
		</span>
		fa-user on fa-square-o<br>
		<span class="fa-stack fa-lg">
		  <i class="fa fa-square-o fa-stack-2x"></i>
		  <i class="fa fa-phone  fa-stack-1x"></i>
		</span>
		fa-phone on fa-square-o<br>
		<span class="fa-stack fa-lg">
		  <i class="fa fa-square-o fa-stack-2x"></i>
		  <i class="fa fa-key  fa-stack-1x"></i>
		</span>
		fa-key on fa-square-o<br>
		<span class="fa-stack fa-lg">
		  <i class="fa fa-square-o fa-stack-2x"></i>
		  <i class="fa fa-unlock-alt  fa-stack-1x"></i>
		</span>
		fa-unlock-alt on fa-square-o<br>
		<span class="fa-stack fa-lg">
		  <i class="fa fa-square-o fa-stack-2x"></i>
		  <i class="fa fa-heart  fa-stack-1x"></i>
		</span>
		fa-heart on fa-square-o<br>

		
	</div>

 </body>
</html>
