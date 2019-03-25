package cn.tsxygfy.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tsxygfy.bean.PageBean;
import cn.tsxygfy.bean.Student;
import cn.tsxygfy.service.StudentService;
import cn.tsxygfy.service.impl.StudentServiceImpl;

@WebServlet("/StudentListPage")
public class StudentListPage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		try {
			StudentService service = new StudentServiceImpl();
			PageBean<Student> pageBean = service.findStudentByPage(currentPage);
			request.setAttribute("pageBean", pageBean);
			
			request.getRequestDispatcher("listpage.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
