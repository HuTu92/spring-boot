<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HttpMessageConverter</title>
</head>
<body>
<div>
    <div id="resp"></div>
    <input type="button" onclick="req()" value="请求"/>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script>
    function req() {
        $(document).ready(
            $.ajax({
                url: "${pageContext.request.contextPath}/convert",
                data: "0001-liucl",
                type: "post",
                contentType: "application/x-fnpac",
                success: function (data) {
                    $("#resp").html(data);
                }
            })
        );
    }
</script>
</body>
</html>