package taskp;

import java.util.*;    							 
import java.nio.file.*;							  
import static java.nio.file.StandardOpenOption.*; 
import java.io.*; 

public class Enrollee extends Enrollment {
	
	
	
	//login screen for enrolled
	public void enrollee(String a, String b) { 
		//
		Enrollee enr = new Enrollee();
		Login log = new Login();
		CredentialArrayM cam = new CredentialArrayM(); 
		Scanner in = new Scanner(System.in);
		int up;
		String userc;
		
		userc = log.studentloginstring(a, b);
		String[] Credentials = cam.Credstud(userc); 
		String tg = Credentials[10];
		
		try {
		Path txtp = 						
				Paths.get("src\\taskp\\" + userc + ".txt");
				OutputStream output = new
				BufferedOutputStream(Files.newOutputStream(txtp, WRITE, APPEND)); 
				BufferedWriter writer = new 
				BufferedWriter(new OutputStreamWriter(output));
		
		System.out.println("\t \t \t Welcome enrollee!");
		System.out.println("______________________________________________________________________________________________________________");
		System.out.print("Student Information:\n\n");
		
		//uses loop to display student information
		System.out.println("Course: " + enr.courset(Credentials[10]));
		for ( int i = 0 ; i < 10 ; i ++) {
        	System.out.println(enr.sinfo[i]  + ":" + Credentials[i]); 		 	
        }
			
		//checks if student is already enrolled
		//if not asks to pay enrollment fee
		System.out.println("______________________________________________________________________________________________________________");
		if (Credentials[13].equals("enrolled")){
			System.out.println("\n\t \t \t You are already enrolled!");        
		}else {
		System.out.println("");
		enr.courset(tg);
		System.out.println("Enrollment fee is 500.");
		System.out.println("______________________________________________________________________________________________________________");
		System.out.print("How much would you like to pay: ");
		up = in.nextInt(); 
		
		//if input number is valid, then enroll
		//after write into database that student is enrolled
		//if not display insufficient funds
		if (up >= 500){
			System.out.println("______________________________________________________________________________________________________________");
			System.out.println("\t \t \t \t You are now enrolled!");
			writer.write("nrolled");
			writer.close();
		}else {
			System.out.println("Insufficient Funds.");
			}
		}				
		}catch(Exception e) {
	}
	}
	
	//checks for validity of credentials entered by student
	
}
