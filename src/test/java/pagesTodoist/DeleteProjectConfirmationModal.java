package pagesTodoist;

import control.Button;
import org.openqa.selenium.By;

public class DeleteProjectConfirmationModal {
    public Button projectConfirmDeleteButton = new Button(By.xpath("//button[text()=\"Eliminar\"]"));
}
