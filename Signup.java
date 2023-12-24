package taskp;

import java.util.*;    							 
import java.nio.file.*;							  
import static java.nio.file.StandardOpenOption.*; 
import java.io.*; 	

public class Signup {
	
	
	//checks if same name file already exists
	//if exists create a new file with other name (ex enrolle exists, create enrolle2 file)
	public String checkFile()  {
		int i = 0; 
		String t = "enrollee";
		String c = t;
		
		
		while(true) {
		File file = new File("src\\taskp\\"+ c + ".txt");
		
		//if file exists create new file with different name
		if(file.exists()) {
		    i++;
		    c = t+i;
		} else {
		    return c;
		}
	}
}
	//Polymorphism
	//
	public String checkFile(int a)  {
		String t = "enrollee";
		String x = "\nFile does not exist";
		String c = t + (a-1);
		
		
		while(true) {
		File file = new File("src\\taskp\\"+ c + ".txt");
		
		//if file exists create new file with different name
		if(file.exists()) {
			return c;
		}else if (c.equalsIgnoreCase("enrollee0")){
			return t;
		}else {
			System.out.println(x);
		    return x;
		}
	}
}
	
	public void signUp(String[] sinfo, String path) {
		try {
		
		//objects needed to write in text
		Path txtp = 						
		Paths.get("src\\taskp\\" + path + ".txt");
		OutputStream output = new
		BufferedOutputStream(Files.newOutputStream(txtp, WRITE, TRUNCATE_EXISTING)); 
		BufferedWriter writer = new 
		BufferedWriter(new OutputStreamWriter(output));
		
		
		//write student information in text
		//use for loop to iterate every element in array
		for (String i : sinfo) {
			writer.write(i + "" + "\n");
		}
		writer.close();
		}
		catch (Exception e) {
			
		}
	}
	
	//polymorphism
	public void signUp(String[] ininfo) {
		Signup sn = new Signup();
		String pass;
		String user;
		Scanner in = new Scanner(System.in);
		try {
		
		//objects needed to write in text
		Path txtp = 						
		Paths.get("src\\taskp\\" + sn.checkFile() + ".txt");
		OutputStream output = new
		BufferedOutputStream(Files.newOutputStream(txtp, CREATE)); 
		BufferedWriter writer = new 
		BufferedWriter(new OutputStreamWriter(output));
		
		
		//write student information in text
		//use for loop to iterate every element in array
		for (String i : ininfo) {
			writer.write(i + "" + "\n");
		}
		
		//makes username and writes to text file
		user = sn.userMaker(ininfo, sn.checkFile());
		writer.write(user + "");
		
		//makes user enter desire password
		System.out.print("Enter desired password:");
		pass = in.nextLine();
		writer.write("\n" + pass);
		writer.write("\ne");
		writer.close();
		
		//display credentials
		System.out.println("Your credentials are \nUsername: "
				+ user + "\nPassword: " + pass);
		
		}
		catch (Exception e) {
			
		}
}
	
	
	//this method is for making the username
	public String userMaker(String[] info, String fin) {	
		String lasn = fin.substring(fin.length() - 1);
		
		//this loop makes the number pattern of the username (0000)
		for (int i = 0 ; i < 6 - lasn.length() ; i++) {
			lasn = "0" + lasn;
		}
		
		//combines the pattern with the enrollee creation order 
		//enrollee2 + 0000 = 0002
		lasn = info[0] + "-" + lasn;
		return lasn;
	}
	
	
}

