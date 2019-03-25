package cn.tsxygfy.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tsxygfy.service.StudentService;
import cn.tsxygfy.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String noStr = request.getParameter("id");
		int id = Integer.parseInt(noStr);
		
		try {
			StudentService service = new StudentServiceImpl();
			boolean student = service.deleteStudent(id);
			if(student) {
				request.setAttribute("delinfo", "删除成功！");
				request.getRequestDispatcher("StudentListPage?page=1").forward(request, response);
			}else {
				request.setAttribute("delinfo", "删除失败！");
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
