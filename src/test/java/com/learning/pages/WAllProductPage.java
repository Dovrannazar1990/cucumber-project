package com.learning.pages;

import com.learning.utility.BrowserUtil;
import com.learning.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WAllProductPage {

    // You can store all elements one by one
    // Or we can store by entire row
    @FindBy(xpath = "//table[@class='ProductsTable']//tr/th")
    private List<WebElement> allHeaderRowCells;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr[2]/td")
    private List<WebElement> firstRowCells;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr[3]/td")
    private List<WebElement> secondRowCells;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr[4]/td")
    private List<WebElement> thirdRowCells;


    public WAllProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    // Store all rows text values as List<String>
    public List<String> getAllHeaderText() {

//        List<String> allTextLst = new ArrayList<>();
//        for (WebElement eachElement : allHeaderRowCells) {
//            allTextLst.add(eachElement.getText());
//        }
        return BrowserUtil.getAllText(allHeaderRowCells);
    }

    // Eventually each row in expected result in step definition
    // is represented as a map
    // So one way to organize our method is
    // just to get actual result as a map, so we can do map to map comparison

    public Map<String, String> getRowMapFromWebTable() {

        // We want to create a map:
        // - key as column name
        // - value as cell value
        Map<String, String> rowMap = new LinkedHashMap<>();
        // how to get all headers, so we can use as key
        List<String> allHeaders = BrowserUtil.getAllText(allHeaderRowCells);
        // how to get all first row, so we can use as value
        List<String> allFirstRow = BrowserUtil.getAllText(firstRowCells);

        // Grab first header and use as key. Grab first row cell and use it as value
//        rowMap.put(allHeaders.get(0), allFirstRow.get(0));
//        rowMap.put(allHeaders.get(1), allFirstRow.get(1));
//        rowMap.put(allHeaders.get(2), allFirstRow.get(2));

        for (int colIndex = 0; colIndex < allHeaders.size(); colIndex++) {
            // Go through each column and add column header as key and value as cell value
            rowMap.put(allHeaders.get(colIndex), allFirstRow.get(colIndex));
        }
        return rowMap;
    }
}