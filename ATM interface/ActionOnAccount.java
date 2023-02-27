package com.oasis;

import java.sql.SQLException;
import java.util.Scanner;

public class ActionOnAccount {

	static int depoIn = 0;
	static int transIn = 0;
	static int withIn = 0;

	public static int data = 5000;
	public Scanner scan = new Scanner(System.in);
	public int money = 0;
	public String decide = null;

	void furtherWork() throws SQLException {
		System.out.println("YOu have other work to do :: yes/no");
		decide = scan.next();
		if (decide.equalsIgnoreCase("yes")) {
			ShowView svv = new ShowView();
			svv.display();
		} else {
			System.out.println("Account get log off ");
		}
	}

	void viewData() {
		System.out.println("Are you want to see data:: [yes/no]");
		decide = scan.next();
		if (decide.equalsIgnoreCase("yes")) {

			System.out.println(data);
		}
	}
}

class Transaction {
	void history() {
		Depositing d= new Depositing();
		int val1=d.depoIn;
		System.out.println("The amount deposite in last few times "+val1);
		Transfer t= new Transfer();
		int val2=t.transIn;
		System.out.println("The amount Transfer in last few times "+val2);
		Withdraw w= new Withdraw();
		int val = w.withIn;
		System.out.println("The amount Withdraw in last few times "+val);
		System.out.println("\n");
		ActionOnAccount aa= new ActionOnAccount();
		try {
			aa.furtherWork();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

class Withdraw extends ActionOnAccount {

	void withdraw() throws SQLException {

		System.out.println("\nWITHDRAW SECTION ");
		System.out.println("Enter amount for withdrawing :: ");
		money = scan.nextInt();
		data = data - money;
		System.out.println("Collect Money.....");
		withIn = withIn+money;
		viewData();
		System.out.println("\n");
		furtherWork();

	}

}

class Depositing extends ActionOnAccount {

	void deposit() throws SQLException {
		System.out.println("MONEY DEPOSITE SECTION");
		DbConnector dbb = new DbConnector();

		System.out.println("Enter Amount to deposite ");
		money = scan.nextInt();
		data = data + money;
		System.out.println("Your Money Succesfully Deposite ");
		depoIn = depoIn + money;
		viewData();
		System.out.println("\n");
		furtherWork();
	}
}

class Transfer extends ActionOnAccount {
	String accountName = null;

	void transfer() throws SQLException {
		System.out.println("TRANSFER SECTION \nEnter Money for Transfering");
		money = scan.nextInt();
		System.out.println("Enter Receiver Account Number");
		accountName = scan.next();
		data = data - money;
		System.out.println("Data tranfer successfully in " + accountName + " account");
		transIn = transIn + money;
		viewData();
		System.out.println("\n");
		furtherWork();

	}
}