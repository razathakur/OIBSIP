package com.oasis;

import java.sql.SQLException;
import java.util.Scanner;

public class ShowView {
	Integer select;
	Scanner sc;

	void display() throws SQLException {
		ShowView svv = new ShowView();
		System.out.println("\nATM Interface");
		System.out.println(
				"Enter 1 to see Transaction History \nEnter 2 for withdraw money \nEnter 3 for Depositing\nEnter  4 For Transfer\nEnter 5 for Exit");
		sc = new Scanner(System.in);
		select = sc.nextInt();
		switch (select) {
		case 1:
			new Transaction().history();
			break;
		case 2:
			new Withdraw().withdraw();
			break;
		case 3:
			Depositing dep = new Depositing();
			dep.deposit();
			break;

		case 4:
			new Transfer().transfer();
			break;
		case 5:
			System.out.println("Exit");
			break;
		default: {
			System.err.println("Choose Valid number");
			svv.display();
			break;
		}
		}
	}
}
