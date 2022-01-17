package com.studentAutomation.Businnes;

import java.util.List;
import java.util.Scanner;

import com.studentAutomation.DataAcces.IDataAccesLesson;
import com.studentAutomation.DataAcces.StudentDal;
import com.studentAutomation.Entities.Lesson;
import com.studentAutomation.Entities.Student;

public class LessonManager implements IRoleServiceLesson{
	private IDataAccesLesson dataAcces;
	private Scanner scanner;
	private IRoleService studentManager;
	
	public LessonManager(IDataAccesLesson dataAcces) {
		this.dataAcces = dataAcces;
	}

	public void add(int no) {
		this.createLesson(no);
		System.out.println("DERSLER BAŞARILI BİR ŞEKİLDE EKLENDİ");
		System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
		this.sleep(3000);
	}

	public void delete(int no) {
		scanner = new Scanner(System.in);
		List<Lesson> lessons = this.searchByNo(no);
		if(!lessons.isEmpty()) {
			for(int i = 0; i<lessons.size(); ++i) {
				System.out.println(i+1 + "-)" + lessons.get(i).getLessonName());
			}
			System.out.println("Silmek istediğiniz dersin numarasını giriniz.");
			int selection = scanner.nextInt();
			this.dataAcces.delete(lessons.get(selection-1));
			System.out.println("DERS BAŞARILI BİR ŞEKİLDE SİLİNDİ");
			System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
			this.sleep(3000);
		}
		else {
			System.out.println("DERS BİLGİSİ BULUNAMADI");
			System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
			this.sleep(3000);
		}
	}

	public void update(int no) {
		scanner = new Scanner(System.in);
		List<Lesson> lessons = this.searchByNo(no);
		if(!lessons.isEmpty()) {
			for(int i = 0; i<lessons.size(); ++i) {
				System.out.println(i+1 + "-)" + lessons.get(i).getLessonName());
			}
			System.out.println("Güncellemek istediğiniz dersin numarasını giriniz");
			int selection = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Dersin ismini giriniz");
			String name = scanner.nextLine();
			System.out.println("Quiz notunu giriniz");
			int quiz = scanner.nextInt();
			System.out.println("Vize notunu giriniz");
			int midterm = scanner.nextInt();
			System.out.println("Final notunu giriniz");
			int finalExam = scanner.nextInt();
			float averages = (float) (quiz*0.1 + midterm*0.3 + finalExam*0.6);
			lessons.get(selection-1).setStudentNo(no);
			lessons.get(selection-1).setLessonName(name);
			lessons.get(selection-1).setLessonQuiz(quiz);
			lessons.get(selection-1).setLessonMidTerm(midterm);
			lessons.get(selection-1).setLessonFinal(finalExam);
			lessons.get(selection-1).setLessonAverages(averages);
			this.dataAcces.update(lessons.get(selection-1));
			System.out.println("DERS BAŞARILI BİR ŞEKİLDE GÜNCELLENDİ");
			System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
			this.sleep(3000);
		}
		else {
			System.out.println("DERS BİLGİSİ BULUNAMADI");
			System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
			this.sleep(3000);
		}
	}

	public Lesson searchByID(int id) {
		return this.dataAcces.searchByID(id);
	}

	public List<Lesson> searchByNo(int no){
		return this.dataAcces.searchByNo(no);
	}
	
	public String[] addLesson() {
		scanner = new Scanner(System.in);
		System.out.print("Kaç ders girmek istdeğinizi giriniz : ");
		int lessonCount = scanner.nextInt();
		String[] lessons = new String[lessonCount];
		String lesson = "";
		for(int i = 0; i<lessonCount; ++i) {
			System.out.print(i+1 + ". dersi giriniz : ");
			if(i == 0) scanner.nextLine();
			lesson = scanner.nextLine();
			lessons[i] = lesson;
		}
		System.out.println();
		System.out.println();
		return lessons;
	}
	
	public Integer[][] setExamGrade(String[] lessons) {
		Integer[][] grades = new Integer[lessons.length][3];
		scanner = new Scanner(System.in);
		for(int i = 0; i<lessons.length; ++i) {
			System.out.println(lessons[i] + " dersinin --->");
			System.out.print("Quiz notu : ");
			grades[i][0] = scanner.nextInt();
			System.out.print("Vize notu : ");
			grades[i][1] = scanner.nextInt();
			System.out.print("Final notu : ");
			grades[i][2] = scanner.nextInt();
			System.out.println();
		}
		System.out.println();
		System.out.println();
		return grades;
	}
	
	public Float[] lessonsAverage(Integer[][] grades, String[] lessons) {
		Float[] averages = new Float[grades.length];
		for(int i = 0; i<grades.length; ++i) {
			averages[i] = (float)(grades[i][0]*0.1) + (float)(grades[i][1]*0.3) + (float)(grades[i][2]*0.6);
		}
		for(int j = 0; j<grades.length; ++j) {
			System.out.println(lessons[j] + " dersinin ortalaması " + averages[j]);
		}
		System.out.println();
		System.out.println();
		return averages;
	}
	
	public void createRow(String[] lessons, Integer[][] grades, Float[] averages, int no) {
		for(int i = 0; i<lessons.length; ++i) {
			Lesson lesson = new Lesson(no, grades[i][0], grades[i][1], grades[i][2], averages[i], lessons[i]);
			this.dataAcces.add(lesson);
		}
	}
	
	public void createLesson(int no) {
		String[] lessons = this.addLesson();
		Integer[][] grades = this.setExamGrade(lessons);
		Float[] averages = this.lessonsAverage(grades, lessons);
		this.createRow(lessons, grades, averages, no);
	}

	public void getExamGrade(int no) {
		scanner = new Scanner(System.in);
		studentManager = new StudentManager(new StudentDal());
		List<Lesson> grades = this.searchByNo(no);
		List<Student> students = studentManager.searchByNo(no);
		this.clean();
		System.out.println(no + " numaralı " + students.get(0).getStudentName() + " " + students.get(0).getStudentSurname() +  " isimli öğrencinin Quiz/Vize/Final notları --->");		
		for(int i = 0; i<grades.size(); ++i) {
			System.out.println(grades.get(i).getLessonName() + " dersinin notları --->"); 
			System.out.println("Quiz : " + grades.get(i).getLessonQuiz());
			System.out.println("Vize : " + grades.get(i).getLessonMidTerm());
			System.out.println("Final : " + grades.get(i).getLessonFinal());
			System.out.println("Ortalama : " + grades.get(i).getLessonAverages());
			System.out.println();
			System.out.println();
		}
		System.out.println("Devam etmek için devam yazıp ENTER tuşana basın...");
		scanner.next();
		System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
		this.sleep(3000);
	}
	
	public void clean(){
        try{
            String operatingSystem = System.getProperty("os.name");//Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
	}
	
	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
