package taskp;
import java.util.*;

//this class is for input validation
class ErrorCheck {								  
	public boolean schec(String s ) {
		return s.matches("Male|Female");
	}
	
	public boolean schec2(String bday) {
		return bday.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9]");
	}
	
	public boolean schec3(String num) {
		return num.matches("[0-9][0-9][0-9][0-9]");
	}
	
	public boolean schec4(String course) {
		 return course.matches("[1-7]");   
	}
	
	//used in enrollment
	public void loopCh(String[] sinfo, String[] ininfo) {
	Scanner in = new Scanner(System.in);
	ErrorCheck let = new ErrorCheck();
	for ( int i = 0 ; i < sinfo.length-1 ; i ++) {
    	System.out.print(sinfo[i] + ":"); 		
    	ininfo[i] = in.nextLine(); 
    	
    	//input validation
    	if (i == 4 ) {
    		if (let.schec2(ininfo[i]) == false) {
    			i--;
    			System.out.println("Invalid Input");
    		}
    	} else if(i==7) {
    		if (let.schec(ininfo[i]) == false) {
    			i--;
    			System.out.println("Invalid Input");
    		}
    	} else if (i == 8) {
    		if (let.schec3(ininfo[i]) == false) {
    			i--;
        		System.out.println("Invalid Input");

    		}
    	}
    }
	}
}

