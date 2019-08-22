<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="/ssm/user/confirmEdit.action" method="post">
   
         <input type="hidden" name="id" value="${user.id }" />
     	 用户名：<input type="text"  name="username" value="${user.username }"><br>
     	密码：<input type="text"  name="password" value="${user.password }"><br>
     	性别：<input type="radio" name="sex" value="0" ${user.sex==0 ? 'checked':''} >男<input type="radio" value="1" name="sex" ${user.sex==1 ? 'checked':''}>女 <br>
     	生日：<input type="text" name="birthday" value="${user.birthday }"><br>
     	身份证：<input type="text" name="identityCode" value="${user.identityCode }"><br>
     	<input type="submit" value="确认修改">
     	
     	 	 
     </form>
</body>
</html>