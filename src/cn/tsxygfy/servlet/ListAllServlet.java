package cn.tsxygfy.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tsxygfy.bean.Student;
import cn.tsxygfy.service.StudentService;
import cn.tsxygfy.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class ListAllServlet
 */
@WebServlet("/ListAllServlet")
public class ListAllServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService service = new StudentServiceImpl();
		try {
			List<Student> students = service.findAll();
			request.setAttribute("allStudent", students);
			request.getRequestDispatcher("showall.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
