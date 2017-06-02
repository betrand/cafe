package com.capgemini.cafe.model.service;

import com.capgemini.cafe.model.data.MenuItem;
import com.capgemini.cafe.model.util.Amount;
import java.util.ArrayList;
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
     * @return the total bill with 10% service charge if Purchase Items contain
     * food but if Purchase Items contains Hot Food a 20% service charge will
     * apply up to a maximum of £20
     */
    public static String getBill(String[] list) {
        List<String> items = Arrays.asList(list);

        if (new ArrayList<>().equals(items)) {
            return new Amount().toMoney();
        }

        if (serviceChargeApplies(items)) {
            if (hotFoodServiceChargeApplies(items)) {
                return standardBill(items).addHotFoodServiceCharge().toMoney();
            }
            return standardBill(items).addFoodServiceCharge().toMoney();
        }
        return standardBill(items).toMoney();
    }

    /**
     *
     * @param items - A List of Items to check if any is food which attracts a
     * service charge
     * @return true if any item is Food
     */
    private static boolean serviceChargeApplies(List<String> items) {
        for (String purchaseItem : items) {
            MenuItem item = getItem(purchaseItem);
            if (item != null && item.isFood()) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param items - A List of Items to check if Hot Food service charge
     * applies
     * @return true if any item is Hot Food
     */
    private static boolean hotFoodServiceChargeApplies(List<String> items) {
        for (String purchaseItem : items) {
            MenuItem item = getItem(purchaseItem);
            if (item != null && item.isHot() && item.isFood()) {
                return true;
            }
        }
        return false;
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
