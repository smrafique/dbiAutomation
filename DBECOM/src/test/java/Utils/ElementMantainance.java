package Utils;

import Configs.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementMantainance extends Select {

    public WebDriverWait wait;
    public WebElement webElement;


    public WebElement webElement(String elementType, String element) {
        wait = new WebDriverWait(driver, 10);

        if (elementType.equals("id")) {
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        }
        if (elementType.equals("css")){
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
        }
        if (elementType.equals("xpath")){
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        }
        if (elementType.equals("link")){
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
        }
        if (elementType.equals("class")){
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
        }
        if (elementType.equals("pLink")){
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
        }
        return webElement;
    }

    public void ElementNeedsToBeClicked(WebElement we){
                we.click();

    }

    public void TextNeedsToBeSend(WebElement we, String text){
        we.sendKeys(text);
    }



}
