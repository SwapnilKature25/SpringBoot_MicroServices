package com.it.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>
{

}
