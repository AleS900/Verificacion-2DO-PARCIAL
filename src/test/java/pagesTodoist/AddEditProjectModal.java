package pagesTodoist;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class AddEditProjectModal {
    // Create & Update
    public TextBox projectNameTxtBox = new TextBox(By.id("edit_project_modal_field_name"));
    public Button submitButton = new Button(By.xpath("//button[@type=\"submit\"]"));
}
