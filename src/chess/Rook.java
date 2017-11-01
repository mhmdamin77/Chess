package chess;

public class Rook extends Piece{
    
    public Rook(ChessBoard board, Player player, int row, int column) {
        super(board, player);
        setLocation(row, column);
    }
   
    protected boolean checkValid(int row, int column) {
       
        if(!(row == this.row || column == this.column))
            return false;
        
        return !isPieceBeetween(row, column);
    }
}
