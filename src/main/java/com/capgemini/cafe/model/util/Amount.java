package com.capgemini.cafe.model.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public class Amount {

    private static String amt = "0.00";
    private static final String FOOD_SERVICE_CHARGE = "0.10";
    private static final String HOT_FOOD_SERVICE_CHARGE = "0.20";
    private static final int MAX_HOT_FOOD_SERVICE_CHARGE = 20;

    public Amount() {
        amt = "0.00";
    }

    /**
     *
     * @param amount
     * @return Amount incremented with amount
     */
    public Amount add(String amount) {
        amt = new BigDecimal(amount).add(new BigDecimal(amt)).toPlainString();
        return this;
    }

    /**
     *
     * @return total bill Amount with 10% service charge if Purchase Items
     * contain Food no maximum service charges apply
     */
    public Amount addFoodServiceCharge() {
        BigDecimal total = new BigDecimal(amt);
        amt = total.add(total.multiply(new BigDecimal(FOOD_SERVICE_CHARGE))
                .setScale(2, RoundingMode.HALF_EVEN)).toPlainString();
        return this;
    }

    /**
     *
     * @return total bill Amount with 20% service charge if Purchase Items
     * contain Hot Food up to a maximum of £20
     */
    public Amount addHotFoodServiceCharge() {
        BigDecimal total = new BigDecimal(amt);
        BigDecimal totalServiceCharge = total.add(total.multiply(new BigDecimal(
                HOT_FOOD_SERVICE_CHARGE)).setScale(2, RoundingMode.HALF_EVEN));
        if (new BigDecimal(MAX_HOT_FOOD_SERVICE_CHARGE).compareTo(totalServiceCharge) < 1) {
            totalServiceCharge = total.add(new BigDecimal(MAX_HOT_FOOD_SERVICE_CHARGE))
                    .setScale(2, RoundingMode.HALF_EVEN);
        }
        amt = totalServiceCharge.toPlainString();
        return this;
    }

    /**
     *
     * @return a String format of the Amount
     */
    public String toMoney() {
        int pound = Integer.parseInt(amt.substring(0, amt.indexOf(".")));
        if (pound < 1) {
            int pence = Integer.parseInt(amt.substring(amt.indexOf(".") + 1, amt.length()));
            return new StringBuilder().append(pence).append("p").toString();
        }
        return new StringBuilder().append("£").append(amt).toString();
    }

}
