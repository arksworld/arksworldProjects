package org.arksworld.tinyurl.service;

import java.util.Optional;
import javax.swing.text.html.Option;
import org.arksworld.tinyurl.entity.URLMapping;
import org.arksworld.tinyurl.repository.URLRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class URLService {
  private final URLRepository urlRepository;

  public URLService(URLRepository urlRepository) {
    this.urlRepository = urlRepository;
  }

  public String shortenURLWithBase64(String longUrl) {
    String shortUrl = Base64.getUrlEncoder()
        .encodeToString(Integer.toString(longUrl.hashCode()).getBytes(StandardCharsets.UTF_8))
        .substring(0, 8);
    urlRepository.save(new URLMapping(shortUrl, longUrl));
    return shortUrl;
  }

  public String getOriginalURLWithBase64(String shortUrl) {
   /* return urlRepository.findById(shortUrl)
        .orElseThrow(() -> new RuntimeException("Short URL not found"))
        .getLongUrl();*/
    return null;
  }

  public String shortenURL(String longUrl) {
    URLMapping urlMapping = new URLMapping();
    urlMapping.setLongUrl(longUrl);
    URLMapping savedUrl = urlRepository.save(urlMapping);
    String shortUrl = Base62Encoder.encode(urlMapping.getId());
    savedUrl.setShortUrl(shortUrl);
    urlRepository.save(savedUrl);
    return shortUrl;
  }
  public String getOriginalURL(String shortUrl) {
    long id = Base62Encoder.decode(shortUrl);
    Optional<URLMapping> urlMapping = urlRepository.findById(id);
    return urlMapping.orElseThrow(() -> new RuntimeException("Not found")).getLongUrl();
  }
}

