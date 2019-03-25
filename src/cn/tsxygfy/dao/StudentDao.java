package cn.tsxygfy.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import cn.tsxygfy.bean.Student;

public interface StudentDao {
	
	int PAGE_SIZE = 10; //定义在接口里的成员是常量
	
	/**
	 * 分页查询
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	List<Student>  findStudentByPage(int currentPage) throws SQLException, IOException;
	
	/**
	 * 查询全部学生
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	List<Student> findAll() throws SQLException, IOException;
	
	/**
	 * 添加一个学生
	 * @param student
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	boolean addStudent(Student student) throws IOException, SQLException;
	
	/**
	 * 删除一个学生
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	boolean deleteStudent(int id) throws IOException, SQLException;
	
	/**
	 * 更新一个学生信息
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	boolean updateStudent(Student student) throws IOException, SQLException;
	
	/**
	 * 根据id查询一个学生信息
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	Student findStudent(int id) throws IOException, SQLException;
	
	/**
	 * 查询总的记录数
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	int totalSize() throws IOException, SQLException;

}
