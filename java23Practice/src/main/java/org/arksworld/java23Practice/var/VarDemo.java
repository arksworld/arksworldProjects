package org.arksworld.java23Practice.var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VarDemo {
  public static void main(String[] args) {
    var i = 10;
    var genderMapping = new HashMap<Character, String>();
    genderMapping.put('M', "Male");
    genderMapping.put('F', "Female");
    genderMapping.put('U', "Unknown");
    var names = new ArrayList<String>();
    names.addAll(List.of("John", "Jake"));
    printList(names);
  }

  public static void printList(List<String> names) {
    names.forEach(System.out::println);
    System.out.println(names.getClass());
  }
}
