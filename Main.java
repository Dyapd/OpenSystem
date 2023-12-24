package taskp;

import java.util.Scanner;

class Main { //mainmenu

    
	//Abstraction
	//hides what the classes can do ex. log.login() and enr.enroll()
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Enrollment enr = new Enrollment();
        Login log = new Login();
        
        //main menu display
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("\t \t \t Welcome to O.P.En.S.! (Online Platform Enrollment System)");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("Enter L if you want to login.");
        System.out.println("Enter E if you want to enroll.");
        System.out.println("Enter X if you want to exit the program.");
        System.out.println("______________________________________________________________________________________________________________");
        while (true) {
        System.out.print("Please input your choice: ");
        String choice = scanner.nextLine();
        //calls login method
        if (choice.equalsIgnoreCase("L")) {
            log.login();
        //calls enroll method
        } else if (choice.equalsIgnoreCase("E")) {
            enr.enroll();
        //exit program
        } else if (choice.equalsIgnoreCase("X")){
            System.out.println("Exiting program.");
            System.exit(0);
            break;
        } else {
        	System.out.println("Invalid choice. Enter another letter:");
        	}
        }
    }
}