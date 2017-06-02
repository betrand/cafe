package com.capgemini.cafe.model.data;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public enum MenuItem {

 COLA("Cola", "0.50", false, false),
 COFFEE("Coffee", "1.00", true, false),
 CHEESE_SANDWICH("Cheese Sandwich", "2.00", false, true),
 STEAK_SANDWICH("Steak Sandwich", "4.50", true, true);

 private final String item;
 private final String price;
 private final boolean isHot;
 private final boolean isFood;

 MenuItem(String item, String price, boolean isHot, boolean isFood) {
  this.item = item;
  this.price = price;
  this.isHot = isHot;
  this.isFood = isFood;
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

 public boolean isFood() {
  return isFood;
 }

 @Override
 public String toString() {
  return this.item;
 }
}
