package chess;

public class ChessBoard {
    public final Piece[][] board = new Piece[8][8];
    public final Player player1 = new Player(ChessColor.WHITE);
    public final Player player2 = new Player(ChessColor.BLACK);

    public ChessBoard() {
        this.initiateBorad(player1);
        this.initiateBorad(player2);
    }
    
    private void initiateBorad(Player player) {
        
        int k = 0, r = 1;
        if (player.color == ChessColor.BLACK){
            r = -1;
            k = 7;
        }
        
        Piece king = new King(this, player, k, 3);
        board[k][3] = king;
        
        Piece queen = new Queen(this, player, k, 4);
        board[k][4] = queen;
        
        for (int i = 0; i < 8; i+=7) {
            Piece rook = new Rook(this, player, k, i);
            board[k][i] = rook;
        }
        
        for (int i = 1; i < 7; i += 5) {
            Piece knight = new Knight(this, player, k, i);
            board[k][i] = knight;
        }        
        
        for (int i = 2; i < 6; i+= 3) {
            Piece bishop = new Bishop(this, player, k, i);
            board[k][i] = bishop;
        }
        
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Pawn(this, player, k+r, i);
            board[k+r][i] = pawn;
        }
    }
}
