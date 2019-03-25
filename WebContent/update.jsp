<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新 - 学生管理系统</title>
</head>
<body><form action="UpdateServlet" method="post">
<input type="hidden" name="stuId"value="${student.stu_id }"/>
<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<td>学生学号：</td>
		<td><input type="number" name="stuNo" value="${student.stu_no }" /></td>
	</tr>
	<tr>
		<td>学生班级：</td>
		<td><input type="text" name="stuClass" value="${student.stu_class }"/></td>
	</tr>
	<tr>
		<td>学生姓名：</td>
		<td><input type="text" name="stuName" value="${student.stu_name }"/></td>
	</tr>
	<tr>
		<td>学生性别：</td>
		<td><input type="text" name="stuSex" value="${student.stu_sex }"/></td>
	</tr>
	<tr>
		<td>学生电话：</td>
		<td><input type="number" name="stuPhone" value="${student.stu_phone }"/></td>
	</tr>
	<tr>
		<td>学生宿舍楼：</td>
		<td><input type="number" name="stuBuildingNo" value="${student.stu_buildingNo }"/></td>
	</tr>
	<tr>
		<td>学生寝室号：</td>
		<td><input type="number" name="stuHouseNo" value="${student.stu_houseNo }"/></td>
	</tr>
	
</table><input type="submit" value="添加"/>

</form>

</body>
</html>