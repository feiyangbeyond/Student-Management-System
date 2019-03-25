package cn.tsxygfy.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tsxygfy.bean.Student;
import cn.tsxygfy.service.StudentService;
import cn.tsxygfy.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String stuid = request.getParameter("stuId");
		String stuno = request.getParameter("stuNo");
		String stu_class = request.getParameter("stuClass");
		String stu_name = request.getParameter("stuName");
		String stu_sex = request.getParameter("stuSex");
		String stu_phone = request.getParameter("stuPhone");
		String stubuildingNo = request.getParameter("stuBuildingNo");
		String stuhouseNo = request.getParameter("stuHouseNo");
		
		int stu_id = Integer.parseInt(stuid);
		int stu_no = Integer.parseInt(stuno);
		int stu_buildingNo = Integer.parseInt(stubuildingNo);
		int stu_houseNo = Integer.parseInt(stuhouseNo);
		
		
		try {
			Student student = new Student(stu_id, stu_no, stu_class, stu_name, stu_sex, stu_phone, stu_buildingNo, stu_houseNo);
			StudentService service = new StudentServiceImpl();
			boolean flag = service.updateStudent(student);
			if(flag) {
				request.setAttribute("updateinfo", "更新成功！");
				request.getRequestDispatcher("StudentListPage?page=1").forward(request, response);
			}else {
				request.setAttribute("updateinfo", "更新失败！");
				request.getRequestDispatcher("StudentListPage?page=1").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
