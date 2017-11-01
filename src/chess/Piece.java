package chess;

public abstract class Piece {
    protected int row;
    protected int column;
    protected boolean alive = true;
    public final Player owner;
    public final ChessBoard board;
    
    public Piece(ChessBoard board, Player player) {
        this.owner = player;
        this.board = board;
    }
    
    protected void setLocation(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    protected abstract boolean checkValid(int row, int column);
    
    public void move(int row, int column) {
        if(checkValid(row, column) == false){
            throw new RuntimeException("Invalid move.");
        }
        
        if (board.board[row][column] != null && board.board[row][column].owner == this.owner){
            throw new RuntimeException("Invalid move.");
        }
        this.row = row;
        this.column = column;
        
        if (board.board[row][column] != null) {
            board.board[row][column].alive = false;
        }
    }
    
    protected boolean isPieceBeetween(int row, int column){
        int max = Math.max(Math.abs(this.row-row), Math.abs(this.column-column));
        int i = Math.abs(this.column-column) / max;
        int j = Math.abs(this.row-row) / max;
        for (int r = 1; r < max; r++){
            if (board.board[this.row + r*i][this.column + r*j] != null) {
                return true;
            }
        }
        return false;
    }
}
