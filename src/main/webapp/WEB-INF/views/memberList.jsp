<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 목록</title>
</head>
<body>
	<table border="1" cellpadding="0">
		<tr bgcolor="pink">
			<th>id</th>
			<th>pw</th>
			<th>name</th>
			<th>email</th>
			<th>date</th>
		</tr>
		<c:forEach items="${dtos }" var="list">
		<tr>
			<td>${list.mid }</td>
			<td>${list.mpw }</td>
			<td>${list.mname }</td>
			<td>${list.memail }</td>
			<td>${list.mdate }</td>
		</tr>
		</c:forEach>
		<tr>
			<td>
				<input type="button" value="돌아가기">
			</td>
		</tr>
	</table>
</body>
</html>