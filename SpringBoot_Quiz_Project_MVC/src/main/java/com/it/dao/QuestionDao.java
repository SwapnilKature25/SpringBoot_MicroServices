package com.it.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>
{
	List<Question> findByCategory(String category);

//	You must use @Param("...") when your query uses :named parameters.
	@Query(value = "SELECT * FROM Question q WHERE q.category = :category ORDER BY RAND()", nativeQuery = true)
	List<Question> findRandomQuestionByCategory(@Param("category") String category);
 
	
	/*
	InvalidDataAccessApiUsageException: For queries with named parameters you need to provide names for method parameters;
	Use @Param for query method parameters...
	
	This means you're using named parameters in your JPQL or native SQL query like:
	@Query("SELECT q FROM Question q WHERE q.category = :category")
	But in the method signature, you did not specify the parameter name using @Param("...").
	
	Spring can’t resolve :category to the method argument String category because the method doesn't declare the name with @Param.
	

	 */
}
