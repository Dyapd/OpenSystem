package taskp;

import java.util.*;
 
//this class is for enrollment purposes
class Enrollment { 

//this array is to be used to prompt and help display student information
	final String[] sinfo = { "Surname","First Name","Middle Name","Birth Place","Birthday (MM/DD/YY)",
		"Permanent Address","City","Sex (Female/Male)","Postal Code", "Payment Type(I/F)"
};
	//array is to help display courses
	final String [] courses = { "BSIT", "BSCS", "BSCPE", "BSBA", 
			"BSA", "BSHM", "BSTM" 
	};
	
	
	
	//method used to enroll students
    public void enroll() { 
    	boolean a = true;
    	ErrorCheck let = new ErrorCheck();
    	Tuitions tui = new Tuitions();
    	Enrollment en = new Enrollment();
    	String course;
    	String coursef;
    	Signup ar = new Signup();
    	String con;
    	Scanner in = new Scanner(System.in);
    	
    	//array is to store student input
    	String [] ininfo = new String[11];
    	System.out.println("______________________________________________________________________________________________________________");
        System.out.println("Thank you for choosing to enroll in STI Caloocan.");           
        System.out.println("These are our available courses:");
        while (a == true) {
        	
        //method that displays courses
        en.displaycourses(courses);
        
        //input goes to courset method that returns course with help of user input
        System.out.println("______________________________________________________________________________________________________________");
        System.out.print("Please enter the number of the chosen course: ");
        course = in.nextLine();
        //input number, return course
        coursef = en.courset(course);
        
        //loops if input is not within choices
        if (let.schec4(course) != true) {
        continue;
        }
        
        
        //loop for confirming input 
        while (true) {
        System.out.print("Confirm? [Y/N]: ");
        con = in.nextLine();        
        System.out.println("______________________________________________________________________________________________________________");
        
        //if input is y then fill out student information
        if (con.equalsIgnoreCase("Y")) {
        	System.out.print("Please fill out the student information form:\n"); 
        //calls method that checks user input
        let.loopCh(sinfo, ininfo);
        
            //stores payment type, taken from tuitions
            System.out.println("______________________________________________________________________________________________________________");
            coursef = tui.tuitions(coursef);
            //store payment type
            ininfo[9] = coursef;
            //store course
            ininfo[10] = course;
         
            //calls signup method which writes array contents to txt file
            ar.signUp(ininfo);
            System.out.println("______________________________________________________________________________________________________________");
            System.out.println("Proceed to login to view balance and to pay.");
            //make a false to not loop anymore and return to main menu
            a = false;
            //break to break the loop
            break;
        }else if (con.equalsIgnoreCase("N")){
        	System.out.println("\nGoing back to course menu.");
        	break;
        }else {
        	System.out.println("Invalid Choice.");
        		}        
        	}        
        }
        //used to go back to main menu
        Main.main(null);
    }
	
	
//returns course for corresponding number input
	public String courset(String a) {
		switch (a) {
		case "1":
			return "BSIT";
		case "2":
			return "BSCS";
		case "3":
			return "BSCPE";
		case "4":
			return "BSBA";
		case "5":
			return "BSA";
		case "6":
			return "BSHM";
		case "7":
			return "BSTM";
		default:
			return null;
		}
	}
	
	public void displaycourses(String[] courses) {
		
	        for (int i = 0 ; i < courses.length ; i++) { 
	        	System.out.println("[" + (i+1) + "]" + courses[i] + " ");
	        }
		}
	
	

}
