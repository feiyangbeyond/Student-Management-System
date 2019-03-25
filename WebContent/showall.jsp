<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.tsxygfy.bean.Student" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页 - 学生管理系统</title>
	</head>
<body>
	
<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<td colspan="2">按学号查询：
		<input name="no" type="text" /><input type="button" value="查询"/></td>
		<td colspan="3"></td>
		
		<td colspan="3" style="red">
		${requestScope.addinfo}
		${requestScope.delinfo}
		${requestScope.updateinfo}</td>
		<td><a href="add.jsp">添加学生</a></td>
	</tr>
	<tr align="center">
		<td>编号</td>
		<td>学号</td>
		<td>班级</td>
		<td>姓名</td>
		<td>性别</td>
		<td>电话</td>
		<td>宿舍楼</td>
		<td>寝室号</td>
		<td>操作</td>
	</tr>

	<c:forEach items="${requestScope.allStudent}" var="student">
	<tr align="center">
		<td>${student.stu_id}</td>
		<td>${student.stu_no}</td>
		<td>${student.stu_class}</td>
		<td>${student.stu_name}</td>
		<td>${student.stu_sex}</td>
		<td>${student.stu_phone}</td>
		<td>${student.stu_buildingNo}</td>
		<td>${student.stu_houseNo}</td>
		<td><a href="FindServlet?id=${student.stu_id}">更新</a> <a href="DeleteStudentServlet?id=${student.stu_id}">删除</a></td>
	</tr>
	</c:forEach>

</table>


</body>
</html>