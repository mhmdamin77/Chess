package chess;

public class Pawn extends Piece{
    
    public Pawn(ChessBoard board, Player player, int row, int column) {
        super(board, player);
        setLocation(row, column);
    }
    
    protected boolean checkValid(int row, int column) {
        int k = 1;
        if (this.owner.color == ChessColor.BLACK)
            k = -1;
        
        if (column == column && row == row + k) {
            if (board.board[row][column] != null)
                return false;
        }
        
        if (Math.abs(column-column) == 1 && row == row + k) {
            if (board.board[row][column] != null && board.board[row][column].owner != this.owner)
                return true;
        }
        return false;
    }
}
