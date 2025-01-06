package org.arksworld.java23Practice.enums;

public class EnumClass {

  public static final EnumClass INSTANCE =new EnumClass("John");

  private String name;

  private EnumClass(String name) {
    this.name = name;
  }



}
