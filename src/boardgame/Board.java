package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) { // Check if the board has at least 1 row and 1 column
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns]; // The board has a matrix of pieces
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) { // Check if the position exists
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)) { // Check if the position exists
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    // Place a piece on the board
    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) { // Check if there is a piece in the position
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position; // The piece knows its position
    }


    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns; // Check if the position exists
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn()); // Check if the position exists
    }

    // Check if there is a piece in the position
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null; // Check if there is a piece in the position
    }






}
