package com.capgemini.cafe.model.service;

import com.capgemini.cafe.model.data.MenuItem;
import com.capgemini.cafe.model.util.Amount;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public class Billing {

    /**
     *
     * @param list - A List of Purchase Items
     * @return the total bill 
     */
    public static String getBill(String[] list) {
        List<String> items = Arrays.asList(list);
        return standardBill(items).toMoney();
    }

    /**
     *
     * @param items - A String Array of Purchase Items
     * @return the total bill Amount for the purchase Items or 0p Amount
     * otherwise
     */
    public static Amount standardBill(List<String> items) {
        Amount amount = new Amount();

        if (items.isEmpty()) {
            return amount;
        }

        for (String purchaseItem : items) {
            MenuItem item = getItem(purchaseItem);
            if (item == null) {
                return new Amount();
            }
            amount = amount.add(item.getPrice());
        }

        return amount;
    }

    /**
     *
     * @param itemName - A Purchase Item Name
     * @return the Enum or null if Item is not found
     */
    private static MenuItem getItem(String itemName) {
        for (MenuItem item : MenuItem.values()) {
            if ((itemName).equals(item.getItem())) {
                return item;
            }
        }
        return null;
    }

}
