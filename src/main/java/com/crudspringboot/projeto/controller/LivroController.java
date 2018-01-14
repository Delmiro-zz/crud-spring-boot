package com.crudspringboot.projeto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crudspringboot.projeto.model.Livro;
import com.crudspringboot.projeto.service.livroService;


@Controller
public class LivroController {

	@Autowired
	private livroService service;

	@GetMapping("/livro")
	public ModelAndView listaLivro() {
		ModelAndView modelAndView = new ModelAndView("/listaDeLivro");
		modelAndView.addObject("listaDeLivro", service.listarLivro());
		return modelAndView;
	}

	@GetMapping("/adicionaLivro")
	public ModelAndView adicionarLivro(Livro livro) {
		ModelAndView modelAndView = new ModelAndView("/adicionaLivro");
		modelAndView.addObject("livro", livro);
		return modelAndView;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarLivro(@Valid Livro livro, BindingResult result) {
		if (result.hasErrors()) {
			return adicionarLivro(livro);
		}
		service.salvarLivro(livro);
		return listaLivro();
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarLivro(@PathVariable("id") Long id) {
		service.removerLivro(id);
		return listaLivro();
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editarLivro(@PathVariable("id") Long id) {
		return adicionarLivro(service.findOne(id));
	}
}
