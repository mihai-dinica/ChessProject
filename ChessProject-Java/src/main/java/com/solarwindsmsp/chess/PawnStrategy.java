package com.solarwindsmsp.chess;

public class PawnStrategy implements Strategy {

    public Pawn pawn;

    public PawnStrategy(Pawn pawn) {
        this.pawn = pawn;
    }

    public boolean isLegalPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate == ChessUtil.MIN_BOARD_HEIGHT || xCoordinate == ChessUtil.MAX_BOARD_WIDTH;
    }

    public boolean isValidNumberOfSamePieceType() {
        ChessBoard chessBoard = pawn.getChessBoard();
        int currentNumberOfPawnPieces = this.getCurrentNumberOfPawnPiecesFromChessBoard(chessBoard);

        if (currentNumberOfPawnPieces > pawn.MAX_NUMBERS_OF_SAME_PIECE_TYPE) {
            return false;
        }

        return true;
    }

    private int getCurrentNumberOfPawnPiecesFromChessBoard(ChessBoard chessBoard) {
        int currentNumber = 0;
        Piece[][] pieces = chessBoard.getPieces();

        for (int i=0; i<=ChessUtil.MAX_BOARD_WIDTH; i++) {
            for (int j=0; j<=ChessUtil.MAX_BOARD_HEIGHT; j++) {
                if (pieces[i][j] instanceof Pawn && pieces[i][j].getPieceColor() == pawn.getPieceColor()) {
                    currentNumber++;
                }
            }
        }

        return currentNumber;
    }
}
