package com.studentAutomation;

import java.util.Scanner;

public class App 
{
	private static Scanner scanner;
	
    public static void main( String[] args )
    {
    	int no;
    	String pass;
    	
    	scanner = new Scanner(System.in);
    	System.out.printf("%20s%s", "","ÖĞRENCİ BİLGİ SİSTEMİ\n\n");	
		System.out.printf("%20s%s", "","ÖĞRENCİ NUMARANIZ: ");
		no = scanner.nextInt();
		System.out.printf("%20s%s", "","ŞİFRENİZ: ");
		scanner.nextLine();
		pass = scanner.nextLine();
    	LoginScreen loginScreen = new LoginScreen(no,pass);

    }
}
