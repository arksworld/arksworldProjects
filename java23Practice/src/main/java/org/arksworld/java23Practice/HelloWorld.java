package org.arksworld.java23Practice;

import java.util.List;
import java.util.function.Consumer;

public class HelloWorld {
  public static void main(String[] args) {
    List<String> items = List.of("a", "d", "12", "rs", "g3");

    String name = "John Wick";

    int aVal = 'a';
    int zVal = 'z';
    int Aval = 'A';
    int Zval = 'Z';
    System.out.println("a=" + aVal + ", z=" + zVal + ", A = " + Aval + ", Z = " + Zval);
    // Lambda
    items.forEach(item -> {
      if(item.equalsIgnoreCase("A")) {
        System.out.println("Found A");
      } else {
        System.out.println("Not an A");
      }
    });

    //Consumer route
    items.forEach(new Consumer<String>() {
      @Override
      public void accept(String item) {
        if(item.equalsIgnoreCase("A")) {
          System.out.println("Found A");
        } else {
          System.out.println("Not an A");
        }
      }
    });

  }
}
