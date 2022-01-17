package com.studentAutomation.Businnes;


import java.util.List;
import java.util.Scanner;

import com.studentAutomation.DataAcces.IDataAcces;
import com.studentAutomation.Entities.Student;

public class StudentManager implements IRoleService {
	private IDataAcces dataAcces;
	private Scanner scanner;
	
	public StudentManager(IDataAcces dataAcces) {
		this.dataAcces = dataAcces;
	}

	public void add() {
		scanner = new Scanner(System.in);
		System.out.print("Öğrencinin ismini giriniz : ");
		String name = scanner.nextLine();
		System.out.print("Öğrencinin soyismini giriniz : ");
		String surname = scanner.nextLine();
		System.out.print("Öğrencinin doğum tarihini DD.MM.YYYY olacak şekilde giriniz : ");
		String birthday = scanner.nextLine();
		System.out.print("Öğrencinin yaşını giriniz : ");
		int age = scanner.nextInt();
		System.out.print("Öğrencinin telefon numarasını giriniz : ");
		scanner.nextLine();
		String phone = scanner.nextLine();
		System.out.print("Öğrencinin emailini giriniz : ");
		String email = scanner.nextLine();
		System.out.print("Öğrencinin numarasını giriniz : ");
		int no = scanner.nextInt();
		System.out.print("Öğrencinin okduğu fakülteyi giriniz : ");
		scanner.nextLine();
		String faculty = scanner.nextLine();
		System.out.print("Öğrencinin okuduğu bölümü giriniz : ");
		String department = scanner.nextLine();
		System.out.print("Öğrencinin sınıfını giriniz : ");
		int s_class = scanner.nextInt();
		System.out.print("Öğrencinin adresini giriniz : ");
		scanner.nextLine();
		String address = scanner.nextLine();
		System.out.print("Öğrencinin şifresini giriniz : ");
		String password = scanner.nextLine();
		System.out.print("Öğrencinin tipini seçiniz : \n");
		System.out.print("1-) Yönetici\n");
		System.out.print("2-) Normal\n");
		System.out.print("Seçiminiz : ");
		int choose = scanner.nextInt();
		String type = "";
		if(choose == 1) {
			type = "yönetici";
		}else if(choose == 2) {
			type = "normal";
		}else {
			System.out.println("Hatalı giriş yaptınız lütfen tekrar deneyin...");
			this.clean();
			this.add();
		}
		
		Student student = new Student(no,age,s_class,name,surname,birthday,phone,email,department,faculty,address,password,type);
		this.dataAcces.add(student);
		this.clean();
		System.out.println("ÖĞRENCİ BAŞARILI BİR ŞEKİLDE EKLENDİ");
		System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
		this.sleep(3000);
	}

	public void delete() {
		scanner = new Scanner(System.in);
		System.out.println("Silmek istediğiniz öğrencinin numarasını giriniz.");
		int no = scanner.nextInt();
		List<Student> students = this.searchByNo(no);
		if(!students.isEmpty()) {
			for(int i = 0; i<students.size(); ++i) {
				System.out.println(i+1 + "-) " + students.get(i).getStudentName() + " " + students.get(i).getStudentSurname());
			}
			System.out.println("Silmek istediğiniz öğrenciyi sayıları kullanarak seçiniz");
			int secim = scanner.nextInt();
			this.dataAcces.delete(students.get(secim-1));
			this.clean();
			System.out.println("ÖĞRENCİ BAŞARILI BİR ŞEKİLDE SİLİNDİ");
			System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
			this.sleep(3000);
		}
		else {
			System.out.println("ÖĞRENCİ BULUNAMADI");
			System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
			this.sleep(3000);
		}
	}

