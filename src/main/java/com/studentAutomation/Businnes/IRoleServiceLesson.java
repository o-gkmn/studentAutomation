package com.studentAutomation.Businnes;

import java.util.List;

import com.studentAutomation.Entities.Lesson;

public interface IRoleServiceLesson {
	public void add(int no);
	public void delete(int no);
	public void update(int no);
	public Lesson searchByID(int id);
	public List<Lesson> searchByNo(int no);
	public String[] addLesson();
	public Integer[][] setExamGrade(String[] lessons);
	public Float[] lessonsAverage(Integer[][] grades, String[] lessons);
	public void createRow(String[] lessons, Integer[][] grades, Float[] averages, int no);
	public void createLesson(int no);
	public void getExamGrade(int no);
	public void sleep(int ms);
}
