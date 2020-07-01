package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegistrationValidation{
	
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		if(validPassword(password,confirmPassword)&& validEmail(email)) {
			return true;
		}
		else {
			return false;
		}
	}
	private boolean validPassword(String password, String confirmPassword) {
	
	   String regex = "^(?=.*[0-9])" + "(?=.[a-z])(?=.[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$"; 
		        Pattern p = Pattern.compile(regex); 
		  
		        if (password == null) { 
		            return false; 
		        } 
		        
		        else if (password.length() < 8 && password.length()> 20) {
		   	     System.out.println("Password must be at least 8 characters");
		   	        return false; 
		   		}
		        
		   		else if(password!=confirmPassword) {
		   			System.out.println("Password and ConfirmPassword are not same");
		   			return false;
		   		}
		 
		        Matcher m = p.matcher(password);  
		        return m.matches(); 
	}
	
	private boolean validEmail(String email) {
		  String email1 = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&-]+)@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" +  "A-Z]{2,7}$";              
              Pattern pat = Pattern.compile(email1); 
             if (email == null) {
                   return false; 
             }
             return true;
	 }
}