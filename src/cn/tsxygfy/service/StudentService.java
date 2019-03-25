package cn.tsxygfy.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import cn.tsxygfy.bean.PageBean;
import cn.tsxygfy.bean.Student;


public interface StudentService {
	
	/**
	 * 查询所有学生
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	List<Student> findAll() throws IOException, SQLException;
	
	/**
	 * 添加学生
	 * @param student
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	boolean addStudent(Student student) throws IOException, SQLException;
	
	/**
	 * 删除学生
	 * @param no
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	boolean deleteStudent(int id) throws IOException, SQLException;
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	boolean updateStudent(Student student) throws IOException, SQLException;
	
	/**
	 * 查找单个学生
	 * @param no
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	Student findStudent(int id) throws IOException, SQLException;
	
	/**
	 * 处理分页
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	PageBean<Student> findStudentByPage(int currentPage) throws IOException, SQLException;

}
