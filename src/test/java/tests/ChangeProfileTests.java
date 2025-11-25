package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AtlassianProfilePage;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.RetryAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class ChangeProfileTests  extends AppManager {

    @BeforeMethod(alwaysRun = true)
    public void login() {
        User user = User.builder()
                .email("zhanna.stelmakh.test49@gmail.com")
                .password("Tolkin2025")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).Login(user);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = "smoke")
    public void changeProfilePhoto() {
        new BoardsPage(getDriver()).openMyAccount();
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        System.out.println(tabs);
        getDriver().switchTo().window(tabs.get(1));
        AtlassianProfilePage atlassianProfilePage = new AtlassianProfilePage(getDriver());
        atlassianProfilePage.changeMyProfilePhoto("src/main/resources/Lucid_Realism_A_cozy_morning_kitchen_scene_a_middleaged_woman__1.jpg");
        Assert.assertTrue(atlassianProfilePage.validateMessage("We've uploaded your new avatar. " +
                "It may take a few minutes to display everywhere."));
    }
}
