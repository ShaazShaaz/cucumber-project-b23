package com.cydeo.pages;

import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    // add 3 elements that hold numbers
    // add @FindBy annotation
    // add constructor
    // add 3 methods for getting numbers

    @FindBy(id="user_count")
    private WebElement userCount;

    @FindBy(id="book_count")
    private WebElement bookCount;

    @FindBy(id="borrowed_books")
    private WebElement borrowedCount;

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getUserCountText(){
        return userCount.getText();

    }

    public String getBookCountText(){
        return bookCount.getText();

    }

    public String getBorrowedBookCountText(){
        return borrowedCount.getText();

    }

}
