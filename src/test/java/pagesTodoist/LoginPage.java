package pagesTodoist;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public TextBox emailTxtBox = new TextBox(By.id("email"));
    public TextBox pwdTxtBox = new TextBox(By.id("password"));
    public Button loginButton = new Button(By.xpath("//button[text()=\"Log in\"]"));

    public void login (String email, String pwd){
        this.emailTxtBox.setText(email);
        this.pwdTxtBox.setText(pwd);
        this.loginButton.click();
    }
}
