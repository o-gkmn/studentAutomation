package com.studentAutomation.DataAcces;

import java.util.List;

import com.studentAutomation.Entities.Student;

public interface IDataAcces {
	public void add(Student entities);
	public void delete(Student entities);
	public void update(Student entities);
	public Student searchByID(int id);
	public List<Student> searchByNo(int no);
}
