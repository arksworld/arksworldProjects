package org.arksworld.tinyurl.controller;

import org.arksworld.tinyurl.dto.ShortenRequest;
import org.arksworld.tinyurl.dto.ShortenResponse;
import org.arksworld.tinyurl.service.URLService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class URLController {
  private final URLService urlService;

  public URLController(URLService urlService) {
    this.urlService = urlService;
  }

  @PostMapping("/shorten")
  public ResponseEntity<ShortenResponse> shortenURL(@RequestBody ShortenRequest request) {
    String shortUrl = urlService.shortenURL(request.getLongUrl());
    return ResponseEntity.ok(new ShortenResponse(shortUrl));
  }

  @GetMapping("/{shortUrl}")
  public ResponseEntity<Void> redirect(@PathVariable String shortUrl) {
    String longUrl = urlService.getOriginalURL(shortUrl);
    return ResponseEntity.status(302).header("Location", longUrl).build();
  }
}
