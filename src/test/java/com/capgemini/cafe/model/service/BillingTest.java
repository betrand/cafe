package com.capgemini.cafe.model.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public class BillingTest {

    /**
     * Test that an empty String list returns 0p
     *
     */
    @Test
    public void testGetBillEmptyList() {
        String[] purchaseItems = new String[0];
        String expResult = "0p";
        String result = Billing.getBill(purchaseItems);
        assertEquals(expResult, result);
    }

    /**
     * Test that a String list containing an Unknown Item returns 0p
     *
     */
    @Test
    public void testGetStandardBillForUnknownItem() {
        String[] purchaseItems = {"Coffe"};
        String expResult = "0p";
        String result = Billing.getBill(purchaseItems);
        assertEquals(expResult, result);
    }

    /**
     * Test that a list of only drink returns correct Bill with no Service
     * Charge.
     *
     */
    @Test
    public void testGetStandardBill() {
        String[] purchaseItems = {"Cola", "Coffee"};
        String expResult = "£1.50";
        String result = Billing.getBill(purchaseItems);
        assertEquals(expResult, result);
    }

    /**
     * Test that a list of drink & Cold Food Items returns correct Bill
     *
     */
    @Test
    public void testGetBillForDrinksAndColdFood() {
        String[] purchaseItems = {"Cola", "Coffee", "Cheese Sandwich"};
        String expResult = "£3.85";
        String result = Billing.getBill(purchaseItems);
        assertEquals(expResult, result);
    }

    /**
     * Test that a list of drink, cold & hot Food Items returns correct Bill
     * with 20% Service Charge.
     *
     */
    @Test
    public void testGetBillForDrinksColdAndHotFood() {
        String[] purchaseItems = {"Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich"};
        String expResult = "£9.60";
        String result = Billing.getBill(purchaseItems);
        assertEquals(expResult, result);
    }

    /**
     * Test that a list of drink, cold & hot Food Items returns correct Bill
     * with 20% Service Charge however applies only a maximum of £20 service
     * charge when items contain hot food.
     *
     */
    @Test
    public void testGetBillForDrinksColdAndHotFoodMax() {
        String[] purchaseItems = {"Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich"};
        String expResult = "£146.00";
        String result = Billing.getBill(purchaseItems);
        assertEquals(expResult, result);
    }

}
