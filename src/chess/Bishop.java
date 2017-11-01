package chess;

public class Bishop extends Piece{
    
    public Bishop(ChessBoard board, Player player, int row, int column) {
        super(board, player);
        setLocation(row, column);
    }
    
    protected boolean checkValid(int row, int column) {
        if (!(Math.abs(row-row) == Math.abs(column-column)))
            return false;
        
        return !isPieceBeetween(row, column);
    }
}
