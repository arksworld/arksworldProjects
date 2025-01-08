package org.arksworld.tinyurl.service;

import java.security.SecureRandom;

public class Base62Encoder
{
  private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  private static final int BASE = 62;

  private static final int MIN_LENGTH = 6; // Minimum length for short URLs
  private static final int SALT = 100000; // Salt value for obfuscating small IDs

  public static String encode(long id) {
    StringBuilder encoded = new StringBuilder();
    id += SALT; // Add salt to obfuscate ID
    while (id > 0) {
      encoded.append(BASE62.charAt((int) (id % BASE)));
      id /= BASE;
    }
    while (encoded.length() < MIN_LENGTH) {
      // Pad the result to ensure minimum length
//      encoded.append(BASE62.charAt(new SecureRandom().nextInt(BASE)));
      encoded.append(BASE62.charAt(0));

    }
    return encoded.reverse().toString();
  }

  public static long decode(String shortUrl) {
    long id = 0;
    for (char c : shortUrl.toCharArray()) {
      id = id * BASE + BASE62.indexOf(c);
    }
    return id - SALT; // Remove salt to get the original ID
  }

  public static void main(String[] args) {
    String encoded = encode(1001L);
    System.out.println("Encoded:" + encoded);
    System.out.println("Decoded:" + decode(encoded));
  }
}

