package org.arksworld.java23Practice.interfaces;

import java.lang.FunctionalInterface;
import java.util.List;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
  public void sayHello(String name);

  public static void main(String[] args) {
    List<String> names = List.of("John Wick", "Jack Reacher", "Ghost Rider", "John Constantine");

    FunctionalInterfaceDemo fid = name -> System.out.println("Good Morning "+ name);
    names.forEach(name -> fid.sayHello(name));
    names.forEach(fid::sayHello);
  }
}


