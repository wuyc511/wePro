<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="/ssm/user/doRegister.action" method="post" enctype="multipart/form-data">
     	 用户名：<input type="text"  name="username" value="${user.username}"><br>
     	密码：<input type="text"  name="password"><br>
     	性别：<input type="radio" name="sex" value="0">男<input type="radio" value="1" name="sex">女 <br>
     	生日：<input type="text" name="birth"><br>
     	身份证：<input type="text" name="identityCode"><br>
     	头像：<input type="file" name="pictureFile"><br>
     	<input type="submit" value="注册">
     	
     	 	 
     </form>
</body>
</html>