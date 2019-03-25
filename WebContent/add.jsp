<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加学生 - 学生管理系统</title>
</head>
<body><form action="AddStudentServlet" method="post">
<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<td>学生学号：</td>
		<td><input type="number" name="stuNo"/></td>
	</tr>
	<tr>
		<td>学生班级：</td>
		<td><input type="text" name="stuClass"/></td>
	</tr>
	<tr>
		<td>学生姓名：</td>
		<td><input type="text" name="stuName"/></td>
	</tr>
	<tr>
		<td>学生性别：</td>
		<td><input type="text" name="stuSex"/></td>
	</tr>
	<tr>
		<td>学生电话：</td>
		<td><input type="number" name="stuPhone"/></td>
	</tr>
	<tr>
		<td>学生宿舍楼：</td>
		<td><input type="number" name="stuBuildingNo"/></td>
	</tr>
	<tr>
		<td>学生寝室号：</td>
		<td><input type="number" name="stuHouseNo"/></td>
	</tr>
	
</table><input type="submit" value="提交"/>

</form>
</body>
</html>