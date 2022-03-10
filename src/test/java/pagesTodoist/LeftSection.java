package pagesTodoist;

import control.*;
import org.openqa.selenium.By;

public class LeftSection {
    // Create
    public Button createProjectButton = new Button(By.xpath("//button[@class=\"adder_icon\"]"));
    //Update
    public Button displayMenuButton = new Button(By.xpath("//div[@class=\"reactist collapse collapse--entered\"]//li[last()]//button"));
    public Button projectEditButton = new Button(By.xpath("//div[text()=\"Editar proyecto\"]"));
    //Delete
    public Button projectDeleteButton = new Button(By.xpath("//div[text()=\"Eliminar proyecto\"]"));

    public  LeftSection(){}

    public void clickNameProject(String name){
        Label nameProject = new Label(By.xpath("//a//span[text()=\""+name+"\"]"));
        nameProject.click();
    }

    public boolean isProjectNameDisplayed(String name){
        Label nameProject = new Label(By.xpath("//a//span[text()=\""+name+"\"]"));
        return nameProject.isControlDisplayed();
    }

    public String getProjectName(String name){
        Label nameProject = new Label(By.xpath("//li[last()]//span[text()=\""+ name +"\"]"));
        return nameProject.getTextControl();
    }
}