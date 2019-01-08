<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: j
  Date: 2019/1/8
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>${post.title}</title>
</head>
<body>
${post.title}<br>
${post.summary}<br>
${post.content}<br>
<form action="../postComment" method="post">
    <input type="hidden" name="postID" value="${post.id}">
    添加评论：<textarea rows="1" cols="20" name="content"></textarea><br>
    <input type="submit" name="submit">&nbsp;&nbsp;
    <input type="reset" name="reset"><br>
</form>
<c:forEach items="${post.comments}" var="comment">
    <tr>
        <td>${comment.content}</td>
    </tr>
    <br>
</c:forEach>
</body>
</html>
