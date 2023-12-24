package taskp;


import java.io.*;
import java.util.Scanner;

//class is for login related methods
public class Login{ 
	
	
//method is for checking username and password input

	public boolean studentlogin(String a, String b) {
		CredentialArrayM cam = new CredentialArrayM(); 
		int i = 0; 
		String t = "enrollee";
		String c = t;
		
		while(true) {
		//object for path 
		File file = new File("src\\taskp\\" + c + ".txt");
		
		//goes through the enrollee notepad database to see if there is a 
		//match with the user accounts
		if(file.exists()) {
			try {
				String[] Credentialse = cam.Credstud(c);
				if (a.equals(Credentialse[11]) && b.equals(Credentialse[12])) { 
					return true;
				}
			}
			catch (Exception e) {
			}
		//if credentials dont match one user, moves to another user
		//done by combining enrollee with the a number
		//file name format is enrollee[number]
		    i++;
		    c = t+i;
		} else {
			System.out.println("Invalid username or password");
		    return false;
			}
		}
	}
	
	//same method as above, but different return type
	//used in enrollee
	public String studentloginstring(String a, String b) { 
		CredentialArrayM cam = new CredentialArrayM(); 
		int i = 0; 
		String t = "enrollee";
		String c = t;
		
		while(true) {
		File file = new File("src\\taskp\\"+ c + ".txt");
		if(file.exists()) {
			try {
				String[] Credentialse = cam.Credstud(c);
				if (a.equals(Credentialse[11]) && b.equals(Credentialse[12])) { 
					return c;
				}
			}
			
			catch (Exception e) {
				System.out.println("ERROR!");
			}
		    i++;
		    c = t+i;
		} else {
			System.out.println("Invalid username or password");
		    return null;
			}
		}
	}
	
	
//method is for logging in user
    public void login() {
    	//objects to use in class
    	Login lo = new Login();
    	Enrollee en = new Enrollee();
    	AdminUser ad = new AdminUser();
    	CredentialArrayM cam = new CredentialArrayM();    	
        Scanner scanner = new Scanner(System.in); 
        String[] Credentials = cam.Credadm(); 
        
        System.out.print("Please enter username:");
        String username = scanner.nextLine();        
        System.out.print("Please enter password:");
        String password = scanner.nextLine();
        
        
        //compares credentials to accounts saved
        //admin is in another file separate from enrollees
        //enrollee call studentlogin method 
        if (password.equals(Credentials[1]) && username.equals(Credentials[0])) { 
        	System.out.println("______________________________________________________________________________________________________________");
			System.out.print("\n \t \t \t Administrator user successfully logged in!");	
			ad.admin();
		}else if ( lo.studentlogin(username, password) == true){
			System.out.println("______________________________________________________________________________________________________________");
			System.out.println("\n \t \t Enrollee successfully logged in!");	
			en.enrollee(username, password);
			
		} 

        
        Main.main(null);//put a sign out option before here later        
        
    }
}