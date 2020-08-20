<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!doctype html >
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<c:forEach items="${list}" var="user">
    <%--  ${}  EL表达式 使用时需声明 --%>
    ${user}
</c:forEach>

<%-- 8.13 --%>
<%-- 当访问到当前页面时  跳转到登录页面 --%>
<jsp:forward page="pages/login.jsp"></jsp:forward>
</body>
</html>