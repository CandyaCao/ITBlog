<%--
  Created by IntelliJ IDEA.
  User: j
  Date: 2018/12/31
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发表文章</title>
</head>
<body>
    <form action="publish" method="POST">
        标题：<input type="text" name="title"> <br><br><br>
        摘要：<textarea rows="3" cols="20" name="summary"></textarea> <br><br>
        内容：<textarea rows="7" cols="20" name="content"></textarea> <br><br>
        <input type="submit" value="submit"><input type="reset" value="reset">
    </form>
</body>
</html>
