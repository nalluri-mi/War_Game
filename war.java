import java.util.Random;
import java.util.Scanner;

public class war {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // The entire game (seen in main) is now within a while loop
        String keepPlaying = "y";
        while (keepPlaying == "y") {
            // Generate 2 random cards
            Random rand = new Random();
            int computerCard = rand.nextInt(52) + 1;
            int userCard = rand.nextInt(52) + 1;

            // Suit
            char computerCardSuit;
            char userCardSuit;

            // Computer card suit
            if (computerCard <= 13) {
                computerCardSuit = 'C';
            } else if (computerCard <= 26) {
                computerCardSuit = 'H';
            } else if (computerCard <= 39) {
                computerCardSuit = 'D';
            } else {
                computerCardSuit = 'S';
            }

            // User card suit
            if (userCard <= 13) {
                userCardSuit = 'C';
            } else if (userCard <= 26) {
                userCardSuit = 'H';
            } else if (userCard <= 39) {
                userCardSuit = 'D';
            } else {
                userCardSuit = 'S';
            }

            // Value
            int computerCardValue; 
            int userCardValue;

            // Computer card value
            computerCardValue = computerCard % 13;
            if (computerCardValue == 0) {computerCardValue = 13;}

            // User card value
            userCardValue = userCard % 13;
            if (userCardValue == 0) {userCardValue = 13;}
    
            // Final send of 2 cards value (suit + value) to be outputted as ASCII cards
            String computerFinalCard = Character.toString(computerCardSuit) + String.valueOf(computerCardValue);
            String userFinalCard = Character.toString(userCardSuit) + String.valueOf(userCardValue);
            printAsciiEval(computerFinalCard, userFinalCard);

            // Compare cards
            if (userCard > computerCard) {
                System.out.println("User Wins!");
            } else if (computerCard > userCard) {
                System.out.println("Computer Wins!");
            } else {
                System.out.println("War!");
            }

            // Determine if the user wants to play again
            System.out.println("Would you like to keep playing? (y/n): ");
            keepPlaying = scanner.nextLine();
        }
    }
    scanner.close();

    public static void printAsciiEval(String computerCard, String userCard) {

        if(computerCard.length() == 2){
            printAscii_2Char_card(computerCard);
        }else {
            printAscii_3Char_card(computerCard);
        }

        System.out.println("------------");
        System.out.println("--COMPUTER--");
        System.out.println("------------");
        System.out.println("-----VS-----");
        System.out.println("------------");
        System.out.println("----USER----");
        System.out.println("------------");

        if(userCard.length() == 2){
            printAscii_2Char_card(userCard);
        }else {
            printAscii_3Char_card(userCard);
        }
    }

    public static void printAscii_2Char_card(String card){
        // Top of the computer card
        System.out.println("┌─────────┐");
        // Upper part of the card with the character
        System.out.println("│" + card + "       │"); // top-left corner of the card
        System.out.println("│         │");
        System.out.println("│         │");
        System.out.println("│    " + card + "   │"); // middle of the card
        System.out.println("│         │");
        System.out.println("│         │");
        // Bottom part of the card with the character mirrored
        System.out.println("│       " + card + "│"); // bottom-right corner of the card
        // Bottom of the card
        System.out.println("└─────────┘");
    }

    public static void printAscii_3Char_card(String card){
        // Top of the computer card
        System.out.println("┌──────────┐");
        // Upper part of the card with the character
        System.out.println("│" + card + "       │"); // top-left corner of the card
        System.out.println("│          │");
        System.out.println("│          │");
        System.out.println("│    " + card + "   │"); // middle of the card
        System.out.println("│          │");
        System.out.println("│          │");
        // Bottom part of the card with the character mirrored
        System.out.println("│       " + card + "│"); // bottom-right corner of the card
        // Bottom of the card
        System.out.println("└──────────┘");
    }

}

