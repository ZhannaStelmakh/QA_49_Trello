package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class BoardsTests extends AppManager {

    @BeforeMethod
    public void login(){
        User user = User.builder()
                .email("zhanna.stelmakh.test49@gmail.com")
                .password("Tolkin2025")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).Login(user);
    }

    @Test
    public void createNewBoardPositiveTest(){
        Board board = Board.builder()
                .boardTitle("qwerty")
                .build();
        new BoardsPage(getDriver()).createNewBoard(board);
    }
}
