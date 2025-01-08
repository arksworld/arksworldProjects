package org.arksworld.tinyurl;


import org.arksworld.tinyurl.service.SecureBase62Encoder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecureBase62EncoderTest {

  @Test
  void testEncodeDecodeConsistency() {
    long originalId = 1001;

    // Encode and decode
    String encoded = SecureBase62Encoder.encode(originalId);
    long decoded = SecureBase62Encoder.decode(encoded);

    // Verify consistency
    assertEquals(originalId, decoded, "Decoded ID should match the original ID");
  }

  @Test
  void testMinimumLength() {
    long originalId = 1001;

    // Encode the ID
    String encoded = SecureBase62Encoder.encode(originalId);

    // Verify minimum length
    assertTrue(encoded.length() >= 8, "Encoded short URL should meet the minimum length requirement");
  }

  @Test
  void testSequentialIdsProduceDifferentResults() {
    long id1 = 1001;
    long id2 = 1002;

    // Encode sequential IDs
    String encoded1 = SecureBase62Encoder.encode(id1);
    String encoded2 = SecureBase62Encoder.encode(id2);

    // Verify uniqueness
    assertNotEquals(encoded1, encoded2, "Sequential IDs should produce different encoded values");
  }

  @Test
  void testHashFunction() {
    String longUrl1 = "https://example.com/long-url";
    String longUrl2 = "https://example.com/another-url";

    // Generate hashes
    String hash1 = SecureBase62Encoder.hash(longUrl1);
    String hash2 = SecureBase62Encoder.hash(longUrl2);

    // Verify hashes are unique and deterministic
    assertNotNull(hash1, "Hash should not be null");
    assertNotNull(hash2, "Hash should not be null");
    assertNotEquals(hash1, hash2, "Hashes for different URLs should be unique");
    assertEquals(hash1, SecureBase62Encoder.hash(longUrl1), "Hash should be deterministic for the same input");
  }

  @Test
  void testLargeIdEncodingDecoding() {
    long largeId = 999999999L;

    // Encode and decode
    String encoded = SecureBase62Encoder.encode(largeId);
    long decoded = SecureBase62Encoder.decode(encoded);

    // Verify consistency
    assertEquals(largeId, decoded, "Decoded ID should match the original large ID");
  }
}
