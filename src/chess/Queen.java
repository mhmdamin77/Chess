package chess;

public class Queen extends Piece{
    
    public Queen(ChessBoard board, Player player, int row, int column) {
        super(board, player);
        setLocation(row, column);
    }
    
    protected boolean checkValid(int row, int column) {
        if (!(Math.abs(row-row) == Math.abs(column-column) || row == row || column == column))
            return false;
        
        return !isPieceBeetween(row, column);
    }
}
