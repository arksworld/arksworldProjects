package org.arksworld.java23Practice.records;

public class RecordDemo {

  public static void main(String[] args) {
    EmployeeRecord john = new EmployeeRecord(1001L, "John Wick", 120, 12123.12);
    System.out.println("Record:" + john);
    System.out.println("Salary:" + john.salary());

  }
}
