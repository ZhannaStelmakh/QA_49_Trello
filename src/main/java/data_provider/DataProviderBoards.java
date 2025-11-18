package data_provider;

import dto.Board;
import org.testng.annotations.DataProvider;

public class DataProviderBoards {
    @DataProvider
    public Board[] newBoardDataProvider(){
        Board board1 = Board.builder().boardTitle("Tolk1").build();
        Board board2 = Board.builder().boardTitle("Tolk2").build();
        Board board3 = Board.builder().boardTitle("Tolk3").build();

        return new Board[]{board1, board2, board3};
    }
}
