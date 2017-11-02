<%--
  Created by IntelliJ IDEA.
  User: lipy-b
  Date: 2017/11/2
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
    ${user.userName}欢迎。你的积分为${user.credits}!
</body>
</html>
