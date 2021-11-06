package com.learning.step_definitions;

import com.learning.pages.WAllProductPage;
import com.learning.pages.WCommonArea;
import com.learning.pages.WOrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WebOrderStepDefs {
    @When("we select {string} tab from sidebar")
    public void weSelectTabFromSidebar(String tabName) {
        System.out.println("tabName = " + tabName);
        WCommonArea commonArea = new WCommonArea();
        switch (tabName) {
            case "View all products":
                commonArea.viewAllProductTab.click();
                break;
            case "View all orders":
                commonArea.viewAllOrderTab.click();
                break;
            case "Order":
                commonArea.orderTab.click();
                break;
        }
    }

    @Then("we should see below option in Product dropdown list")
    public void weShouldSeeBelowOptionInProductDropdownList(List<String> expectedOptions) {
        System.out.println("expectedOptions = " + expectedOptions);
        WOrderPage orderPage = new WOrderPage();

        List<String> actualOptions = orderPage.getAllProductOptionFromList();

        // assert these two list are equal
        // import static org.junit.Assert.assertEquals;
        assertEquals(expectedOptions, actualOptions);
    }

    @Then("we should see table with below content")
    public void weShouldSeeTableWithBelowContent(List<Map<String, String>> productMapLst) {

        System.out.println("productMapLst = " + productMapLst);

        // How to get first map
        Map<String, String> expectedFirstRowMap = productMapLst.get(0);

        WAllProductPage allProductPage = new WAllProductPage();

        System.out.println("allProductPage.getRowMapFromWebTable() = "
                + allProductPage.getRowMapFromWebTable());

        Map<String, String> actualFirstRowMap = allProductPage.getRowMapFromWebTable();

        // assert two maps are equal
        assertEquals(expectedFirstRowMap, actualFirstRowMap);

        // assert the first row match from datatable and web table

//        // Get expected headers:
//        Set<String> headerSet = productMapLst.get(0).keySet();
//        System.out.println("headerSet = " + headerSet);
//
//        // Get actual headers:
//        List<String> actualHeaders = allProductPage.getAllHeaderText();
//        System.out.println("actualHeaders = " + actualHeaders);
//
//        // Check the size is the same
//        assertEquals(headerSet.size(), actualHeaders.size());
//
//        // list to set equality check will not work
//        // So we need to turn the set into list
//        List<String> expectedHeaders = new ArrayList<>(headerSet);
//        assertEquals(expectedHeaders, actualHeaders);
    }
}