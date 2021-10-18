package com.cydeo.utility;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrderUtility {

    // create a Class WebOrderUtility
    //create a static void method called login(username,password)

    public static void login() {

        // enter username
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        //enter password
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        //click login button
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();


    }

    public static void login(String username, String password) {

        // enter username
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username);

        //enter password
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys(password);

        //click login button
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();


    }

    public static void logout() {
        // log out link has id ctl00_logout
        Driver.getDriver().findElement(By.id("ctl00_logout")).click();

    }

    public static boolean isAtOrderPage() {
        // you can also check the url
        // you can check the title if it's different
        // whatever that makes sense
        // in here we decided to check one element
        boolean result = false;

        // locator for the header element of all order page
        //h2[normalize-space(.)='List of All Orders']
        /*
        try{
            WebElement header = Driver.getDriver().findElement(By.xpath("//h2[normalize-space(.)='List of All Orders']"));
            System.out.println("ELEMENT WAS IDENTIFIED ");
            System.out.println("header.isDisplayed() = " + header.isDisplayed());
            result = true ;
        }catch (NoSuchElementException e){
            System.out.println("NO Such element! you are not at the right page");
        }
         */
        WebElement header = Driver.getDriver().findElement(By.xpath("//h2[normalize-space(.)='List of All Orders']"));
        System.out.println("ELEMENT WAS IDENTIFIED ");
        System.out.println("header.isDisplayed() = " + header.isDisplayed());
        result = true;
        if (result = true) {
            System.out.println("ELEMENT WAS IDENTIFIED ");
        } else {
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space(.)='List of All Orders']")));
        }

        return result;
//        System.out.println("header.isDisplayed() = " + header.isDisplayed());

    }

    public static void openWebOrderApp() {
        Driver.getDriver().navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
       // Driver.getDriver().navigate().to(ConfigReader.read("https://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx"));
    }

    public static boolean verifyUserName(String username) {
        openWebOrderApp();
        login("Tester", "test");
        WebElement message = Driver.getDriver().findElement(By.cssSelector(".login_info"));
        if (message.getText().contains(username)) {
            System.out.println("Test Passed");
            return true;
        } else {
            return false;
        }

    }


    public static void selectSideBar(String tabName) {
        openWebOrderApp();
        login("Tester", "test");

        List<WebElement> list = Driver.getDriver().findElements(By.cssSelector("#ctl00_menu"));
        for (WebElement each : list) {
            if (each.getText().equalsIgnoreCase(tabName)) {
                each.click();
            }

        }


    }

    /*
      Create a method `checkAll`
   1. accept no param , return `boolean`
   2. click on `Check All` button
   3. return `true` if all checkboxes are checked , false if any left unchecked

     */
    public static boolean checkAll() {
        openWebOrderApp();
        login("Tester", "Test");
        WebElement selectAllbtn = Driver.getDriver().findElement(By.xpath("//a[text()='Check All']"));
        selectAllbtn.click();

        List<WebElement> checkbox = Driver.getDriver().findElements(By.cssSelector("[type='checkbox']"));

        int count = 0;
        for (WebElement eachBox : checkbox) {
            if (eachBox.isSelected()) {
                count++;
            }
            }
        if (count == checkbox.size()) {
            return true;
        } else {
            return false;
        }


    }
    /*
     Create a method `uncheckAll`
   1. accept no param , return `boolean`
   2. click on `Uncheck All` button
   3. return `true` if all checkboxes are unchecked , false if any left checked

     */

    public static boolean uncheckAll(){
        openWebOrderApp();
        login("Tester", "Test");
        WebElement uncheckAllbtn = Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        uncheckAllbtn.click();

        List<WebElement> checkbox = Driver.getDriver().findElements(By.cssSelector("[type='checkbox']"));

        int count = 0;
        for (WebElement eachBox : checkbox) {
            if (eachBox.isSelected()) {
                count++;
            }
        }
        if (count ==0) {
            return true;
        } else {
            return false;
        }



    }

    /*
    Create a method `getAllProducts`
    1.  accept no param ,
    2.  return `List<String>`
    3.  click on `View All Products` tab
    4.  save each cell value in first column `Product name` in the table into `List<String>`
     */

    public static List<String> getAllProducts(){
WebElement viewProductsButton=Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='View all orders']"));
viewProductsButton.click();


