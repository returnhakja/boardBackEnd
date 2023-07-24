package com.example.borderProject.spring.repository;

import com.example.borderProject.spring.entity.Border;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Border, Long> {
    public List<Border> findAll();
}
