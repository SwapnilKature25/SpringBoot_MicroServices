package com.it.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.it.entity.Book;

//@Repository  // any class or interface which is responsible to communicate with DB is called as Repository
// To expose the repository as a RestController we will use @RepositoryRestResource
@RepositoryRestResource(path="books")
public interface BookRepository extends JpaRepository<Book,Integer>{
	
	public List<Book> findByName(@Param("name") String name);
}
