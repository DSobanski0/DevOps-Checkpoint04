package br.com.fiap.banco.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.banco.model.Cliente;
import br.com.fiap.banco.model.Conta;
import br.com.fiap.banco.repository.ClienteRepository;
import br.com.fiap.banco.repository.ContaRepository;

@Controller
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("contas", contaRepository.findAll());
		List<Cliente> clientes = clienteRepository.findAll();
		mv.addObject("cliente", clientes.get(0));
		return mv;
	}
	
	@GetMapping("/nova")
	public String nova(Conta conta) {
		return "conta-form";
	}
	
	@PostMapping
	public ModelAndView salvar(@Valid Conta conta, BindingResult result) {
		if (result.hasErrors()) return new ModelAndView("conta-form");
		ModelAndView mv = new ModelAndView("home");
		contaRepository.save(conta);
		List<Cliente> clientes = clienteRepository.findAll();
		mv.addObject("cliente", clientes.get(0));
		mv.addObject("contas", contaRepository.findAll());
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public String editConta(@PathVariable("id") Long id, Model model) {
		Conta conta = contaRepository.getById(id);
		model.addAttribute(conta);
		
		return "editConta";
	}
	
	@PostMapping("/update/{id}")
	public String updateConta(@PathVariable("id") Long id, @Valid Conta conta, BindingResult result, Model model) {
		if(result.hasErrors()) return "home";
		
		conta.setId(id);
		contaRepository.save(conta);
		return "redirect:/conta";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteConta(@PathVariable("id") Long id) {
		contaRepository.deleteById(id);
		return "redirect:/conta";
	}
}
