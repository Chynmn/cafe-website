<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메뉴 등록</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>카페 신메뉴 등록하기 </header>
		<form name=form1 action="../member/register/" method="post">
		<table>	
			<tr><th>메뉴 이름</th><td><input type="text" name="id" autofocus placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>메뉴 설명</th><td><input type="text" name="passwd" placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>제품 영양 정보</th><td><input type="text" name="username"  placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>EmailAddress</th><td><input type="text" name="email" placeholder="****@****.***"></td></tr>
			<tr><th>MobileNumber</th><td><input type="text" name="mobile" placeholder="***-****-****"></td></tr>
		</table>
		<dl>
			<dd><input type="submit" name="submit" value="보내기"></dd>
			<dd><input type="reset" name="reset" value="다시 작성"></dd>
		</dl>
		</form>
	</div>
</body>
</html>