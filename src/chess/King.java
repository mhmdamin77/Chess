package chess;

public class King extends Piece{
    
    public King(ChessBoard board, Player player, int row, int column) {
        super(board, player);
        setLocation(row, column);
    }
    
    protected boolean checkValid(int row, int column) {
        if (!(Math.abs(row-row) <= 1 && Math.abs(column-column) <= 1))
            return false;
        
        int Row = this.row + row;
        int Column = this.column + column;
        
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++){
                if (board.board[i][j] != null && board.board[i][j].owner != this.owner) {
                    if (board.board[i][j].checkValid(Row, Column) == true)
                        return false;
                }
            }
        
        return true;
    }
}
