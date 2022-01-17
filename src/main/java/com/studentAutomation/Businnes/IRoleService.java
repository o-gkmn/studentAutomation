package com.studentAutomation.Businnes;

import java.util.List;

import com.studentAutomation.Entities.Student;

public interface IRoleService {
	public void add();
	public void delete();
	public void update();
	public Student searchByID(int id);
	public List<Student> searchByNo(int no);
	public void getStudentInf(int no);
	public void sleep(int ms);
}
