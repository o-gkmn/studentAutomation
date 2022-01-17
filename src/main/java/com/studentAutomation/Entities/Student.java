package com.studentAutomation.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "student")
public class Student{
	@Id
	@Column(name= "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name= "studentNo")
	private int studentNo;
	@Column(name= "studentAge")
	private int studentAge;
	@Column(name= "studentClass")
	private int studentClass;
	@Column(name= "studentName")
	private String studentName;
	@Column(name= "studentSurname")
	private String studentSurname;
	@Column(name = "studentBirthday")
	private String studentBirthday;
	@Column(name= "studentPhone")
	private String studentPhone;
	@Column(name= "studentEmail")
	private String studentEmail;
	@Column(name= "studentDepartment")
	private String studentDepartment;
	@Column(name= "studentFaculty")
	private String studentFaculty;
	@Column(name= "studentAddress")
	private String studentAddress;
	@Column(name= "studentPassword")
	private String studentPassword;
	@Column(name= "studentType")
	private String studentType;

	public Student(int studentNo, int studentAge, int studentClass, String studentName, String studentSurname, String studentBirthday,
			String studentPhone, String studentEmail, String studentDepartment, String studentFaculty, String studentAddress, 
			String studentPassword, String studentType) {
		this.studentNo = studentNo;
		this.studentAge = studentAge;
		this.studentClass = studentClass;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.studentBirthday = studentBirthday;
		this.studentPhone = studentPhone;
		this.studentEmail = studentEmail;
		this.studentDepartment = studentDepartment;
		this.studentFaculty = studentFaculty;
		this.studentAddress = studentAddress;
		this.studentPassword = studentPassword;
		this.studentType = studentType;
	}

	public Student() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSurname() {
		return studentSurname;
	}
	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentDepartment() {
		return studentDepartment;
	}
	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	public String getStudentFaculty() {
		return studentFaculty;
	}
	public void setStudentFaculty(String studentFaculty) {
		this.studentFaculty = studentFaculty;
	}
	public int getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	public String getStudentBirthday() {
		return studentBirthday;
	}
	public void setStudentBirthday(String studentBirthday) {
		this.studentBirthday = studentBirthday;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	public String getStudentType() {
		return studentType;
	}
	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}
}
