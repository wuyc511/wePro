<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>  
<form action="/ssm/user/search.action" method="post">
<table border='1' width='60%' align='center'> 
    <tr>
    	<td colspan="8">
    		<select name="type">
    			<option value="username">用户名</option>
    			<option value="id">身份证号</option>
    		</select>
    		
    		<input type="text" name="val" />
    		<input type="submit" value="查询">
    	</td>
    	
    </tr>
	<tr>
		<td>ID</td>
		<td>用户名</td>
		<td>密码</td>
		<td>性别</td>
		<td>生日</td>
		<td>身份证号</td>
		<td>头像</td>
		<td>操作</td>
	</tr> 
	
	 <c:forEach items="${page.list }" var="user">
	 		<tr>
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>${user.sex }</td>
				<td>${user.birthday }</td>
				<td>${user.identityCode }</td>
				<td><img src="/img/${user.image}" /></td>
				 <td><a href="/ssm/user/edit.action?userid=${user.id }">修改</a>&nbsp;|&nbsp;<a href="">删除</a></td>
			</tr>
	 </c:forEach>
	 <tr>
	 	<td colspan="8">
	 		<a href="/ssm/user/search.action?pageno=1">首页</a>
	 		<a href="/ssm/user/search.action?pageno=${page.prePage }">上一页</a>
	 		<a href="/ssm/user/search.action?pageno=${page.nextPage }">下一页</a>
	 		<a href="/ssm/user/search.action?pageno=${page.pages }">尾页</a>
	 	</td>
	 </tr>
</table>
</form>
</body>
</html>