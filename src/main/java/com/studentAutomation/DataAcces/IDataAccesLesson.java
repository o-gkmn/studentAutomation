package com.studentAutomation.DataAcces;

import java.util.List;

import com.studentAutomation.Entities.Lesson;

public interface IDataAccesLesson {
	public void add(Lesson entities);
	public void delete(Lesson entities);
	public void update(Lesson entities);
	public Lesson searchByID(int id);
	public List<Lesson> searchByNo(int no);
}
