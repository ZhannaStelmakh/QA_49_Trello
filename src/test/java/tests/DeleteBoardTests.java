package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.Random;

public class DeleteBoardTests extends AppManager {
    BoardsPage boardsPage;

    @BeforeMethod
    public void login(){
        User user = User.builder()
                .email("zhanna.stelmakh.test49@gmail.com")
                .password("Tolkin2025")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).Login(user);
        boardsPage = new BoardsPage(getDriver());
        int i = new Random().nextInt(1000);
        Board board = Board.builder()
                .boardTitle("qwerty"+i).build();
        boardsPage.createNewBoard(board);
        boardsPage.clickBtnCreate();
    }

    @Test
    public void deleteBoardPositiveTest(){
        new MyBoardPage(getDriver()).deleteBoard();
        Assert.assertTrue(boardsPage.validatePopUpMessage("Board deleted."));
    }
}