List<WebElement> list=Driver.getDriver().findElements(By.xpath("//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[2]/table/tbody//td[1]"));
        List<String> result=new ArrayList<String>();
        for (WebElement each:list) {
            result.add(each.getText());

        }
        return  result;

    }

    /*
     Create a method `getUnitPriceFromForm`
    1.  accept `String productName`
    2.  return `int` for unit price
    3.  It should
        1.  select product from product dropdown list
        2.  click `calculate` button
        3.  get the value attribute of `Price per unit:` input box
        4.  return it from the method.
     */

    public static int getUnitPriceFromForm(String productName){
        int valueAttribute=0;
        WebElement orderButton=Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']/li[3]"));
        orderButton.click();
        WebElement productDropDown=Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        productDropDown.click();
        Driver.getDriver().findElement(By.partialLinkText(productName)).click();
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        WebElement pricePerUnit=Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtUnitPrice"));
        valueAttribute=Integer.valueOf(pricePerUnit.getAttribute("value"));
        return valueAttribute;


    }

    /*
    Create a method `getDiscountFromForm`
    1.  accept `String productName` , `int quantity`
    2.  return `int` for discount
    3.  It should
        1.  select `productName` from product dropdown list
        2.  Enter `quantity` into `Quantity:*` inputbox (Fact : discount apply only if quantity is 10+)
        3. click `calculate` button
        4. get text attribute of `discount` inputbox and return from the method.
     */
    public static int getDiscountFromForm(String productName,int quantity){
        WebElement orderButton=Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']/li[3]"));
        orderButton.click();
        WebElement productDropDown=Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        productDropDown.click();
        WebElement product=Driver.getDriver().findElement(By.xpath("//select"));
        Select name=new Select(product);
        name.selectByValue(productName);
        WebElement quantityBox=Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityBox.sendKeys(""+quantity);
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        WebElement discountBox=Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtDiscount"));
        return  Integer.valueOf(discountBox.getAttribute("value"));



    }

    /*
     13. Create a method `calculateTotal`
    1.  accept `String productName` , `int quantity`
    2. return `int` for total
    3. It should
       1.  select `productName` from product dropdown list
       2.  Enter `quantity` into `Quantity:*` inputbox
       3.  Click `calculate` button
       4.  get text attribute of `Total` inputbox and return from the method.
     */
    public static int calculateTotal(String productName,int quantity){
        WebElement orderButton=Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']/li[3]"));
        orderButton.click();
        WebElement productDropDown=Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        productDropDown.click();
        WebElement product=Driver.getDriver().findElement(By.xpath("//select"));
        Select name=new Select(product);
        name.selectByValue(productName);
        WebElement quantityBox=Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityBox.sendKeys(""+quantity);
        WebElement calculate=Driver.getDriver().findElement(By.cssSelector(".btn_dark"));
        calculate.click();
        WebElement total=Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtTotal"));
        return Integer.valueOf(total.getAttribute("value"));

    }

    /*
    Create a method `getExpectedDiscount`
    1.  accept `String productName` , `int quantity`
    2.  return `discount` amount according to `productName`,`quantity`
    3.  It should
        - if `quantity` is less than 10
          - return `0`
        - else according to all products table
          - return `correct discount number` : 8 , 15, 10
        - This is all java no selenium code.
     */

    public static int getExpectedDiscount(String productName,int quantity){
        WebElement orderButton=Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']/li[3]"));
        orderButton.click();
        WebElement productDropDown=Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        productDropDown.click();
        WebElement product=Driver.getDriver().findElement(By.xpath("//select"));
        Select name=new Select(product);
        name.selectByValue(productName);
        WebElement quantityBox=Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityBox.sendKeys(""+quantity);
        WebElement calculate=Driver.getDriver().findElement(By.cssSelector(".btn_dark"));
        calculate.click();
        WebElement discountBox=Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtDiscount"));
        return  Integer.valueOf(discountBox.getAttribute("value"));


    }



    public static void enterAddressInfo () {
        WebElement fullName = Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        Faker faker = new Faker();
        fullName.sendKeys(faker.name().fullName());
        WebElement street = Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys(faker.address().streetAddress());
        WebElement city = Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys(faker.address().city());
        WebElement state = Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys(faker.address().state());
        WebElement zipcode = Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zipcode.sendKeys(faker.numerify("#####"));




    }
    public static void enterPaymentInfo(){
        WebElement creditCardNumber = Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        Faker faker = new Faker();
        WebElement radioButton = Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_2"));
        radioButton.click();
        creditCardNumber.sendKeys(faker.numerify("################"));
        WebElement expireDate = Driver.getDriver().findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expireDate.sendKeys(faker.numerify("0#/0#"));



    }


    //check login error msg visible or not
    public static boolean loginErrorMsgVisible(){
        return BrowserUtil.checkVisibilityOfElement(By.xpath("//span[.='Invalid Login or Password.']"),2);

    }
}

