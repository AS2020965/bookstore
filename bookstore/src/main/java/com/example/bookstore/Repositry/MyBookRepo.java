package com.example.bookstore.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.Entity.MyBookList;

@Repository
public interface MyBookRepo extends JpaRepository<MyBookList, Integer> {

}
