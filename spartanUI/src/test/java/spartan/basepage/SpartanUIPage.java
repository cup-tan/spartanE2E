package spartan.basepage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spartan.utilities.Driver;

import java.util.List;

public class SpartanUIPage {

   public SpartanUIPage(){
      PageFactory.initElements(Driver.getDriver(),this);
   }

   @FindBy(id = "add_spartan_btn")
   private WebElement addSpartanButton;
   @FindBy(xpath = "//table[@id='myTable']//td[7]")
   private List<WebElement> deleteAllSpartan;

   public List<WebElement> getDeleteAllSpartan() {
      return deleteAllSpartan;
   }

   @FindBy(xpath = "//table[@id='myTable']//tr//td[2]")
    private List<WebElement> allSpartanNames;
   @FindBy(xpath = "//table[@id='myTable']//tr//td[1]")
   private List<WebElement> allSpartanId;



   public List<WebElement> getAllSpartanId() {
      return allSpartanId;
   }

   public List<WebElement> getAllSpartanNames() {
      return allSpartanNames;
   }


   public WebElement getAddSpartanButton() {
      return addSpartanButton;
   }
}
