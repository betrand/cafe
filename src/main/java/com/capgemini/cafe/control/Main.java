package com.capgemini.cafe.control;

import com.capgemini.cafe.model.service.Billing;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public class Main {

 public static void main(String[] args) {
  System.out.println(Billing.getBill(args));
 }
}
