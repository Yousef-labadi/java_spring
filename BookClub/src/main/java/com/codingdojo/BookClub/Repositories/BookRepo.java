package com.codingdojo.BookClub.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.BookClub.models.Book;



@Repository
public interface BookRepo extends CrudRepository <Book, Long> {
	Optional<Book> findById(Long id);
	List<Book> findAll();
	
	
}
