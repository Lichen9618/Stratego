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
      if(move.getDr() == move.getSr()){
         for( int i = move.getSc(); i != move.getDc();){
            if(i < move.getDc()){
               i++;
            }else{
               i--;
            }
            if(i == move.getDc()){
               if(board.getGrid()[move.getDr()][move.getDc()].isEmpty() || board.getGrid()[move.getSr()][move.getSc()].getPiece().red != board.getGrid()[move.getDr()][move.getDc()].getPiece().red)
               return false;
            }
            if(!board.getGrid()[move.getDr()][i].isEmpty()) return true;
         }
      }else{
         for( int i = move.getSr(); i != move.getDr();){
            if(i < move.getDr()){
               i++;
            }else{
               i--;
            }
            if(i == move.getDr()){
               if(board.getGrid()[move.getDr()][move.getDc()].isEmpty() || board.getGrid()[move.getSr()][move.getSc()].getPiece().red != board.getGrid()[move.getDr()][move.getDc()].getPiece().red)
               return false;
            }
            if(!board.getGrid()[i][move.getDc()].isEmpty()) return true;
         }
      }
      return false;
   }


   /** method to check if two square rule is respected.
      @param move the movement to check
      @param board the board
      @return whether the rules are met.
   */
   public static boolean twoSquareRule(Board board, Move move) {
      Move[] moves = board.getL2Moves(board.getTurn());
      return !moves[0].isOpposite(move);
   }
    
   /** Method to check whether the game is over.
      @param board the board to check on.
      @return an int representing the game state
      0 for game is not over
      1 for red wins
      2 for blue wins
   */
   public static int isGameOver(Board board) {
      //no flag or no movable piece
      if(!board.hasFlag(true) || board.getCountMovables(true) == 0) return 2;
      if(!board.hasFlag(false)|| board.getCountMovables(false) ==0) return 1;      
      return 0;
   }

   /**Method to check whether a move would cross a 
    * lake or land in a lake. HINT: there is a isLake()
    * method in the Board class that can be use here!
      @param board the board
      @param move the movement to check
      @return whether the move would cross a lake
   */
   public static boolean crossesLake(Board board, Move move) {
      boolean isCrossesLake = false;
      if(move.getDr() == move.getSr()){
         for( int i = move.getSc(); i != move.getDc();){
            if(i < move.getDc()){
               i++;
            }else{
               i--;
            }
            if(board.getGrid()[move.getDr()][i].isLake()) isCrossesLake = true;
         }
      }else{
         for( int i = move.getSr(); i != move.getDr();){
            if(i < move.getDr()){
               i++;
            }else{
               i--;
            }
            if(board.getGrid()[i][move.getDc()].isLake()) isCrossesLake = true;
         }
      }
      return isCrossesLake;
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
      if(!(att instanceof MPiece)) return 3;
      MPiece attacker = (MPiece)att;
      //flag or bomb
      if(!(def instanceof MPiece)){         
         if(def.getCharacter() == 'f' || def.getCharacter() == 'F'){
            return 0;
         }
         //not flag, bomb
         if(attacker.character == 'o' || attacker.character == 'O'){
            return 0;
         }else{
            return 1;
         }
      }else{
         if(attacker.character == 'y' || attacker.character == 'Y'){
            if(def.character == 'y'||def.character == 'Y') return 2;
            if(def.character == 'm'||def.character == 'M') return 0;
            return 1;       
         }else{
            MPiece defender = (MPiece)def;
            if(attacker.getRank() > defender.getRank()) return 0;
            if(attacker.getRank() == defender.getRank()) return 2;
            return 1;
         }
      }
   }
}
