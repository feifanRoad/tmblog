<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
</head>
<body>
 
<!-- 

	http://www.angularjs.cn/	中文社区
	http://www.runoob.com/angularjs/angularjs-tutorial.html	菜鸟学习
 -->
<div ng-app="">
     <p>名字 : <input type="text" ng-model="name"></p>
     <h1>Hello {{name}}</h1>
</div>
 
</body>
</html>