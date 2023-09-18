public class Piece {
    char piece;
    boolean colour; //white=true
    int val;
    char column;
    int row;
    char[] col = {'0', '0', 'a', '0',
                  '0', '0', 'b', '0', 
                  '0', '0', 'c', '0', 
                  '0', '0', 'd', '0', 
                  '0', '0', 'e', '0', 
                  '0', '0', 'f', '0', 
                  '0', '0', 'g', '0', 
                  '0', '0', 'h', '0'};

    public Piece(char piece, int r, int c) {
        this.row = r+1;
        this.column = col[c];

        if (piece=='k') {
            this.piece = 'K';
            this.colour = false;
            this.val = 0;
        } else if (piece=='q') {
            this.piece = 'Q';
            this.colour = false;
            this.val = 1;
        } else if (piece=='r') {
            this.piece = 'R';
            this.colour = false;
            this.val = 2;
        } else if (piece=='b') {
            this.piece = 'B';
            this.colour = false;
            this.val = 3;
        } else if (piece=='n') {
            this.piece = 'N';
            this.colour = false;
            this.val = 4;
        } else if (piece=='p') {
            this.piece = 'P';
            this.colour = false;
            this.val = 5;
        } else if (piece=='K') {
            this.piece = 'K';
            this.colour = true;
            this.val = 0;
        } else if (piece=='Q') {
            this.piece = 'Q';
            this.colour = true;
            this.val = 1;
        } else if (piece=='R') {
            this.piece = 'R';
            this.colour = true;
            this.val = 2;
        } else if (piece=='B') {
            this.piece = 'B';
            this.colour = true;
            this.val = 3;
        } else if (piece=='N') {
            this.piece = 'N';
            this.colour = true;
            this.val = 4;
        } else if (piece=='P') {
            this.piece = 'P';
            this.colour = true;
            this.val = 5;
        }
    }
    
    public char getPiece() {
        return piece;
    }

    public boolean getColour() {
        return colour;
    }

    public int getValue() {
        return val;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }
}