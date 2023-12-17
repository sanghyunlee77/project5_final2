<%@ page language="java" contentType="text/html; charset=UTF-8"
		 isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add/Edit Post</title>
</head>
<style>
	body {
		background-color: ivory;
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100vh;
		margin: 0;
	}

	#edit-container {
		max-width: 600px;
		padding: 20px;
		border: 1px solid #ccc;
		border-radius: 10px;
		background-color: #f9f9f9;
	}

	h1 {
		text-align: center;
	}

	table {
		width: 100%;
	}

	input[type="submit"],
	input[type="button"] {
		display: block;
		margin: 10px auto;
	}
</style>
<body>
<div id="edit-container">
<h1>수정 페이지</h1>
<%--@elvariable id="u" type="com"--%>
<form:form modelAttribute="u" method="POST" action="../editok">
	<form:hidden path="seq"/>
	<table id="edit">
		<tr><td>주인이름</td><td><form:input path="mname"/></td></tr>
		<tr><td>동물이름</td><td><form:input path="pname"/></td></tr>
		<tr><td>종</td><td><form:input path="kind"/></td></tr>
		<tr><td>핸드폰번호</td><td><form:input path="pnumber"/></td></tr>
		<tr><td>입원날짜</td><td><form:input path="comeday" type="date"/></td></tr>
		<tr><td>퇴원날짜</td><td><form:input path="byeday" type="date"/></td></tr>
		<tr><td>상세내용</td><td><form:input path="contents"/></td></tr>
	</table>
	<input type="submit" value="수정하기"/>
	<input type="button" value="취소하기" onclick="history.back()">
</form:form>
	</div>

</body>
</html>
