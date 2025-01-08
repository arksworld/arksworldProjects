package org.arksworld.tinyurl.repository;



import org.arksworld.tinyurl.entity.URLMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URLMapping, Long> {}
