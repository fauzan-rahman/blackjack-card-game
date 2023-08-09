import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * Write a description of class ScrabbleGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackJackGame 
{    
    public static void main(String [] args) 
        throws FileNotFoundException
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\f");
        String answer;
        ArrayList<Card> deck = new ArrayList<Card>(); // upgrade from array of Card 
        
        int[] playerChip = new int[2];
        playerChip[0] = 200;
        playerChip[1] = 200;
        
        int [] playerbet = new int[2];
        int current_bet = 0;
        
        boolean player1fold = false;
        boolean player2fold = false;

        //a) finish the makeDeck method below. This method fills the deck array
        //   with info for 52 cards read from cards.txt       
        makeDeck(deck);
        
        while(playerChip[0] != 0 && playerChip[1] != 0){
            current_bet = 0;
            System.out.println("Player 1 chip = " + playerChip[0]);
            System.out.println("Player 2 chip = " + playerChip[1]);
        
            ArrayList<Card> playerHand1 = new ArrayList<Card>(); // player can have unlimited cards
            ArrayList<Card> playerHand2 = new ArrayList<Card>();
            ArrayList<Card> computerHand = new ArrayList<Card>();
            
            int playerScore1 = 0;
            int playerScore2 = 0;
            int computerScore=0;         
            int dealCounter=52;
            playerHand1.add(deal(deck));
            playerHand1.add(deal(deck));
            playerHand2.add(deal(deck));
            playerHand2.add(deal(deck));
            
            System.out.println("Player 1 hand = " + playerHand1); 
            System.out.println("Player 2 hand = " + playerHand2);
            System.out.println();
            
            //b) finish the score method below main. It adds up and returns
            //   the blackJackValue of all the cards in the ArrayList passed to it
            //   initially the score will be zero.        
            System.out.println("Current Bet = " + current_bet);
            System.out.print("Player 1, do you want to Call, Raise, or Fold? " );
            answer = keyboard.next();
            if (answer.equalsIgnoreCase("Call")){
                player1fold = false;
                while (current_bet == 0){
                    System.out.print("Can't call since the current_bet = 0. What's your bet? ");
                    playerbet[0] = keyboard.nextInt();
                    while (playerbet[0] > playerChip[0]){
                        System.out.print("Don't bet higher than your chips!");
                        playerbet[0] = keyboard.nextInt();
                    }
                    current_bet = playerBet(current_bet, playerbet[0]);
                }
                
                if (current_bet != 0){
                    playerbet[0] = current_bet;
                }
                System.out.println();
            }
            else if (answer.equalsIgnoreCase("Raise")){
                player1fold = false;
                System.out.print("Player 1, how much is your bet? ");
                playerbet[0] = keyboard.nextInt();
                
                while (playerbet[0] > playerChip[0]){
                    System.out.print("Don't bet higher than your chips!");
                    playerbet[0] = keyboard.nextInt();
                }
                System.out.println();
                
                current_bet = playerBet(current_bet, playerbet[0]);
                
                System.out.println();
            }
            else if (answer.equalsIgnoreCase("Fold")){
                player1fold = true;
            }
            
            if (player1fold == true) {
                playerScore1 = 0;
            }
            else {
                System.out.println("Player score = " + score(playerHand1));
                System.out.print("Player, hit or stay? ");  
                answer = keyboard.next();
                
                while (answer.equals("hit")) {           
                    System.out.println();
                    System.out.println("Dealing ... ");
                    //c) finish the deal method below main. It picks a random index from 0 to 51
                    //    and returns the card in the deck array at that index               
                    playerHand1.add(deal(deck));  // add a new card to the hand
                    
                    System.out.println("Player 1 hand = " + playerHand1);
                    
                    playerScore1 = score(playerHand1);
                    System.out.println("Player 1 score = " + playerScore1);
                    
                    System.out.print("Player, hit or stay? ");  
                    answer = keyboard.next();            
                }
                System.out.println();
            }
            
            System.out.println("Current Bet = " + current_bet);
            System.out.print("Player 2, do you want to Call, Raise, or Fold? " );
            answer = keyboard.next();
            if (answer.equalsIgnoreCase("Call")){
                player2fold = false;
                while (current_bet == 0){
                    System.out.print("Can't call since the current_bet = 0. What's your bet? ");
                    playerbet[1] = keyboard.nextInt();
                    while (playerbet[1] > playerChip[1]){
                        System.out.print("Don't bet higher than your chips!");
                        playerbet[1] = keyboard.nextInt();
                    }
                    current_bet = playerBet(current_bet, playerbet[1]);
                }
                
                if (current_bet != 0){
                    playerbet[1] = current_bet;
                }
                System.out.println();
            }
            else if (answer.equalsIgnoreCase("Raise")){
                player2fold = false;
                System.out.println("Player 2, how much is your bet? ");
                playerbet[1] = keyboard.nextInt();
                while (playerbet[1] > playerChip[1]){
                    System.out.print("Don't bet higher than your chips!");
                    playerbet[1] = keyboard.nextInt();
                }
                current_bet = playerBet(current_bet, playerbet[1]);
                System.out.println();
            }
            else if (answer.equalsIgnoreCase("Fold")){
                player2fold = true;
                System.out.println();
            }
            
            if (player2fold == true) {
                playerScore2 = 0;
            }
            else {
                System.out.println("Player score = " + score(playerHand2));
                System.out.print("Player, hit or stay? ");  
                answer = keyboard.next();
                
                while (answer.equals("hit")) {           
                    System.out.println("Dealing ... ");
                    //c) finish the deal method below main. It picks a random index from 0 to 51
                    //    and returns the card in the deck array at that index               
                    playerHand2.add(deal(deck));  // add a new card to the hand
                    
                    System.out.println("Player 2 hand = " + playerHand2);
                    
                    playerScore2 = score(playerHand2);
                    System.out.println("Player 2 score = " + playerScore2);
                    
                    System.out.print("Player, hit or stay? ");  
                    answer = keyboard.next();            
                }
                System.out.println();
            }
                
            System.out.print("Computer: ");  
      
            //d) finish the while loop for the computer's turn:
     
            while (computerScore < 16) { // the computer automatically stays at 16          
                System.out.println("Dealing ... ");
                // deal a card to the computerHand ArrayList
                computerHand.add(deal(deck));
                // print the computer hand
                System.out.println("Computer hand = " + computerHand);
                // compute the computerScore 
                computerScore = score(computerHand);
                // print the computerScore
                System.out.println("Computer score = " + computerScore);
            } 
            System.out.println();
            
            // e)  determine and print the outcome of the game 
            //     based on playerScore and computerScore
            int p1;
            int p2;
            int c;
            
            if(playerScore1 < 22){
                p1 = playerScore1;
            }
            else{
                p1 = 0;
            }
            
            if(playerScore2 < 22){
                p2 = playerScore2;
            }
            else{
                p2 = 0;
            }
            
            if(computerScore < 22){
                c = computerScore;
            }
            else{
                c = 0;
            }
            
            if(c>p1 && c>p2){
                System.out.println("Computer Wins");
                playerChip[0] -= current_bet;
                playerChip[1] -= current_bet;
            }
            else if(c<p1 && c>p2){
                System.out.println("Player 1 Wins!");
                playerChip[0] += current_bet;
                playerChip[1] -= current_bet;
            }
            else if(c>p1 && c<p2){
                System.out.println("Player 2 Wins!");
                playerChip[0] -= current_bet;
                playerChip[1] += current_bet;
            }
            else if(p1>c && p1>p2){
                System.out.println("Player 1 Wins!");
                playerChip[0] += current_bet;
                playerChip[1] -= current_bet;
            }
            else if(p1<c && p1>p2){
                System.out.println("Computer Wins");
                playerChip[0] -= current_bet;
                playerChip[1] -= current_bet;
            }
            else if(p1>c && p1<p2){
                System.out.println("Player 2 Wins!");
                playerChip[0] -= current_bet;
                playerChip[1] += current_bet;
            }
            else if(p2>c && p2>p1){
                System.out.println("Player 2 Wins!");
                playerChip[0] -= current_bet;
                playerChip[1] += current_bet;
            }
            else if(p2<c && p2>p1){
                System.out.println("Computer Wins");
                playerChip[0] -= current_bet;
                playerChip[1] -= current_bet;
            }
            else if(p2>c && p2<p1){
                System.out.println("Player 1 Wins!");
                playerChip[0] += current_bet;
                playerChip[1] -= current_bet;
            }
            else{
                System.out.println("DRAW");
            }
            
            System.out.println();
        }
        
        if (playerChip [0] > playerChip[1]){
            System.out.println("THE WINNER OF THIS GAME IS PLAYER 1!");
        }
        else if (playerChip[1] > playerChip[0]){
            System.out.println("THE WINNER OF THIS GAME IS PLAYER 2!");
        }
        else {
            System.out.println("IT IS A DRAW!");
        }
    } // END OF MAIN METHOD
        
    public static void makeDeck(ArrayList<Card> deck)
            throws FileNotFoundException
    {
        // make a Scanner inputFile and connect to file cards.txt
        Scanner inputFile = new Scanner(new File("cards.txt"));

        int k = 0;
        // while loop, as long as k<52 AND there is more info in file
        while (k<52 && inputFile.hasNext()){
            
            // read a char from the file, store in suit
            char tempSuit = inputFile.next().charAt(0);
            // read an int from the file, store in rank
            int tempRank = inputFile.nextInt();
            // make a Card temp a new Card with the suit and rank you read
            Card tempCard = new Card(tempSuit, tempRank);
            // assign temp to the next location in the deck array
            deck.add(k, tempCard);
            // add 1 to k for next time around
            k++;
        }
    }
    public static Card deal(ArrayList<Card> deck)
    {
        // use the randomInt method to generate 
        // a random integer between 0 (inclusive) to 52 (exclusive)
        int randomNum = randomInt(0,deck.size());
        // store the card at your randomIndex into a tempCard variable.
        Card tempCard = deck.get(randomNum);
        // remove the card in the deck at randomIndex
        deck.remove(randomNum);
        // OPTIONAL: you might check the size of the deck and 
        //     if it's zero, call makeDeck to get a new Deck
        // return your tempCard 
        return tempCard;  // delete this after writing the above 
    }    

    public static int randomInt(int low, int high) {
        // returns a random int from low (inclusive) to high (exclusive)
        // Determine the span of the range.
                int range = high - low;
      
        // return a random number from the range.
            return (int)(range*Math.random()) + low;   
    }    
   
    public static int score(ArrayList<Card> hand)
    {
        int total = 0;
        for(int k=0; k<hand.size(); k++){
            if (blackJackValue(hand.get(k)) == 1){ //condition if the card is Ace
                if (total < 11){
                    total += 10; //Ace counts 11 if the total wouldn't exceed 21 when Ace is 11
                }
            }
            total += blackJackValue(hand.get(k));
        }
        
        return total;  // fix
    }       
    
    public static int blackJackValue(Card c)
    {
        if (c.getRank() < 11)
            return c.getRank();
        else 
            return 10;       
    }
    
    public static int playerBet(int current_bet, int bet_attempt)
    {
        int acceptedbet = 0;
        
        if (bet_attempt > current_bet){
            acceptedbet = bet_attempt;
            System.out.println("Bet accepted!");
            System.out.println("The current bet is " + acceptedbet);
        }
        else{
            acceptedbet = current_bet;
            System.out.println("Bet declined! You should bet higher than the current bet!");
            System.out.println("The current bet is " + acceptedbet);
        }
        
        return acceptedbet;
    }
}
/*

The first card in deck is Ace of Clubs
The last card in deck is King of Spades
Player hand = []
Player score = 0
Player, hit or stay? hit
Dealing ... 
Player hand = [3 of Diamonds]
Player score = 3
Player, hit or stay? hit
Dealing ... 
Player hand = [3 of Diamonds, 4 of Spades]
Player score = 7
Player, hit or stay? hit
Dealing ... 
Player hand = [3 of Diamonds, 4 of Spades, 4 of Diamonds]
Player score = 11
Player, hit or stay? hit
Dealing ... 
Player hand = [3 of Diamonds, 4 of Spades, 4 of Diamonds, Queen of Diamonds]
Player score = 21
Player, hit or stay? stay
Computer: Dealing ... 
Computer hand = [6 of Clubs]
Computer score = 6
Dealing ... 
Computer hand = [6 of Clubs, Jack of Diamonds]
Computer score = 16
Player Wins

 */
