public class Card
{
    // instance variables 
    private char suit;
    private int rank;

    // the no-arg constructor 
    public Card() {
        this.suit = 'C';
        this.rank = 1;
    }

    // the explicit (parameter) constructor
    public Card(char suit, int rank) {
        this.suit = suit;
        this.rank = rank;                
    }

// Accessor methods.
    public char getSuit() {
        return this.suit;
    }
    
    public int getRank() {
        return this.rank;
    }
   
// Modifier methods.
    public void setSuit(char suit) {
        if(suit == 'C' || suit == 'c' || suit == 'S' || suit == 's' || suit == 'H' || suit == 'h' || suit == 'D' || suit == 'd') {
            this.suit = suit;
        }                    
    }
    
    public void setRank(int rank) {
        if(rank >= 1 && rank <= 13) {
            this.rank = rank;
        }
    }

    // the print method.
    public void print() {
        String result = "";
        if(suit == 'C' || suit == 'c') {   // print out the suit.
           result = "♣";
        }
        if(suit == 'S' || suit == 's') {
            result = "♠";
        }
        if(suit == 'H' || suit == 'h') {
            result = "♥";
        }
        if(suit == 'D' || suit == 'd') {
            result = "♦";
        }           
        
        if(rank == 1) {     // First print out the rank.
            result += "A";
        }
        else if(rank == 11) {
            result += "J";                    
        }
        else if(rank == 12) {
            result += "Q";                    
        }
        else if(rank == 13) {
            result +="K";                    
        }
        else {
            result += rank; 
        }
        
        System.out.println(result);
    }    
    
    public String toString()
    {
        String result;
        
        if(suit == 'C' || suit == 'c') {   // Then print out the suit.
            result = "♣";
        }
        else if(suit == 'S' || suit == 's') {
            result = "♠";
        }
        else if(suit == 'H' || suit == 'h') {
            result = "♥";
        }
        else if(suit == 'D' || suit == 'd') {
            result = "♦";
        }      
        else {
            result = "Joker";
        }
        
        if(rank == 1) {     // First print out the rank.
            result += "A";
        }
        if(rank == 11) {
            result += "J";                    
        }
        if(rank == 12) {
            result += "Q";                    
        }
        if(rank == 13) {
            result += "K";                    
        }
        else {
            result += rank + "";
        }
                  
        return result; 
    }
}