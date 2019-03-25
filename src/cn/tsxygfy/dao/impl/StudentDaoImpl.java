package cn.tsxygfy.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import cn.tsxygfy.bean.PageBean;
import cn.tsxygfy.bean.Student;
import cn.tsxygfy.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {
	
	/**
	 * 分页查询学生
	 */
	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException, IOException {
		return findByPage(currentPage);
	}
	
	/**
	 * 查询一个学生的信息
	 */
	@Override
	public Student findStudent(int id) throws IOException, SQLException{
		return findOne(id);
	}
	
	/**
	 * 公共的根据学号更新一个学生的方法
	 */
	@Override
	public boolean updateStudent(Student student) throws IOException, SQLException {
		return update(student);
	}

	
	/**
	 * 公共的根据学号删除一个学生的方法
	 */
	@Override
	public boolean deleteStudent(int id) throws IOException, SQLException {
		return deleleById(id);
	}
	
	/**
	 * 公共的查询全部学生方法
	 */
	@Override
	public List<Student> findAll() throws SQLException, IOException {
		List<Student> queryAllStu = queryAllStu();
		return queryAllStu;
	}
	
	/**
	 * 公共的添加一个学生的方法
	 * @throws IOException 
	 * @throws SQLException 
	 */
	@Override
	public boolean addStudent(Student student) throws IOException, SQLException {
		return insertStudent(student);
	}
	
	/**
	 * 查询学生表中记录总数
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public int totalSize() throws IOException, SQLException {
		Connection connection = getConnection();
		String sql = "SELECT COUNT(*) FROM student";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		rs.next();
		int value = rs.getInt(1);
		close(null, statement, connection);
		return value;
		
	}
	
	/**
	 * 
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	private static List<Student>  findByPage(int currentPage) throws SQLException, IOException {
		Student student = null;
		List<Student> list = new ArrayList<Student>();
		Connection connection = getConnection();
		String sql = "select * from student limit ? offset ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, PAGE_SIZE);
		statement.setObject(2, (currentPage-1)*10);
		//1-10       0
		//11-20      2
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			int stu_id = resultSet.getInt("stu_id");
			int stu_no = resultSet.getInt("stu_no");
			String stu_class = resultSet.getString("stu_class");
			String stu_name = resultSet.getString("stu_name");
			String stu_sex = resultSet.getString("stu_sex");
			String stu_phone = resultSet.getString("stu_phone");
			int stu_buildingNo = resultSet.getInt("stu_buildingNo");
			int stu_houseNo = resultSet.getInt("stu_houseNo");
			student = new Student(stu_id, stu_no, stu_class, stu_name, stu_sex, stu_phone, stu_buildingNo, stu_houseNo);
			list.add(student);
		}
		close(resultSet, statement, connection);
		return list;
		
	}
	
	/**
	 * 通过学号查询一个学生
	 * @throws IOException 
	 * @throws SQLException 
	 */
	private static Student findOne(int id) throws IOException, SQLException {
		Student student = null;
		Connection connection = getConnection();
		String sql = "select * from student where stu_id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, id);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			int stu_id = resultSet.getInt("stu_id");
			int stu_no = resultSet.getInt("stu_no");
			String stu_class = resultSet.getString("stu_class");
			String stu_name = resultSet.getString("stu_name");
			String stu_sex = resultSet.getString("stu_sex");
			String stu_phone = resultSet.getString("stu_phone");
			int stu_buildingNo = resultSet.getInt("stu_buildingNo");
			int stu_houseNo = resultSet.getInt("stu_houseNo");
			student = new Student(stu_id, stu_no, stu_class, stu_name, stu_sex, stu_phone, stu_buildingNo, stu_houseNo);
		}	
		close(resultSet, statement, connection);
		return student;
	} 
	
	
	/**
	 * 通过学号删除一个学生
	 * @param no 学号
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	private static boolean deleleById(int id) throws IOException, SQLException {
		boolean flag = false;
		Connection connection = getConnection();
		String sql = "DELETE FROM student WHERE stu_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, id);
		int i = statement.executeUpdate();
		if(i != 0) {
			flag = true;
		}
		close(null, statement, connection);
		return flag;
		
	}
	
	/**
	 * 添加一个学生
	 * @param student
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	private static boolean insertStudent(Student student) throws IOException, SQLException  {
		boolean flag = false;
		Connection connection = getConnection();
		String sql = "INSERT INTO student (stu_no, stu_class, stu_name, stu_sex, stu_phone, stu_buildingNo, stu_houseNo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, student.getStu_no());
		statement.setObject(2, student.getStu_class());
		statement.setObject(3, student.getStu_name());
		statement.setObject(4, student.getStu_sex());
		statement.setObject(5, student.getStu_phone());
		statement.setObject(6, student.getStu_buildingNo());
		statement.setObject(7, student.getStu_houseNo());
		int update = statement.executeUpdate();
		if(update != 0) {
			flag = true;
		}
		close(null, statement, connection);
		return flag;
	}
	
	/**
	   *  获得数据库连接
	 * @return
	 * @throws IOException
	 */
	private static Connection getConnection() throws IOException {
		
		String className;
		String url;
		String username;
		String password;	
		Connection connection = null;
		
		FileInputStream reader = new FileInputStream("E:\\eclipse\\stu_manage\\src\\dbinfo.properties");
		Properties properties = new Properties();
		properties.load(reader);
		className = properties.getProperty("driverclass");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	/**
	 * 查询全部的学生
	 * @throws IOException 
	 * @throws SQLException 
	 */
	private static List<Student> queryAllStu() throws IOException, SQLException {
		Student student = null;
		List<Student> list = new ArrayList<Student>();
		Connection connection = getConnection();
		String sql = "select * from student";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			int stu_id = resultSet.getInt("stu_id");
			int stu_no = resultSet.getInt("stu_no");
			String stu_class = resultSet.getString("stu_class");
			String stu_name = resultSet.getString("stu_name");
			String stu_sex = resultSet.getString("stu_sex");
			String stu_phone = resultSet.getString("stu_phone");
			int stu_buildingNo = resultSet.getInt("stu_buildingNo");
			int stu_houseNo = resultSet.getInt("stu_houseNo");
			student = new Student(stu_id, stu_no, stu_class, stu_name, stu_sex, stu_phone, stu_buildingNo, stu_houseNo);
			list.add(student);
		}
		
		close(resultSet, statement, connection);
		return list;
		
	}
	
	
	private static boolean update(Student student) throws IOException, SQLException {
		boolean flag = false;
		Connection connection = getConnection();
		String sql = "UPDATE student SET stu_no= ?, stu_class=? , stu_name=? , stu_sex= ?, stu_phone= ?, stu_buildingNo=?, stu_houseNo=? where stu_id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, student.getStu_no());
		statement.setObject(2, student.getStu_class());
		statement.setObject(3, student.getStu_name());
		statement.setObject(4, student.getStu_sex());
		statement.setObject(5, student.getStu_phone());
		statement.setObject(6, student.getStu_buildingNo());
		statement.setObject(7, student.getStu_houseNo());
		statement.setObject(8, student.getStu_id());
		int i = statement.executeUpdate();
		if(i != 0)
			flag = true;
		close(null, statement, connection);
		return flag;
		
	}
	
	/**
	 * 关闭数据库连接
	 * @param connection
	 * @throws SQLException
	 */
	private static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
		if(resultSet != null) resultSet.close();
		if(statement != null) statement.close();
		if(connection != null) connection.close();
	}

	

	
}
























