package blackJack;

import java.util.Scanner;
import java.util.Random;

public class BlackJack {
    public static Random initRandom(String[] args) {
        if (args.length >= 1) {
          return new Random(Long.parseLong(args[0]));
        } else {
          return new Random();
        }
      }

    public static void main(String[] args) throws Exception {
        Random r = initRandom(args);    // Do not modify this line
        System.out.println("Welcome to Blackjack!");
        playB(r);
    }
    public static void playB(Random r) {
    	Scanner scanner = new Scanner(System.in);
    	
    	
    	int playercard1 = r.nextInt(10) + 2;
    	int playercard2 = r.nextInt(10) + 2;
    	
    	int dealercard1 = r.nextInt(10) + 2;
    	int dealercard2 = r.nextInt(10) + 2;
    	
    	int playersum = playercard1 + playercard2;
    	int dealersum = dealercard1 + dealercard2;
    	
    	String playercards = playercard1 + "," + playercard2;
    	String dealercards = dealercard1 + "," + dealercard2;
    	
    	boolean pgame = false;
    	boolean dgame = false;
    	
    	while(true) {
    		System.out.println("Your cards are: " + playercards);
        	System.out.println("Would you like to hit or stand?");
        	String input1 = scanner.nextLine().toLowerCase();
        	
        	if (input1.equals("hit")) {
        		int newpcard = r.nextInt(10) + 2;
        		playersum += newpcard;
        		playercards += "," + newpcard;
        		
        		if (playersum > 21) {
        			System.out.println("Your cards are: " + playercards);
        			System.out.println("You have bust!");
        			pgame = true;
        			break;
        		}
        		
        	}
        	if (input1.equals("stand")) {
        		break;
        	}
        		
    	}
    	
    	while (true) {
    		boolean dealerh = r.nextBoolean();
    		
    		if (dealerh) {
        		int newdcard = r.nextInt(10) + 2;
        		dealersum += newdcard;
        		dealercards += "," + newdcard;
        		System.out.println("The dealer hits.");
        		
        		if (dealersum > 21) {
        			System.out.println("The dealer has bust!");
        			dgame = true;
        			break;
        		}
    		}
    		else {
    			System.out.println("The dealer stands.");
    			break;
    		}
    	}
    	
    	if (pgame == false && dgame == false) {
    		System.out.println("Your cards are: " + playercards);
    		System.out.println("The dealer's cards are: " + dealercards);
    		
    		if (playersum > dealersum) {
    			System.out.println("You win!");
    		}
    		else if (playersum < dealersum) {
    			System.out.println("Dealer wins!");
    		}
    		else if (playersum == dealersum){
    			System.out.println("Tie!");
    		}
    	}
    	if (pgame == true && dgame == false) {
    		System.out.println("Your cards are: " + playercards);
    		System.out.println("The dealer's cards are: " + dealercards);
    		
    		System.out.println("Dealer wins!");
    	}
    	if (dgame == true && pgame == false) {
    		System.out.println("Your cards are: " + playercards);
    		System.out.println("The dealer's cards are: " + dealercards);
    		
    		System.out.println("You win!");
    	}
    	if (pgame == true && dgame == true) {
    		System.out.println("Your cards are: " + playercards);
    		System.out.println("The dealer's cards are: " + dealercards);
    		
    		if (playersum == dealersum){
    			System.out.println("Tie!");
    		}
    		else {
    			System.out.println("Dealer wins!");
    		}
    	}
    	
    	scanner.close();
    }
}
