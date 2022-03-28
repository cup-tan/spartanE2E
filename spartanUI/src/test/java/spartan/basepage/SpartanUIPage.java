package spartan.basepage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spartan.utilities.Driver;

public class SpartanUIPage {

   public SpartanUIPage(){
      PageFactory.initElements(Driver.getDriver(),this);
   }

   @FindBy(id = "add_spartan_btn")
   private WebElement addSpartanButton;

   @FindBy(xpath = "//table[@id='myTable']//tr//td[2]")
    private WebElement allSpartanNames;

   public WebElement getAllSpartanNames() {
      return allSpartanNames;
   }

   public WebElement getAddSpartanButton() {
      return addSpartanButton;
   }
}
