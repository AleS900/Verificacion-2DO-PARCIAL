package testClean;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pagesTodoly.LoginModal;
import pagesTodoly.MainPage;
import pagesTodoly.MenuSection;

public class E6LogoutTest extends BaseTodoLy {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    MenuSection menuSection = new MenuSection();
    String email = "santiavctf@gmail.com";
    String password = "Santiago900";

    @Test
    public void verifySignUp() throws InterruptedException {
        // Login
        mainPage.loginImage.click();
        loginModal.login(email,password);
        Thread.sleep(5000);
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "ERROR, no se pudo hacer el login");

        // Logout
        menuSection.logoutButton.click();
        Thread.sleep(5000);
        Assertions.assertTrue(mainPage.loginImage.isControlDisplayed(), "ERROR, no se pudo hacer el logout");
    }
}
