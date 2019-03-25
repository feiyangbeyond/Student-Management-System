package cn.tsxygfy.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import cn.tsxygfy.bean.PageBean;
import cn.tsxygfy.bean.Student;
import cn.tsxygfy.dao.StudentDao;
import cn.tsxygfy.dao.impl.StudentDaoImpl;
import cn.tsxygfy.service.StudentService;

public class StudentServiceImpl implements StudentService{
	/**
	 * 查询全部的学生
	 */
	@Override
	public List<Student> findAll() throws IOException, SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}
	
	/**
	 * 添加一个学生
	 */
	@Override
	public boolean addStudent(Student student) throws IOException, SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.addStudent(student);
	}

	/**
	 * 删除一个学生
	 */
	@Override
	public boolean deleteStudent(int id) throws IOException, SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.deleteStudent(id);
	}

	/**
	 * 更新一个学生
	 */
	@Override
	public boolean updateStudent(Student student) throws IOException, SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.updateStudent(student);
	}

	/**
	 * 通过学号查学生
	 */
	@Override
	public Student findStudent(int id) throws IOException, SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudent(id);
	}

	/**
	 * 分页查学生
	 */
	@Override
	public PageBean<Student> findStudentByPage(int currentPage) throws IOException, SQLException {
		//封装分页的该页数据
		PageBean<Student> pageBean = new PageBean<Student>();
		//设置当前页 
		pageBean.setCurrentPage(currentPage);  
		//设置每一页显示多少数据
		pageBean.setPageSize(StudentDao.PAGE_SIZE); 
		
		StudentDao dao = new StudentDaoImpl();
		List<Student> list = dao.findStudentByPage(currentPage);
		pageBean.setList(list); 
		//显示的学生信息
		int totalSize = dao.totalSize();
		//总记录数 
 		pageBean.setTotalSize(totalSize); 
 		//总页数
		pageBean.setTotalPage(totalSize % StudentDao.PAGE_SIZE == 0 ? totalSize/StudentDao.PAGE_SIZE : totalSize/StudentDao.PAGE_SIZE+1);
		
		return pageBean;
	}
}
