package com.crudspringboot.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudspringboot.projeto.model.Livro;
import com.crudspringboot.projeto.repository.LivroRepository;

@Service
public class livroService {
	
	//injeta o repositório
	@Autowired
	private LivroRepository repository;

	public List<Livro> listarLivro() {
		return repository.findAll();
	}
	
	public Livro findOne(Long id) {
		return repository.findOne(id);
	}
	
	public Livro salvarLivro(Livro livro) {
		return repository.saveAndFlush(livro);
	}

	public void removerLivro(Long id) {
		repository.delete(id);
	}

	
}