	public void update() {
		scanner = new Scanner(System.in);
		System.out.println("Güncellemek istediğiniz öğrencinin numarasını giriniz.");
		int no = scanner.nextInt();
		List<Student> students = this.searchByNo(no);
		if(!students.isEmpty()) {
			for(int i = 0; i<students.size(); ++i) {
				System.out.println(i+1 + "-) " + students.get(i).getStudentName() + " " + students.get(i).getStudentSurname());
			}
			System.out.println("Güncellemek istediğiniz öğrencinin numarasını giriniz");
			int secim = scanner.nextInt();
			System.out.print("Öğrencinin ismini giriniz : ");
			scanner.nextLine();
			String name = scanner.nextLine();
			students.get(secim-1).setStudentName(name);
			System.out.print("Öğrencinin soyismini giriniz : ");
			String surname = scanner.nextLine();
			students.get(secim-1).setStudentSurname(surname);
			System.out.print("Öğrencinin doğum tarihini DD.MM.YYYY olacak şekilde giriniz : ");
			String birthday = scanner.nextLine();
			students.get(secim-1).setStudentBirthday(birthday);
			System.out.print("Öğrencinin yaşını giriniz : ");
			int age = scanner.nextInt();
			students.get(secim-1).setStudentAge(age);
			System.out.print("Öğrencinin telefon numarasını giriniz : ");
			scanner.nextLine();
			String phone = scanner.nextLine();
			students.get(secim-1).setStudentPhone(phone);
			System.out.print("Öğrencinin emailini giriniz : ");
			String email = scanner.nextLine();
			students.get(secim-1).setStudentEmail(email);
			System.out.print("Öğrencinin numarasını giriniz : ");
			int num = scanner.nextInt();
			students.get(secim-1).setStudentNo(num);
			System.out.print("Öğrencinin okduğu fakülteyi giriniz : ");
			scanner.nextLine();
			String faculty = scanner.nextLine();
			students.get(secim-1).setStudentFaculty(faculty);
			System.out.print("Öğrencinin okuduğu bölümü giriniz : ");
			String department = scanner.nextLine();
			students.get(secim-1).setStudentDepartment(department);
			System.out.print("Öğrencinin sınıfını giriniz : ");
			int s_class = scanner.nextInt();
			students.get(secim-1).setStudentClass(s_class);
			System.out.print("Öğrencinin adresini giriniz : ");
			scanner.nextLine();
			String address = scanner.nextLine();
			students.get(secim-1).setStudentAddress(address);
			System.out.print("Öğrencinin şifresini giriniz : ");
			String password = scanner.nextLine();
			students.get(secim-1).setStudentPassword(password);
			System.out.print("Öğrencinin tipini seçiniz : \n");
			System.out.print("1-) Yönetici\n");
			System.out.print("2-) Normal\n");
			System.out.print("Seçiminiz : ");
			int choose = scanner.nextInt();
			String type = "";
			if(choose == 1) {
				type = "yönetici";
				students.get(secim-1).setStudentType(type);
			}else if(choose == 2) {
				type = "normal";
				students.get(secim-1).setStudentType(type);
			}else {
				System.out.println("Hatalı giriş yaptınız lütfen tekrar deneyin...");
				this.clean();
				this.update();
			}
			this.dataAcces.update(students.get(secim-1));
			this.clean();
			System.out.println("ÖĞRENCİ BAŞARILI BİR ŞEKİLDE GÜNCELLENDİ");
			System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
			this.sleep(3000);
		}
		else {
			System.out.println("ÖĞRENCİ GÜNCELLENEMEDİ");
			System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
			this.sleep(3000);
		}		
	}

	public void getStudentInf(int no) {
		scanner = new Scanner(System.in);
		List<Student> students = this.searchByNo(no);
		this.clean();
		if(!students.isEmpty()) {
			for(int i = 0; i<students.size(); ++i) {
				System.out.println(i+1 + "-)" + students.get(i).getStudentName() + " " + students.get(i).getStudentSurname());
			}
			System.out.println("Bilgilerini görüntülemek istediğiniz öğrencinin numarasını giriniz");
			int selection = scanner.nextInt();
			System.out.println(
					"--------" + students.get(selection-1).getStudentName() + " " +  students.get(selection-1).getStudentSurname() + " isimli öğrencinin özlük bilgileri --------");
			System.out.println("İsim : " + students.get(selection-1).getStudentName());
			System.out.println("Soyisim : " + students.get(selection-1).getStudentSurname());
			System.out.println("Doğum Tarihi : " + students.get(selection-1).getStudentBirthday());
			System.out.println("Yaş : " + students.get(selection-1).getStudentAge());
			System.out.println("Telefon Numarası : " + students.get(selection-1).getStudentPhone());
			System.out.println("Email : " + students.get(selection-1).getStudentEmail());
			System.out.println();
			System.out.println("Öğrenci No : " + students.get(selection-1).getStudentNo());
			System.out.println("Fakülte : " + students.get(selection-1).getStudentFaculty());
			System.out.println("Bölüm : " + students.get(selection-1).getStudentDepartment());
			System.out.println("Sınıf : " + students.get(selection-1).getStudentClass());
			System.out.println("Adres : " + students.get(selection-1).getStudentAddress());
			System.out.println("Tip : " + students.get(selection-1).getStudentType());
			System.out.println("Devam etmek için DEVAM yazıp ENTER tuşuna basın");
			scanner.nextLine();
			System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ");
			this.sleep(3000);
		}
		else {
			System.out.println("ÖĞRENCİ BULUNAMADI");
			System.out.println("ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ...");
			this.sleep(3000);			
		}
	}

	public Student searchByID(int id) {
		return this.dataAcces.searchByID(id);
	}

	public List<Student> searchByNo(int no){
		return this.dataAcces.searchByNo(no);
	}
	
	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
	//TODO genel ortalama hesaplayan bir metot yaz
	//TODO transkript yazdıran bir metot yaz
	
}
