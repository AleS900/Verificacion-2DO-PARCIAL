package testClean;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pagesTodoly.MainPage;
import pagesTodoly.MenuSection;
import pagesTodoly.SignUpModal;

import java.util.Date;

public class E5SignUpTest extends BaseTodoLy {
    MainPage mainPage = new MainPage();
    SignUpModal signUpModal = new SignUpModal();
    MenuSection menuSection = new MenuSection();
    long microSec = new Date().getTime();
    int random = (int) (microSec%1000);
    String email = "santiavctf"+random+"@gmail.com";
    String userName = "Santiago";
    String password = "Santiago900";

    @Test
    public void verifySignUp() throws InterruptedException {
        // Sign Up
        mainPage.signInImage.click();
        signUpModal.signUp(userName, email,password);
        Thread.sleep(5000);
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "ERROR, no se pudo hacer el login");
    }
}
