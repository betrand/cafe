package com.capgemini.cafe.model.util;

import java.math.BigDecimal;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public class Amount {

    private static String amt = "0.00";

    public Amount() {
        amt = "0.00";
    }

    public Amount add(String amount) {
        amt = new BigDecimal(amount).add(new BigDecimal(amt)).toPlainString();
        return this;
    }

    public String toMoney() {
        int pound = Integer.parseInt(amt.substring(0, amt.indexOf(".")));
        if (pound < 1) {
            int pence = Integer.parseInt(amt.substring(amt.indexOf(".") + 1, amt.length()));
            return new StringBuilder().append(pence).append("p").toString();
        }
        return new StringBuilder().append("£").append(amt).toString();
    }

}
