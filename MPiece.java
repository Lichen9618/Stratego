/** Class that represents a piece that can move.
*/
public class MPiece extends Piece{
       /** is this immovable piece a flag or bomb? */
   private int rank;
   
   /**Constructor of a Imovable piece.
      @param piece the name of the piece
      @param color which player the piece belongs to
   */
   public MPiece(char piece, boolean color) {
      super(piece, color);
   }

   /**Constructor of a Imoveable piece.
   @param piece the name of the piece
   @param color which player the piece belongs to
   @param flag is flag or not
   */
   public MPiece(char piece, boolean color, char character) {
      super(piece, color);
      this.character = character;
      this.rank = characterAndRankMap(character);
   }

   public boolean makeMove(Board board, Move move){
       boolean result = false;
       return result;
   }
   
   /** getter for flag.
   @return is flag or not?
   */
   public boolean isLegalMove(Move move) {
       boolean result = false;
       if(this.character == 'o' || this.character == 'O'){
            if( move.isHorizontal() || move.isVertical()) result = true; 
       }else{
            if( abs(move.getDr() - move.getSr()) == 1 && move.getDc() - move.getSc() == 0 ) result = true;
            if( abs(move.getDc() - move.getSc()) == 1 && move.getDr() - move.getSr() == 0 ) result = true;
       }
       return result;
   }

   public int getRank(){
       return rank;
   }

   @Override
   public String toString() {
      return "MPiece [charater=" + character + ", toString()=" + super.toString() + "]";
   }
   private static int abs(int a) {
    return (a < 0) ? -a : a;
   }

   private static int characterAndRankMap(char character){
    switch(character){
        case 'm' :
            return 10;
        case 'M' :
            return 10;
        case 'g' :
            return 9;
        case 'G' :
            return 9;
        case 'c' :
            return 8;
        case 'C' :
            return 8;
        case 'j' :
            return 7;
        case 'J' :
            return 7;
        case 'p' :
            return 6;
        case 'P' :
            return 6;
        case 'l' :
            return 5;
        case 'L' :
            return 5;
        case 's' :
            return 4;
        case 'S' :
            return 4;
        case 'i' :
            return 3;
        case 'I' :
            return 3;
        case 'o' :
            return 2;
        case 'O' :
            return 2;
        default :
            return 1;
    }
   }
}
