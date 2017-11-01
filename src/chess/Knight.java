package chess;

public class Knight extends Piece{
    
    
    public Knight(ChessBoard board, Player player, int row, int column) {
        super(board, player);
        setLocation(row, column);
    }
    
    protected boolean checkValid(int row, int column) {
        if (Math.abs(row-row) == 1 && Math.abs(column-column) == 2 ||
            Math.abs(row-row) == 2 && Math.abs(column-column) == 1 )
            return true;
        else
            return false;
    }
}
