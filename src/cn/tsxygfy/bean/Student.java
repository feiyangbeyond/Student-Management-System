package cn.tsxygfy.bean;

public class Student {
	private int stu_id;
	private int stu_no;
	private String stu_class;
	private String stu_name;
	private String stu_sex;
	private String stu_phone;
	private int stu_buildingNo;
	private int stu_houseNo;


	public Student(int stu_id, int stu_no, String stu_class, String stu_name, String stu_sex, String stu_phone,
			int stu_buildingNo, int stu_houseNo) {
		this.stu_id = stu_id;
		this.stu_no = stu_no;
		this.stu_class = stu_class;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_phone = stu_phone;
		this.stu_buildingNo = stu_buildingNo;
		this.stu_houseNo = stu_houseNo;
	}
	

	public Student(int stu_no, String stu_class, String stu_name, String stu_sex, String stu_phone, int stu_buildingNo,
			int stu_houseNo) {
		this.stu_no = stu_no;
		this.stu_class = stu_class;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_phone = stu_phone;
		this.stu_buildingNo = stu_buildingNo;
		this.stu_houseNo = stu_houseNo;
	}


	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_no = stu_id;
	}

	public int getStu_no() {
		return stu_no;
	}

	public void setStu_no(int stu_no) {
		this.stu_no = stu_no;
	}

	public String getStu_class() {
		return stu_class;
	}

	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public String getStu_phone() {
		return stu_phone;
	}

	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}

	public int getStu_buildingNo() {
		return stu_buildingNo;
	}

	public void setStu_buildingNo(int stu_buildingNo) {
		this.stu_buildingNo = stu_buildingNo;
	}

	public int getStu_houseNo() {
		return stu_houseNo;
	}

	public void setStu_houseNo(int stu_houseNo) {
		this.stu_houseNo = stu_houseNo;
	}

}
