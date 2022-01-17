package com.studentAutomation;

import java.util.List;
import java.util.Scanner;

import com.studentAutomation.Businnes.IRoleService;
import com.studentAutomation.Businnes.StudentManager;
import com.studentAutomation.DataAcces.StudentDal;
import com.studentAutomation.Entities.Student;

public class LoginScreen {
	private IRoleService studentManager;
	private StudentAutomation studentAutomation;
	private Scanner scanner;
	private int no;
	private String pass;
	
	public LoginScreen(int no, String pass) {
		this.no = no;
		this.pass = pass;
		this.check(no,pass);
	}
	
	public void check(int no, String pass) {
		scanner = new Scanner(System.in);
		studentManager = new StudentManager(new StudentDal());
		List<Student> matched = studentManager.searchByNo(no);
		if(matched.isEmpty()) {
			System.out.println("BÖYLE BİR ÖĞRENCİ BULUNAMADI!!");
		}
		else {
			for(int i = 0; i<matched.size(); ++i) {
				System.out.println(i+1 + "-) " + matched.get(i).getStudentName() + " " + matched.get(i).getStudentSurname());
			}
			System.out.println("Hangi öğrenci için işlem yapmak istiyorsunuz. ");
			int choosen = 1;
			choosen = scanner.nextInt();
			String password = matched.get(choosen - 1).getStudentPassword();
			String type = matched.get(choosen -1 ).getStudentType();
			if(password.equals(pass)) {
				int typeInt = 0;
				if(type.equals("yönetici")) {
					typeInt = 1;
				}
				System.out.println("BAŞARIYLA GİRİŞ YAPTINIZ ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
				this.clean();
				studentAutomation = new StudentAutomation(no,typeInt);
				studentAutomation.run();
			}
			else {
				System.out.println("PAROLANIZ EŞLEŞMİYOR");
			}
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

}
