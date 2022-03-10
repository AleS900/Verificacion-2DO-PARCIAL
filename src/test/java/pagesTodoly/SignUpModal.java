package pagesTodoly;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class SignUpModal {
    public TextBox userNameTxtBox = new TextBox(By.xpath("//input[@id=\"ctl00_MainContent_SignupControl1_TextBoxFullName\"]"));
    public TextBox emailTxtBox = new TextBox(By.xpath("//input[@id=\"ctl00_MainContent_SignupControl1_TextBoxEmail\"]"));
    public TextBox passwordTxtBox = new TextBox(By.xpath("//input[@id=\"ctl00_MainContent_SignupControl1_TextBoxPassword\"]"));
    public Button checkBox = new Button(By.xpath("//input[@id=\"ctl00_MainContent_SignupControl1_CheckBoxTerms\"]"));
    public Button signUpButton = new Button(By.xpath("//input[@id=\"ctl00_MainContent_SignupControl1_ButtonSignup\"]"));


    public void signUp(String userName, String email, String pwd){
        this.userNameTxtBox.setText(userName);
        this.emailTxtBox.setText(email);
        this.passwordTxtBox.setText(pwd);
        this.checkBox.click();
        this.signUpButton.click();
    }
}
