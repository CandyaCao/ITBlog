<%--
  Created by IntelliJ IDEA.
  User: j
  Date: 2018/12/31
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎注册</title>
</head>
<body>
<form action="signup" method="POST">
    用户名：<input type="text" name="username"><br><br>
    密码：<input type="password" name="password"><br><br>
    再次确认：<input type="password" name="password1"><br><br>
    性别：<input type="radio" name="gender" value="male">男
    <input type="radio" name="gender" value="female">女<br><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
