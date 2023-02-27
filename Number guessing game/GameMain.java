  import java.util.*;
        class Guesser {
	Integer n = 0;
	int num;

	int guess() {

		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Guesser Kindly Guess the number :\nKindly guess the number Between Range [10-100]\nYou have 3 chances to guess\nCHOOSE NUMBER");

		while (n < 3) {
			num = scan.nextInt();
			if (num > 9 && num < 101) {
				System.out.println("GREAT JOB");
				break;
			} else {
				if (n < 2) {
					System.out.println("Kindly Guess the number between range 10-100  you use ");
					System.out.println((n + 1) + "chance");
				} else {
					System.err.println("Game lost \n Restart the game");
					guess();
				}

			}
			n++;
		}
		return num;
	}
}

class Player {
	int guessplayer = 0;

	int play(String name) {
		Scanner scan = new Scanner(System.in);
		System.out.println(name + " Guess the number Between the range of \n[10 to 100]");
		guessplayer = scan.nextInt();
		if (guessplayer > 9 && guessplayer < 101) {
			System.out.println(name + "Kindly wait for the result\n");
		} else {
			System.err.println("Guess between Valid region");
			System.out.println("try again");
			play(name);
		}

		return guessplayer;
	}
}

class Umpire {
	int gusserNum;
	int player1;
	int player2;
	int player3;
	String option;

	void getGuesser() {
		Guesser gue = new Guesser();
		gusserNum = gue.guess();
		
	}

	void getPlayer() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		player1 = p1.play("Captain America");
		player2 = p2.play("Tonny");
		player3 = p3.play("Thor");

	}

	void compute() {
		if (gusserNum == player1) {
			if (gusserNum == player2 && gusserNum == player3) {
				System.out.println("All player won the Match ");
			} else if (gusserNum == player2) {
				System.out.println(" Captain America  Thor won the match");
			} else if (gusserNum == player3) {
				System.out.println("  Captain America Tonny won the match");
			} else {
				System.out.println("Captain America won the game ");
			}
		}
		else if(gusserNum==player2)
		{
			if(gusserNum==player3)
			{
				System.out.println("Thor and Tonny win the game");
			}
			else
			{
				System.out.println(" Thor won the match");
			}
		}
		else if(gusserNum==player3)
		{
			System.out.println(" Tonny won the Match");
		}
		else 
		{
			System.err.println(" Nobody guess the correct answer ");
		}
  
		System.out.println("\n ARE YOU WANT TO RESTART THE GAME -----> yes/no ");
		Scanner scan = new Scanner(System.in);
		option = scan.next();
		if (option.equalsIgnoreCase("yes")) {
			GameMain.main(null);
		}
		else
			System.out.println("            END GAME");

	}
}

public class GameMain {

	public static void main(String[] args) {
		
		System.err.println("                               GAME START ");
		System.out.println("-----------------------------------------------------------------");
		Umpire u = new Umpire();
		u.getGuesser();
		System.out.println("**********************************************************************");
		u.getPlayer();
		System.out.println("**********************************************************************");
		System.out.println("Wait for the Ressult ....\n");
		u.compute();

	}

}
