<%--
  Created by IntelliJ IDEA.
  User: j
  Date: 2018/12/31
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signin</title>
</head>
<body>
<form action="signin" method="POST">
    <label for="username">用户名：</label><input id="username" type="text" name="username"><br><br>
    <label for="password">密&nbsp;&nbsp;&nbsp;码：</label><input id="password" type="password" name="password"><br><br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
