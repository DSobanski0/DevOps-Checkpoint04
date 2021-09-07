package br.com.fiap.banco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

	@GetMapping
	public String index() {
		return "redirect:/conta";
	}
	
}
