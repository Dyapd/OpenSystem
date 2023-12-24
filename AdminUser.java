package taskp;

import java.util.*;    							 
import java.nio.file.*;							  
import static java.nio.file.StandardOpenOption.*; 
import java.io.*; 	

//Inheritance
//uses variables from enrollment
public class AdminUser extends Enrollment   {
	//formatting admin display of student information
	private String[] adminArrayFormat = {
			"Surname","First Name","Middle Name","Birth Place","Birthday",
			"Permanent Address","City","Sex","Postal Code","Payment Type",
			"Course", "Username", "Password", "Enrollment Status"
	};
	
	
	public void admin() {
		
	CredentialArrayM cam = new CredentialArrayM(); 
	AdminUser adm = new AdminUser();
	Scanner in = new Scanner(System.in);
	Signup sig = new Signup();
	ErrorCheck let = new ErrorCheck();
	
	int adin;
	String adins;
	String sels;
	String [] sinfoe; 
	
	
	System.out.println("\n\t \t \t \t Welcome admin user!");
	System.out.println("______________________________________________________________________________________________________________");
	
	
	while (true) {	
	try {
	System.out.println("Student Enrollees:\n");
	//display enrollee files
	adm.adminLoopEnrollees();
	
	//put number to method
	//method checks if file assosciated with number exists
	//if not, returns file does not exists then loops
	System.out.print("Enter number to select student\nEnter 0 to exit:");
	adin = in.nextInt();
	if (adin == 0) {
		break;
	}
	sels = sig.checkFile(adin);
	sinfoe = cam.Credstud(sels);
	
	
	//this is for displaying selected enrollee student information
	System.out.println("______________________________________________________________________________________________________________");
	System.out.println("\t\t\tCourse: " + adm.courset(sinfoe[10]));
	for ( int j = 0 ; j < adminArrayFormat.length ; j ++) {
		if (j == 13) {
	    	   System.out.println(adm.adminArrayFormat[j]  + "\n"
	    	   		+ "(e is not enrolled):" + sinfoe[j]);
	    	   break;
	      }
		else if (j == 10) {
			 System.out.println(adm.adminArrayFormat[j] + ":"+ sinfoe[j] + "/" + adm.courset(sinfoe[10]));
			 
		}
		else {
			System.out.println(adm.adminArrayFormat[j]  + ":" + sinfoe[j]); 	
		}
      } 
	
	//display after student information is shown
	System.out.println("______________________________________________________________________________________________________________");
	System.out.println("Enter E to edit information\nEnter B to go back to student files\nPress X to exit:");
	adins = in.nextLine();
	adins = in.nextLine();
	
	//edits student information
	if (adins.equalsIgnoreCase("E")) {
		for (int m = 0 ; m < adminArrayFormat.length ; m ++) {
			
			//if at index 10 of array then do this code
			//it displays all courses
			if (m == 10) {
			System.out.println("Edit " + adminArrayFormat[m] + ":"  + sinfoe[m]	+ "?\nCourses:");
			adm.displaycourses(courses);
			System.out.println("(Y/N)?");
			}
			else {
			System.out.println("Edit " + adminArrayFormat[m] + ":"  + sinfoe[m] + "\n"
					+ "(Y/N)?");
			}
			
			String inp = in.nextLine();
			
			//if at index 10 and input is not in choices
			//reverts loop one iteration
			if ((inp.equalsIgnoreCase("y")) && m == 10) {	
				while(true) {
				System.out.print("Enter replacement:");
				String sinfoe1 = in.nextLine();
				 if (let.schec4(sinfoe1) != true) {
				 System.out.println("Invalid choice");
				 continue;
				 	}
				 else {
				 sinfoe[m] = sinfoe1;
				 break;
				 }
				}
			}else if (inp.equalsIgnoreCase("n")) {	
			}else if(inp.equalsIgnoreCase("y")) {
					System.out.print("Enter replacement:");
					sinfoe[m] = in.nextLine();
					System.out.println(sinfoe[m]);
			}else {
				System.out.println("Invalid choice.");
				}
			
			}
		//writes the edited information to student database
		sig.signUp(sinfoe, sels);
	//goes back to student list
	} else if (adins.equalsIgnoreCase("B")) {
		continue;
	}
	}catch (Exception e) {
		
		in.nextLine();
		continue;
			}
		}
	}
	
	//this method displays the list of enrollees
	public void adminLoopEnrollees() {
		CredentialArrayM cam = new CredentialArrayM();
		String t = "enrollee";
		int d = -1;
		int i = 0; 
		String c = t;
		
		while(d<i) {
			File file = new File("src\\taskp\\"+ c + ".txt");
			if(file.exists()) {
				
				for ( int j = 0 ; j < 1 ; j ++) {
					String [] stinfo = cam.Credstud(c);
	            	System.out.println("Enrollee File"+ "[" + (i+1) + "]" + ":"+ stinfo[j]); 		
	            } 
				
			    i++;
			    c = t+i;
			    System.out.println("");
			}
			d++;
		}
	}
	}
