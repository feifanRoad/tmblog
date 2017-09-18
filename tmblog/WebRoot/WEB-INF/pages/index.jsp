<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>登陆页面</title>
	<meta http-equiv="pragma" knowlege="no-cache">
	<meta http-equiv="cache-control" knowlege="no-cache">
	<meta http-equiv="expires" knowlege="0">    
	<meta http-equiv="keywords" knowlege="keyword1,keyword2,keyword3">
	<meta http-equiv="description" knowlege="This is my page">
	<%@include file="/common/common.jsp" %>
	<link rel="stylesheet" href="${basePath}/resources/css/ht_page.css"/>
	<link rel="stylesheet" href="${basePath}/resources/css/sg.css"/>
	
 </head>
	<div class="container">
	     <div class="dh clearfix">
	          <div class="dh_left fl"><img src="images/logo.png" alt=""/></div>
	          <div class="dh_list fl">
	               <ul>
	                   <li><a href="javascript:void(0);">banner管理</a></li>
	                   <li><a href="javascript:void(0);">课程管理</a></li>
	                   <li><a href="javascript:void(0);">新闻管理</a></li>
	                   <li class="select"><a href="javascript:void(0);">讲师管理</a></li>
	                   <li><a href="javascript:void(0);">公司介绍管理</a></li>
	                   <li><a href="javascript:void(0);">友情链接管理</a></li>
	                   <li><a href="${basePath}/logout">退出</a></li>
	               </ul>
	          </div>
	     </div>
	     <div class="ht_con clearfix">
	          <a href="javascript:void(0);" class="add_btn btn">增加讲师</a>
	          <div class="add_nr">
	               <div class="row_sty clearfix">
	                   <p>讲师名称：</p>
	                   <input type="text" class="text_box" placeholder="请在此输入名称--">
	               </div>
	               <div class="row_sty clearfix">
	                    <p>&nbsp;</p>
	                    <div class="pic_show">
	                         <a href="javascript:void(0);" class="up_img btn_up btn">上传图片</a>
	                         <div id="kecheng"><img src="images/pic7.jpg" alt=""/></div>
	                    </div>
	               </div>
	               <div class="row_sty clearfix">
	                   <p>讲师介绍：</p>
	                   <textarea class="textarea_nr"></textarea>
	               </div>
	               <div class="row_sty clearfix">
	                   <p>&nbsp;</p>
	                   <a href="javascript:void(0);" class="submit btn">立即提交</a>
	               </div>               
	          </div>
	          <div class="kc_list">
	               <ul>
	                   <li><p><img src="images/pic8.jpg" alt=""/>讲师1</p><a href="#" class="btn edit">编辑</a><a href="#" class="btn delet">删除</a></li>
	                   <li><p><img src="images/pic9.jpg" alt=""/>讲师2</p><a href="#" class="btn edit">编辑</a><a href="#" class="btn delet">删除</a></li>
	                   <li><p><img src="images/pic10.jpg" alt=""/>讲师3</p><a href="#" class="btn edit">编辑</a><a href="#" class="btn delet">删除</a></li>
	                   <li><p><img src="images/pic11.jpg" alt=""/>讲师4</p><a href="#" class="btn edit">编辑</a><a href="#" class="btn delet">删除</a></li>
	                   <li><p><img src="images/pic12.jpg" alt=""/>讲师5</p><a href="#" class="btn edit">编辑</a><a href="#" class="btn delet">删除</a></li>
	                   <li><p><img src="images/pic13.jpg" alt=""/>讲师6</p><a href="#" class="btn edit">编辑</a><a href="#" class="btn delet">删除</a></li>
	               </ul>
	          </div>
	     </div>
	</div>
	<div class="bottom">Copyright © 2013-2015 www.tanzhouedu.com All Rights Reserved 版权所有：湖南潭州教育咨询有限公司 备案号：备13016338号</div>
</body>
</html>
