<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.jsp" %>
	<h1>ログイン演習</h1>
	<p>こちらから新規登録が行えます</p>
	<form action="CustomerEntry.action" method="post">
		<p>ログイン名：<input type="text" name="login_name"required></p>
		<p>パスワード：<input type="password" name="password"required></p>
		<p>再度パスワード<input type="password" name="password_again"required>
		<input type="submit" value="登録">
	</form>
</body>
<script>
	"use strict";
	
	const entry_result ="${entry_result}";
	
	if(entry_result === ""){
		//一回目なので何も表示しない
	}else if(entry_result === "login_name-error"){
		window.alert("同じ名前が存在するため登録できません。再度登録しなおしてください。");
	}else if(entry_result === "password-error"){
		window.alert("２つのパスワードに違いがあるため登録できませんでした。再度登録しなおしてください。");
	}
	
	
</script>
</html>