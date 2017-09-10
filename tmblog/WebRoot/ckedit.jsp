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
	<%@include file="/common/common.jsp"%>
	<style type="text/css">
		.box{width:800px;margin:0 auto}
	</style>
</head>
<body>
	<div class="box">
	
	<textarea id="e_ckedit" style="overflow: auto;" name="description" placeholder="请输入内容...">请输入内容...</textarea>
	</div>
	
	<script type="text/javascript">
		$(function(){
			//CKedit可以通过回调方法控制宽度和高度
			CKEDITOR.replace("e_ckedit",{height:600});
		});
		
		//得到焦点 
		function editorFocus(id) {
			CKEDITOR.instances[id].focus();
		}

		//获取带有格式的内容--html
		function getEditorHtml(editorId) {
			var editor = CKEDITOR.instances[editorId];
		    return editor.getData();
		};

		//获取编辑器内容,纯文本 text
		function getEditorText(editor) {
			var stemTxt = CKEDITOR.instances[editor].document.getBody().getText();
			return stemTxt;
		};

		//插入编辑器内容--覆盖
		function setEditorContent(editorId,message) {
			var editor = CKEDITOR.instances[editorId];
			editor.setData(message);
		};

		//追加编辑器内容--追加
		function  appendEditorContent(editorId,message){
			var editor = CKEDITOR.instances[editorId];
			editor.insertHtml(message);
		};
	</script>
</body>
</html>
