package com.client.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.models.Client;
import com.client.models.ClientDTO;
import com.client.repositories.ClientRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    private final HomeController homeController;
	
	@Autowired
	private ClientRepository clientRepo;

    ClientsController(HomeController homeController) {
        this.homeController = homeController;
    }
	
	@GetMapping({"","/"})
	public String getClients(Model model) {
		var clients=clientRepo.findAll(Sort.by(Sort.Direction.DESC,"id"));
		model.addAttribute("clients",clients);
		return "clients/index";
			//  folder / file
	}
	
	
    // Show create form
	@GetMapping("/create")
	public String createClient(Model model) {
		ClientDTO clientDto=new ClientDTO();
		model.addAttribute("clientDto",clientDto);
		return "clients/create";
	}

    // Handle form submit
	@PostMapping("/create")
	public String createClient(
			@Valid @ModelAttribute("clientDto") ClientDTO clientDto,
			BindingResult result
			) {
		
		if(clientRepo.findByEmail(clientDto.getEmail()) != null) {
			result.addError(
				new FieldError("clientDto","email", clientDto.getEmail(), false, null, null, "Email address is already used")
			);			
		}
		
		if(result.hasErrors()) {
			return "clients/create";
		}
		
		Client client=new Client();
		client.setFirstName(clientDto.getFirstName());
		client.setLastName(clientDto.getLastName());
		client.setEmail(clientDto.getEmail());
		client.setPhone(clientDto.getPhone());
		client.setAddress(clientDto.getAddress());
		client.setStatus(clientDto.getStatus());
		client.setCreatedAt(new Date());
		
		clientRepo.save(client);
		return "redirect:/clients";
	}
	
	
	@GetMapping("/edit")
	public String editClient(Model model, @RequestParam("id") int id) {
		Client client=clientRepo.findById(id).orElse(null);
		if(client==null) {
			return "redirect:/clients";
		}
		
		ClientDTO clientDto=new ClientDTO();
		clientDto.setFirstName(client.getFirstName());
		clientDto.setLastName(client.getLastName());
		clientDto.setEmail(client.getEmail());
		clientDto.setPhone(client.getPhone());
		clientDto.setAddress(client.getAddress());
		clientDto.setStatus(client.getStatus());
		
		model.addAttribute("client",client);
		model.addAttribute("clientDto",clientDto);	
		
		return "clients/edit";
	}
	
	
	@PostMapping("/edit")
	public String editClient(
			Model model,
			@RequestParam("id") int id,
			@Valid @ModelAttribute("clientDto") ClientDTO clientDto,
			BindingResult result
			) {
		
		Client client=clientRepo.findById(id).orElse(null);
		if(client==null) {
			return "redirect:/clients";
		}
		
		model.addAttribute("client",client);

		if(result.hasErrors()) {
			return "clients/create";
		}
		
		// updating client details
		client.setFirstName(clientDto.getFirstName());
		client.setLastName(clientDto.getLastName());
		client.setEmail(clientDto.getEmail());
		client.setPhone(client.getPhone());
		client.setAddress(client.getAddress());
		client.setStatus(client.getStatus());
	
		
		try {
			clientRepo.save(client);			
		}
		catch(Exception e) {
			result.addError(
				new FieldError("clientDto","email",clientDto.getEmail(), false, null, null, "Email address is already used")
			);
			return "clients/edit";
		}
		
		return "redirect:/clients";
	}
	
	
	@GetMapping("/delete")
	public String deleteClient(@RequestParam("id") int id) {
		
		Client client=clientRepo.findById(id).orElse(null);
		if(client!=null) {
			clientRepo.delete(client);
		}
		
		return "redirect:/clients";
	}
	
}
