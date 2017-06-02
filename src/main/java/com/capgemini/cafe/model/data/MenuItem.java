package com.capgemini.cafe.model.data;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public enum MenuItem {

 COLA("Cola", "0.50", false),
 COFFEE("Coffee", "1.00", true),
 CHEESE_SANDWICH("Cheese Sandwich", "2.00", false);

 private final String item;
 private final String price;
 private final boolean isHot;

 MenuItem(String item, String price, boolean isHot) {
  this.item = item;
  this.price = price;
  this.isHot = isHot;
 }

 public String getItem() {
  return item;
 }

 public String getPrice() {
  return price;
 }

 public boolean isHot() {
  return isHot;
 }

 @Override
 public String toString() {
  return this.item;
 }
}
