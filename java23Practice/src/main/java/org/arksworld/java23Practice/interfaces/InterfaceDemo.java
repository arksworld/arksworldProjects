package org.arksworld.java23Practice.interfaces;

import java.util.Date;

public interface InterfaceDemo {

  default void sayHello() {
    System.out.println("Hello from interface demo");
  }

  private static void greet(String msg) {
    logGreeting(msg);
    System.out.println("Hello greeting message:" + msg);
  }

  private static void logGreeting(String greeting) {
    System.out.println("LOG: Greeting message " + greeting + " received at " + new Date());
  }
  public static void main(String[] args) {
    System.out.println("Inside an interface");
    greet("Have a nice day!");
  }
}
