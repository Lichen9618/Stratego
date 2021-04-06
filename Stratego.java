/** 
   The rule class keeps track of 
   a couple of past two moves and
   does the necessary checks.
*/
public class Stratego {

   /**
      Method to check whether moving a piece would would go into another piece.
      @param board the board to perform the check on.
      @param move the move to be checked
      @return whether the move is allowed.
   */
   public static boolean crossesAnotherPiece(Board board, Move move) {
      return false; // REPLAC ME
   }


   /** method to check if two square rule is respected.
      @param move the movement to check
      @param board the board
      @return whether the rules are met.
   */
   public static boolean twoSquareRule(Board board, Move move) {
      return false; // REPLACE ME
   }
    
   /** Method to check whether the game is over.
      @param board the board to check on.
      @return an int representing the game state
      0 for game is not over
      1 for red wins
      2 for blue wins
   */
   public static int isGameOver(Board board) {
      return -1;  // REPLACE ME
   }

   /**Method to check whether a move would cross a 
    * lake or land in a lake. HINT: there is a isLake()
    * method in the Board class that can be use here!
      @param board the board
      @param move the movement to check
      @return whether the move would cross a lake
   */
   public static boolean crossesLake(Board board, Move move) {
      return false; // REPLACE ME
   }
   
   /** Method to get the winner of an attack.
      @param att the piece attacking
      @param def the piece defending
      @return an int representing the winner of the attack. See below.
      0 return means attacker wins
      1 return means defender wins
      2 means both lose
      3 invalid, something is wrong!
   */
   public static int getWinner(Piece att, Piece def) {
      return -1; // REPLACE ME
   }
}