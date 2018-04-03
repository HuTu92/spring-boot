<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>上传页面</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file"><br/>
        <input type="submit" value="上传文件">
    </form>
</div>
</body>
</html>