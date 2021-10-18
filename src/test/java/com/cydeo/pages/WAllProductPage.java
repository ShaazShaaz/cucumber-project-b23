package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WAllProductPage {
    // store all elements one by one or u can store by entire row
    @FindBy(xpath = "//table[@class='ProductsTable']//th")
    private List<WebElement> allHeaderRowCell;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr[2]/td")
    private List<WebElement> firstRowCells;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr[3]/td")
    private List<WebElement> secondRowCells;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr[4]/td")
    private List<WebElement> thirdRowCells;


    public WAllProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // store all row text value as list of string
    public List<String> getAllHeaderText(){
        return BrowserUtil.getAllText(allHeaderRowCell) ;

    }

    // each row in step definition is represented as a map
    // so get actual result as a map and assert

    public Map<String,String> getRowMapFromWebTable(){
        // we want to create a map :
        // -key as column name
        // -value as cell value
        Map<String,String> rowMap=new LinkedHashMap<>();

        // how to get all header so we cn use as key
        List<String> allHeaders=BrowserUtil.getAllText(allHeaderRowCell);
        // how to get all first row so we cn use as value
        List<String> allFirstRow=BrowserUtil.getAllText(firstRowCells);

        // grab first header and use as key, grab first row cell and use value
       // rowMap.put(allHeaders.get(0),allFirstRow.get(0));

        // to run it for all 3 header columns, run it in a loop
        for (int columnIndex = 0; columnIndex <allHeaders.size() ; columnIndex++) {
            rowMap.put(allHeaders.get(columnIndex), allFirstRow.get(columnIndex));

        }
       return rowMap;
    }
}
