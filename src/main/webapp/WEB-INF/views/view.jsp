<%@ page language="java" contentType="text/html; charset=UTF-8"
         isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상세정보</title>
    <style>
        body {
            background-color: ivory;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        #container {
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

        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .button-container button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #2196F3;
            color: white;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-right: 10px;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 10px;
            text-decoration: none;
        }
    </style>
</head>
<body>

<div id="container">
    <h1>상세정보</h1>
    <%--@elvariable id="u" type="com"--%>
    <form:form modelAttribute="u" method="POST" action="../editok">
        <form:hidden path="seq"/>
        <table id="view">
            <tr><td>주인이름</td><td><span>${u.mname}</span></td></tr>
            <tr><td>동물이름</td><td><span>${u.pname}</span></td></tr>
            <tr><td>종</td><td><span>${u.kind}</span></td></tr>
            <tr><td>휴대폰번호</td><td><span>${u.pnumber}</span></td></tr>
            <tr><td>입원날짜</td><td><span>${u.comeday}</span></td></tr>
            <tr><td>퇴원날짜</td><td><span>${u.byeday}</span></td></tr>
            <tr><td>상세내용</td><td><span>${u.contents}</span></td></tr>
        </table>
        <button type="button" onclick="history.back()">뒤로가기</button>
        <button type="button" onclick="edit_post('${u.seq}')">수정하기</button>
    </form:form>
</div>

</body>
<script>
    function edit_post(seq) {
        var contextPath = '${pageContext.request.contextPath}';
        location.href = contextPath + '/pet/editform/' + seq;
    }
</script>
</html>
