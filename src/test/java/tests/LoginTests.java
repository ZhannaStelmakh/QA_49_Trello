package tests;

import dto.User;
import manager.AppManager;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {

    @Test
    public void loginPositiveTest(){
        User user = User.builder()
                .email("zhanna.stelmakh.test49@gmail.com")
                .password("Tolkin2025")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).Login(user);
        Assert.assertTrue(new BoardsPage(getDriver()).validateUrl("boards"));
    }

    @Test(expectedExceptions = TimeoutException.class)
    public void loginNegativeTest(){
        User user = User.builder()
                .email("zhanna.stelmakh.test49@gmail.com")
                .password("Tolkin2025")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).Login(user);
        new BoardsPage(getDriver()).validateUrl("abvg");
    }

    @Test
    public void loginNegativeTest_Another(){
        User user = User.builder()
                .email("zhanna.stelmakh.test49@gmail.com")
                .password("Tolkin2025")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).Login(user);
        Assert.assertFalse(new BoardsPage(getDriver())
                .validateUrlWOCreateException("fgghytr"));
    }
}
