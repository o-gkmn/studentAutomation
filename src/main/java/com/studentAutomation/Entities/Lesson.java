package com.studentAutomation.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "lesson")
public class Lesson {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	@Column(name="studentNo")
	private int studentNo;
	@Column(name="lessonQuiz")
	private int lessonQuiz;
	@Column(name="lessonMidTerm")
	private int lessonMidTerm;
	@Column(name="lessonFinal")
	private int lessonFinal;
	@Column(name= "lessonAverages")
	private float lessonAverages;
	@Column(name="lessonName")
	private String lessonName;
	
	
	public Lesson(int studentNo, int lessonQuiz, int lessonMidTerm, int lessonFinal, float lessonAverages, String lessonName) {
		this.studentNo = studentNo;
		this.lessonQuiz = lessonQuiz;
		this.lessonMidTerm = lessonMidTerm;
		this.lessonFinal = lessonFinal;
		this.lessonAverages = lessonAverages;
		this.lessonName = lessonName;
	}
	
	public Lesson() {
		
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
	public int getLessonQuiz() {
		return lessonQuiz;
	}
	public void setLessonQuiz(int lessonQuiz) {
		this.lessonQuiz = lessonQuiz;
	}
	public int getLessonMidTerm() {
		return lessonMidTerm;
	}
	public void setLessonMidTerm(int lessonMidTerm) {
		this.lessonMidTerm = lessonMidTerm;
	}
	public int getLessonFinal() {
		return lessonFinal;
	}
	public void setLessonFinal(int lessonFinal) {
		this.lessonFinal = lessonFinal;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public float getLessonAverages() {
		return lessonAverages;
	}
	public void setLessonAverages(float lessonAverages) {
		this.lessonAverages = lessonAverages;
	}
}
