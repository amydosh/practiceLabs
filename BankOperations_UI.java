package com.simplilearn.collections.multithreading.ex;

import java.util.Scanner;

class Client {
	double balance = 0;
	
	synchronized void deposit(double amount) {
		try {
			balance += amount;
			System.out.println("You have successfully made a deposit.");
			System.out.println("Your new balance is: "+amount);
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized void withdraw(double amount) {
		balance -= amount;
		boolean active = true;
		boolean retMenu = true;
		while(active) {
		if(amount < balance) {
			balance -= amount;
			System.out.println("You have successfully made a withdrawal.");
			System.out.println("Your new balance is: "+amount);
			active = false;
		} {
			System.out.println("You have insufficient funds to make a withdrawal.");
			System.out.println("Please make a deposit first in order to complete your withdrawal.");
			try {
				wait(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				retMenu = false;
			}
		}
			
	}
	}
	
	synchronized void showBalance() {
			System.out.println("Your balance is: "+balance);
	}
}


public class BankOperations_UI {

	public static void main(String[] args) {
		Client client = new Client();
		int Select;
		
		
		Thread t1 = new Thread(() -> {
			double depAmount;
			System.out.println("Please enter the amount you would like to deposit.");
			Scanner depAmt = new Scanner(System.in);
			depAmount = depAmt.nextDouble();
			client.deposit(depAmount);
		});
		
		
		Thread t2 = new Thread(()->{
			client.showBalance();
		});
		
		Thread t3 = new Thread(() -> {
			double withAmount;
			System.out.println("Please enter the amount you would like to withdraw.");
			Scanner withAmt = new Scanner(System.in);
			withAmount = withAmt.nextDouble();
			client.withdraw(withAmount);
		});
		
		
		// Customer Interface
		boolean menuActive = true;
		String Confirm;
		while(menuActive) {
			System.out.println("Please select from the following menu options:");
			System.out.println("1. Make a deposit");
			System.out.println("2. Make a withdrawal");
			System.out.println("3. Show balance");
			Scanner userSelect = new Scanner(System.in);
			Select = userSelect.nextInt();
			System.out.println(Select);
		
			
			if(Select==1) {
				t1.start();
				t2.start();
				
			} else if(Select==2) {
				t3.start();
				t2.start();
	
			} else if(Select==3) {
				t2.start();

			} else {
				System.out.println("You have not made a valid selection. Please try again.");
			}


		System.out.println("Would you like to perform another operation? (Y/N)");
		Scanner confirm = new Scanner(System.in);
		Confirm = confirm.next();
		if(Confirm.equals("N")) {
			menuActive = false;
		}
	}
	}

}
