package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.it.entity.Contact;
import com.it.entity.User;
import com.it.repo.ContactRepository;
import com.it.repo.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/contacts")
    public String viewContacts(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        List<Contact> contacts = contactRepo.findByUser(user);
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/contacts/add")
    public String showAddContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "add-contact";
    }

    @PostMapping("/contacts/add")
    public String addContact(@ModelAttribute Contact contact, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        contact.setUser(user);
        contactRepo.save(contact);
        return "redirect:/contacts";
    }
}

