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

@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("id"));
		try {
			StudentService service = new StudentServiceImpl();
			Student student = service.findStudent(no);
			request.setAttribute("student", student);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
