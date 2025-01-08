package org.arksworld.tinyurl.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecureBase62Encoder {
  private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  private static final int BASE = 62;
  private static final int MIN_LENGTH = 8; // Minimum length for short URLs
  private static final long SECRET_KEY = 987654321L; // Secret key for transformation

  // Hashing function using SHA-256
  public static String hash(String input) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
      StringBuilder hexString = new StringBuilder();
      for (byte b : hash) {
        hexString.append(Integer.toHexString(0xff & b));
      }
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Error generating hash", e);
    }
  }

  // Base62 encode with transformation
  public static String encode(long id) {
    id ^= SECRET_KEY; // Obfuscate ID using XOR
    StringBuilder encoded = new StringBuilder();
    while (id > 0) {
      encoded.append(BASE62.charAt((int) (id % BASE)));
      id /= BASE;
    }
    while (encoded.length() < MIN_LENGTH) {
      encoded.append(BASE62.charAt(0)); // Padding
    }
    return encoded.reverse().toString();
  }

  // Decode Base62 with transformation
  public static long decode(String shortUrl) {
    long id = 0;
    for (char c : shortUrl.toCharArray()) {
      id = id * BASE + BASE62.indexOf(c);
    }
    return id ^ SECRET_KEY; // Reverse the XOR operation
  }

  public static void main(String[] args) {
    long originalId = 12312;

    //0014q3bS 11311
    //0014q3az 11312
    //0014q4wD 12312
    // Secure Base62 Encoding
    String encoded = encode(originalId);

    // Hash the original long URL (example usage)
    String longUrl = "https://example.com/long-url";
    String hashedUrl = hash(longUrl);

    // Secure Base62 Decoding
    long decoded = decode(encoded);

    System.out.println("Original ID: " + originalId);
    System.out.println("Encoded Short URL: " + encoded);
    System.out.println("Decoded ID: " + decoded);
    System.out.println("Hashed Long URL: " + hashedUrl);
  }
}

