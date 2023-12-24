package taskp;

import java.io.*;
import java.util.*;

//this class is for putting database elements into array
class CredentialArrayM{				
	
	
	//takes string array document
	//return data of from file in array
	public String[] Credadm() {			
		try {						
		FileReader r = new 				
		FileReader("records.txt");
		BufferedReader reader = new		
		BufferedReader(r);
		
		String elm ;				
		List<String> line = new ArrayList<String>(); 
		while ((elm = reader.readLine()) != null) { 
			line.add(elm);				
		}
		reader.close();					
		String[] userData = line.toArray(new String[] {}); 
		return userData;				
		
	}catch (Exception e) {
		
	}return null;						
	}
	
	//takes string array argument
	//argument is name of file
	//return data from file in array
	public String[] Credstud(String a) {
		try {						
			FileReader r = new 				
			FileReader("src\\taskp\\" + a + ".txt");
			BufferedReader reader = new		
			BufferedReader(r);
			
			String elm ;				
			List<String> line = new ArrayList<String>(); 
			while ((elm = reader.readLine()) != null) { 
				line.add(elm);				
			}
			reader.close();					
			String[] userData = line.toArray(new String[] {}); 
			return userData;				
			
		}catch (Exception e) { 				
			
		}return null;						
		}
	
}