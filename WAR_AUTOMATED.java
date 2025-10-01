import java.util.Random;
import java.util.Scanner;   // this updated program uses a scanner object for user input

public class WAR_AUTOMATED {
    public static void main(String[] args){
        // Create a scanner object for user input
        Scanner myScanner = new Scanner(System.in);

        // The entire game (seen in main) is now within a while loop
        String keepPlaying = "y";
        while(keepPlaying.equals("y")){

            // generate the random cards for the player and the 
            Random rand = new Random();
            int computerCARD = rand.nextInt(52);
            int userCARD = rand.nextInt(52); 
            // ensure card is >= 1
            if(computerCARD == 0){
                computerCARD += 1;
            }
            if(userCARD == 0){
                userCARD += 1;
            }

            //Determine the suit of the cards
            // ['S', 'D', 'H', 'C'] ['SPADE', 'DIAMONDS ', 'HEARTS', 'CLUBS']
            char computerCardSuit = '.';
            char userCardSuit = '.';

            //Computer card suit
            if(computerCARD <= 13){
                computerCardSuit = 'C';
            }else if(computerCARD <= 26){
                computerCardSuit = 'H';
            }else if(computerCARD <= 39){
                computerCardSuit = 'D';
            }else {
                computerCardSuit = 'S';
            }

            //User card suit
            if(userCARD <= 13){
                userCardSuit = 'C';
            }else if(userCARD <= 26){
                userCardSuit = 'H';
            }else if(userCARD <= 39){
                userCardSuit = 'D';
            }else {
                userCardSuit = 'S';
            }

            //Determine the value of the card
            int computerCardValue; 
            int userCardValue;

            //Computer card value
            if (computerCARD <= 13){
                computerCardValue = computerCARD; // no operation needed for 1-13
            }else if(computerCARD <= 26){
                computerCardValue = computerCARD - 13;
            }else if(computerCARD <= 39){
                computerCardValue = computerCARD - 26;
            }else {
                computerCardValue = computerCARD - 39;
            }

            //User card value
            if (userCARD <= 13){
                userCardValue = userCARD; // no operation needed for 1-13
            }else if(userCARD <= 26){
                userCardValue = userCARD - 13;
            }else if(userCARD <= 39){
                userCardValue = userCARD - 26;
            }else {
                userCardValue = userCARD - 39;
            }
            
            // Convert the card values into Stirngs
            String computerFinalCard = Character.toString(computerCardSuit) + String.valueOf(computerCardValue);
            String userFinalCard = Character.toString(userCardSuit) + String.valueOf(userCardValue);

            //Send to the card output function
            printAsciiEval(computerFinalCard, userFinalCard);

            if(userCARD > computerCARD){
                System.out.println("User Wins");
            }else if(computerCARD > userCARD){
                System.out.println("Computer Wins");
            }else {
                System.out.println("WAR");
            }

            // Determine if the user wants to play again
            System.out.println("Would you like to keep playing? (y/n): ");
            keepPlaying = myScanner.nextLine();
    }
    myScanner.close();

    }
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
