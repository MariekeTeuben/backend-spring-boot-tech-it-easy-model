package org.techiteasy.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techiteasy.demo.models.Television;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}
