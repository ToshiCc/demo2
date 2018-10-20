package com.example.demo2.dao;

import com.example.demo2.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
}
