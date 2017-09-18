<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/common/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<title>New Document</title>
	<meta charset="UFT-8">
	<meta name="Generator" content="EditPlus">
	<meta name="Author" content="">
	<meta name="Keywords" content="">
	<meta name="Description" content="">
	 <link href="${basePath}/resources/js/kindeditor/themes/default/default.css" rel="stylesheet" />
	 <script src="${basePath}/resources/js/kindeditor/kindeditor-all-min.js"></script>
<!-- 	 <script src="${basePath}/resources/js/kindeditor/kindeditor-all.js"></script> -->
	 <script src="${basePath}/resources/js/kindeditor/lang/zh_CN.js"></script>
	<%@include file="/common/common.jsp"%>
</head>
<body>
	<!-- 
		通过 create 创建了一个编辑器，第一个参数为 CSS 选择器，设置为 textarea ，则发表、编辑及留言的 textarea 都会变为编辑器。
		假如我们只想让发表和编辑时使用编辑器，留言时不使用编辑器，则只需将 textarea 修改为 textarea[name="post"] 即可。
		第二个参数可以设置编辑器的编辑选项，通过自定义 items 配置编辑器的工具栏，其中可用 "/" 表示换行，"|" 表示分隔符。
		并设置 allowImageUpload : false 取消编辑器的图片上传按钮。
		详细的编辑器配置可以查阅 http://www.kindsoft.net/docs/option.html
	 -->
	<textarea id="editor_id" name="content" style="width:700px;height:300px;">  
	
	</textarea>  
 

	<script>  
// 	      KindEditor.ready(function(K) {  
// 	             window.editor = K.create('#editor_id');  
// 	      });  

		KindEditor.ready(function(K) {  
           var editor1 = K.create('#editor_id', {  
            //自定义工具栏  
	        items:[  
	            'code', '|', 'justifyleft', 'justifycenter', 'justifyright',  
	            'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent',  
	            'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen',  
	            'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',  
	            'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat',  
	            '|', 'image', 'multiimage',  
	            'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',  
	            'anchor', 'link', 'unlink'  
	        ],  
	        uploadJson : 'ImgUpload.action', //图片上传Action  
	        allowImageRemote : false //取消网络图片上传  
	        });  
	     });  
	</script> 
</body>
</html>
