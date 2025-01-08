package org.arksworld.tinyurl.dto;

public class ShortenRequest {
  private String longUrl;

  public String getLongUrl() {
    return longUrl;
  }

  public void setLongUrl(String longUrl) {
    this.longUrl = longUrl;
  }
}
