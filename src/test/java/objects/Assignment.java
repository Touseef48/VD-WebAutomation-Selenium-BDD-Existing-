package objects;
import com.mysql.cj.exceptions.AssertionFailedException;
import config.ConfigProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import general.MainCall;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

    /*
    -----------------------------------------------------------
        locators for Add Dove Brand items to cart using X-path
    -----------------------------------------------------------
    */
    public static By getSelectDoveBrand = By.xpath("//img[@alt='Dove']");
    public static By selectnewitem = By.xpath("//div[@class='thumbnail']/a");
    public static By clickAddToCart = By.xpath("//a[@class='cart']");
    public static By assertQuantity = By.xpath("//*[@id='cart_quantity76']");
    public static By assertItem = By.linkText("Men+Care Clean Comfort Deodorant");

    /*
    -------------------------------------------------------------------------
        locators for Adding Men medium T-shirt and Shoes using CSS Selectors
    -------------------------------------------------------------------------
    */

    public static By getAPPARELACCESSORIESsection = By.cssSelector("[href='https://automationteststore.com/index.php?rt=product/category&path=68']");
    public static By selectTshirtOption = By.cssSelector(":nth-child(2) > .mt10 > a");
    public static By sortItems = By.cssSelector("#sort");
    public static By selectShirt = By.cssSelector(":nth-child(6) > .thumbnail > :nth-child(1) > img");
    public static By selectMediumSize = By.cssSelector("#option351");
    public static By addToCart = By.cssSelector(".cart");
    public static By clickShoes = By.cssSelector(":nth-child(1) > .mt10 > a");
    public static By selectShoes = By.cssSelector(":nth-child(1) > .thumbnail > :nth-child(1) > img");
    public static By itemQuantity = By.cssSelector("#product_quantity");
    public static By assert1 = By.cssSelector(".table > tbody > :nth-child(2) > :nth-child(2) > a");
    public static By assert2 = By.cssSelector("tbody > :nth-child(3) > :nth-child(2) > a");
    public static By assert3 = By.cssSelector("#cart_quantity1159decaced08ca7c307cce3840afceda7f");

    /*
    -----------------------------------------------------------
        locators for Adding Men catagory item that ends with M
    -----------------------------------------------------------
    */

    public static By selectMenCategory = By.xpath("//a[@href='https://automationteststore.com/index.php?rt=product/category&path=58']");
    public static By selectItemEndsWithMLetter = By.xpath("//a[@title='ck IN2U Eau De Toilette Spray for Him']");
    public static By Cart = By.xpath("//a[@class='cart']");
    public static By AssetCart = By.linkText("ck IN2U Eau De Toilette Spray for Him");

    /*
    ------------------------------------------------------------------------------------------------------
    ------------------------------------------------------------------------------------------------------
    ------------------------------------------------------------------------------------------------------ */

    public static void arriveToLogin()
    {
        try {
            MainCall.webDriverFactory.getInstance();
        } catch (Exception exception) {
            throw new AssertionFailedException(exception.getMessage());
        }
    }

    /*
    -------------------------------------------------
    Add Dove Brand (Newest) item to cart using Xpath
    -------------------------------------------------
    */
    public static void clickDoveBrand()
    {
        MainCall.seleniumFunctions.PressButton(getSelectDoveBrand);
    }
    public static void setSelectnewitem(){
        MainCall.seleniumFunctions.PressButton(selectnewitem);
    }
    public static void clickAddToCart(){
        MainCall.seleniumFunctions.PressButton(clickAddToCart);
    }
    public static void AssertText(){
        MainCall.seleniumFunctions.VerificationMessageByMessage(assertQuantity,"1");
    }
    public static void AssertValue(){
        MainCall.seleniumFunctions.VerificationMessageByMessage(assertItem,"Men+Care Clean Comfort Deodorant");
    }

    /*
    ------------------------------------------------------------------------
        Add Accessories T-shirts and Shoes item to cart using CSS-Selectors
    ------------------------------------------------------------------------
    */

    public static void selectAccessoriesSection(){
        MainCall.seleniumFunctions.PressButton(getAPPARELACCESSORIESsection);
    }
    public static void selectMenNav(){
        MainCall.seleniumFunctions.PressButton(selectMenCategory);
    }
    public static void selectTshirts(){
        MainCall.seleniumFunctions.PressButton(selectTshirtOption);
    }
    public static void sortShirts(){
        MainCall.seleniumFunctions.SelectDropdown(sortItems,"Price Low > High");
    }
    public static void selectLowValueMediumShirt(){
        MainCall.seleniumFunctions.PressButton(selectShirt);
        MainCall.seleniumFunctions.SelectDropdown(selectMediumSize,"Medium");
    }
    public static void addShirtToCart(){
        MainCall.seleniumFunctions.PressButton(addToCart);
    }
    public static void selectShoesOption(){
        MainCall.seleniumFunctions.PressButton(clickShoes);
    }
    public static void addHighRatedShoesToCart(){
        MainCall.seleniumFunctions.SelectDropdown(sortItems,"Rating Highest");
        MainCall.seleniumFunctions.PressButton(selectShoes);
        MainCall.seleniumFunctions.SendKeys(itemQuantity,"2");
        MainCall.seleniumFunctions.PressButton(addToCart);
    }
    public static void assertAccessoriesInCart(){
        MainCall.seleniumFunctions.VerificationMessageByMessage(assert1,"Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie");
        MainCall.seleniumFunctions.VerificationMessageByMessage(assert2,"Fiorella Purple Peep Toes");
        //MainCall.seleniumFunctions.VerificationMessageByMessage(assert3,"2");
    }

    /*
    --------------------------------------------------------------------
    Add Men Category Item to cart (name end with letter M) Using x-Path
    --------------------------------------------------------------------
    */
    public static void addItemEndsWithMToCart(){
        MainCall.seleniumFunctions.PressButton(selectItemEndsWithMLetter);
    }
    public static void cart(){
        MainCall.seleniumFunctions.PressButton(Cart);
    }
    public static void verify(){
        MainCall.seleniumFunctions.VerificationMessageByMessage(AssetCart,"ck IN2U Eau De Toilette Spray for Him");
    }
}
