<%--
  Created by IntelliJ IDEA.
  User: Banana
  Date: 2018/10/23
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<body>
<div style="margin:0px auto; width:500px">

    <form action="updateCategory" method="post">

        name: <input name="name" value="${c.name}"> <br>

        <input name="id" type="hidden" value="${c.id}">
        <button type="submit">提交</button>

    </form>
</div>
</body>
</html>
