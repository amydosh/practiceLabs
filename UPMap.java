package collections.map;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.TreeMap;


public class UPMap {
		static boolean until = true;
		// TODO: Write a program for username(key) & password(value)
		// Initialize the map:
		static TreeMap<String, String> userDB = new TreeMap<String, String>();


		static Scanner enterUN = new Scanner(System.in);
		static Scanner enterPW = new Scanner(System.in);
		static Scanner select = new Scanner(System.in);
		static Scanner enterNewUN = new Scanner(System.in);
		static Scanner enterNewPW = new Scanner(System.in);
		
		
		public static void main(String[] args) {
			// Instantiate the main menu
			userDB.put("amydosh","password1");
			userDB.put("kmydosh","password2");
			userDB.put("cwatza","password3");
			userDB.put("jmydosh","password4");


			System.out.println("----------------------------------");
			System.out.println("------------Welcome!!-------------");
			System.out.println("Please select from the following menu options:");
			System.out.println("1. Login");
			System.out.println("2. Change username");
			System.out.println("3. Change password");
			System.out.println("4. View password");
			System.out.println("5. Create a new username");
			int selection = select.nextInt();
			
			if(selection==1) {
				runselect1();
			} else if(selection==2) {
				runselect2();
			}else if(selection==3) {
				runselect3();
			}else if(selection==4) {
				runselect4();
			}else if(selection==5) {
				runselect5();
			}else {
				System.out.println("You did not enter a valid selection.");
			}
				
				

		}
		
		// -----------------------------------------------------------------------------------------------
		// Query the userDB to verify username
		public static void searchUN(String un) {
			boolean until = true;
			while(until) {
				int match =0;
				if(userDB.containsKey(un)) {
					System.out.println("User ID "+un +" has been found.");
					match++;
					until = false;
				}
				if(match==0) {
					System.out.println("User has not been found. Please enter your user ID once again.");
					un = enterUN.next();		
					}	
				}
		}
		
		// -----------------------------------------------------------------------------------------------
		// Search the userDB to verify user password
		public static void searchPW(String un, String pw) {
			boolean until2 = true;
			int match2 =0;
			// The below line was utilized to verify the userDB map was correctly passed to this method
//			System.out.println(userDB);
			while(until2) {
				if(userDB.get(un).equals(pw)) {
					System.out.println("Your password has been validated.");
					match2++;
					until2 = false;
				}
				if(match2==0) {
					System.out.println("Password is not correct, please enter password again.");
					pw = enterPW.next();	
				}	
			
			}
		}
		
		
		
		// -----------------------------------------------------------------------------------------------
		// Query the userDB to see if the username that is being created already exists
		public static void existUN(String newUser) {
			// Initialize the map:
			boolean until3 = true;
			while(until3) {
				int match3 =0;
				if(userDB.containsKey(newUser)) {
					System.out.println("User ID "+newUser +" already exists. Please enter a different username.");
					newUser = enterUN.next();
					match3++;
					until3 = true;
				}
				if(match3==0) {
					System.out.println("Your username is available.");
					until3 = false;
					}
				
				}

		}
		

		
		
		
		// -----------------------------------------------------------------------------------------------		
// Create methods for user selection options, should this be in it's own class??		
		
		public static void runselect1() {
			// If user selects Option 1 - login, ask for username, validate, ask for password, validate
			System.out.println("----------------------------------");
			System.out.println("Please enter your username: ");
			String un = enterUN.next();
			searchUN(un);
			System.out.println("Please enter your password: ");
			String pw = enterPW.next();
			searchPW(un,pw);
			System.out.println("----------------------------------");
			System.out.println("You are now logged in.");
			System.out.println("----------------------------------");
			
			// Test that the userDB was accessed appropriately
			System.out.println(userDB);
	}
		
		
		public static void runselect2() {
			// Validate username and password first
//			TreeMap<String, String> userDB = new TreeMap<String, String>(userDB);	
			System.out.println("----------------------------------");
			System.out.println("Please enter your username: ");
			String un = enterUN.next();
			searchUN(un);
			System.out.println("Please enter your password: ");
			String pw = enterPW.next();
			searchPW(un,pw);
			System.out.println("----------------------------------");
			System.out.println("You have selected option 2.");
			System.out.println("----------------------------------");
			System.out.println("Please enter the new username.");
			String unNew = enterNewUN.next();
			userDB.put(unNew,pw);
			// Delete the existing entry (key)
			userDB.remove(un);
			System.out.println("Your username has been successfully changed.");
			
			// Test that the userDB was accessed appropriately
			System.out.println(userDB);
		}
		
		
		public static void runselect3() {
			// Validate username and password first
//			TreeMap<String, String> userDB = new TreeMap<String, String>(userDB);	
			System.out.println("----------------------------------");
			System.out.println("Please enter your username: ");
			String un = enterUN.next();
			searchUN(un);
			System.out.println("Please enter your password: ");
			String pw = enterPW.next();
			searchPW(un,pw);
			System.out.println("----------------------------------");
			System.out.println("You have selected option 3.");
			System.out.println("----------------------------------");
			System.out.println("Please enter the new password.");
			String pwNew = enterNewPW.next();
			userDB.put(un,pwNew);
			System.out.println("Your password has been successfully changed.");
			
			// The line below prints out the new password to verify it was successfully changed
			System.out.println(userDB.get(un));
		}
		
		
		public static void runselect4() {
			// Validate username and password first
			System.out.println("----------------------------------");
			System.out.println("Please enter your username: ");
			String un = enterUN.next();
			searchUN(un);
			System.out.println("Please enter your password: ");
			String pw = enterPW.next();
			searchPW(un,pw);
			System.out.println("----------------------------------");
			System.out.println("You have selected option 4.");
			System.out.println("----------------------------------");
		}
		
		public static void runselect5() {
			// Validate username and password first
			System.out.println("You have selected option 5.");
			System.out.println("----------------------------------");
			System.out.println("----------------------------------");
			System.out.println("Please enter your desired username: ");
			String newUser = enterUN.next();
			
			// Verify there isn't already an existing user with that username
			existUN(newUser);
			
			// Collect password for new username
			System.out.println("Please enter your desired password: ");
			String newPassword = enterPW.next();
			System.out.println("----------------------------------");
			// --> FOR SOME REASON THIS IS ONLY CHANGING THE PASSWORD AND NOT CREATING A NEW ENTRY
			userDB.put(newUser, newPassword);
			System.out.println(userDB);
			
			

		}

}
		
		
		// Then WAP to allow login and registration by taking user input:
		// 1. Determine if the username is within the map
		// 2. Determine if the password matches the the value at that key
		

