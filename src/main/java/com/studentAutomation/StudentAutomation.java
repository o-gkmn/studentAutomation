package com.studentAutomation;

import java.util.Scanner;

import com.studentAutomation.Businnes.IRoleService;
import com.studentAutomation.Businnes.IRoleServiceLesson;
import com.studentAutomation.Businnes.LessonManager;
import com.studentAutomation.Businnes.StudentManager;
import com.studentAutomation.DataAcces.LessonDal;
import com.studentAutomation.DataAcces.StudentDal;

public class StudentAutomation {
	IRoleService studentManager;
	IRoleServiceLesson lessonManager;
	Scanner scanner;
	private int no;
	private int type;
	
	public StudentAutomation(int no, int type) {
		this.no = no;
		this.type = type;
	}
	
	public void run() {
		if(type == 0) {
			this.runNormal();
		}else if(type == 1) {
			this.runAdmin();
		}
	}
	
	public void runAdmin() {
		this.clean();
		scanner = new Scanner(System.in);
		System.out.printf("%20s%s", "","ÖĞRENCİ OTOMASYON SİSTEMİ\n\n");
		System.out.printf("%5s%s", "", "Yapmak İstediğiniz işlemi numaraları kullanarak seçiniz\n\n");
		System.out.printf("%20s%s", "", "1-) ÖĞRENCİ EKLE\n");
		System.out.printf("%20s%s", "", "2-) ÖĞRENCİ SİL\n");
		System.out.printf("%20s%s", "", "3-) ÖĞRENCİ BİLGİSİ GÜNCELLE\n");
		System.out.printf("%20s%s", "", "4-) DERS EKLE\n");
		System.out.printf("%20s%s", "", "5-) DERS SİL\n");
		System.out.printf("%20s%s", "", "6-) DERS BİLGİSİ GÜNCELLE\n");
		System.out.printf("%20s%s", "", "7-) ÖĞRENCİ NOTLARI GÖRÜNTÜLE\n");
		System.out.printf("%20s%s", "", "8-) ÖĞRENCİ BİLGİLERİ GÖRÜNTÜLE\n");
		System.out.printf("%20s%s", "", "9-) ÇIKIŞ\n");
		System.out.printf("%5s%s", "", "Lütfen seçiminizi giriniz\n\n");
		int selection = scanner.nextInt();
		this.selectAdmin(selection);
	}
	public void runNormal() {
		scanner = new Scanner(System.in);
		System.out.printf("%20s%s", "", "1-) DERS EKLE\n");
		System.out.printf("%20s%s", "", "2-) DERS SİL\n");
		System.out.printf("%20s%s", "", "3-) DERS BİLGİSİ GÜNCELLE\n");
		System.out.printf("%20s%s", "", "4-) ÖĞRENCİ NOTLARI GÖRÜNTÜLE\n");
		System.out.printf("%20s%s", "", "5-) ÖĞRENCİ BİLGİLERİ GÖRÜNTÜLE\n");
		System.out.printf("%20s%s", "", "6-) ÇIKIŞ\n");
		System.out.printf("%5s%s", "", "Lütfen seçiminizi giriniz\n\n");
		int selection = scanner.nextInt();
		this.selectNormal(selection);		
	}
	public void selectAdmin(int selection) {
		studentManager = new StudentManager(new StudentDal());
		lessonManager = new LessonManager(new LessonDal());
		this.clean();
		switch(selection) {
		case 1:
			this.clean();
			studentManager.add();
			this.clean();
			this.run();
			break;
		case 2:
			this.clean();
			studentManager.delete();
			this.clean();
			this.run();
			break;
		case 3:
			this.clean();
			studentManager.update();
			this.clean();
			this.run();
			break;
		case 4:
			this.clean();
			lessonManager.add(no);
			this.clean();
			this.run();
			break;
		case 5:
			this.clean();
			lessonManager.delete(no);
			this.clean();
			this.run();
			break;
		case 6:
			this.clean();
			lessonManager.update(no);
			this.clean();
			this.run();
			break;
		case 7:
			this.clean();
			lessonManager.getExamGrade(no);
			this.clean();
			this.run();
			break;
		case 8:
			this.clean();
			studentManager.getStudentInf(no);
			this.clean();
			this.run();
			break;
		case 9:
			System.exit(0);
			break;
		default:
			System.out.println("HATALI SEÇİM YAPTINIZ  LÜTFEN TEKRAR DENEYİN");
			System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ");
			this.sleep(3000);
			this.clean();
			this.run();
		}
	}
	
	public void selectNormal(int selection) {
		studentManager = new StudentManager(new StudentDal());
		lessonManager = new LessonManager(new LessonDal());
		this.clean();
		switch(selection) {
			case 1:
				this.clean();
				lessonManager.add(no);
				this.clean();
				this.run();
				break;
			case 2:
				this.clean();
				lessonManager.delete(no);
				this.clean();
				this.run();
				break;
			case 3:
				this.clean();
				lessonManager.update(no);
				this.clean();
				this.run();
				break;
			case 4:
				this.clean();
				lessonManager.getExamGrade(no);
				this.clean();
				this.run();
				break;
			case 5:
				this.clean();
				studentManager.getStudentInf(no);
				this.clean();
				this.run();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("HATALI SEÇİM YAPTINIZ  LÜTFEN TEKRAR DENEYİN");
				System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ");
				this.sleep(3000);
				this.clean();
				this.run();
		}
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
