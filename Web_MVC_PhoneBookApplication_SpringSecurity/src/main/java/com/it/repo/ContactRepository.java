package com.it.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Contact;
import com.it.entity.User;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByUser(User user);
}