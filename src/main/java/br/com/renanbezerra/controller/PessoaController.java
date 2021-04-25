package br.com.renanbezerra.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.renanbezerra.controller.dto.PessoaRs;
import br.com.renanbezerra.repository.PessoaRepository;
import lombok.var;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	private final PessoaRepository pessoaRepository;
	
	public PessoaController(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	
	@GetMapping("/funcionando")
	public String retornaString() {
		return "funcionando";
	}

	@GetMapping("/todas")
	public List<PessoaRs> findAll() {
		var pessoas = pessoaRepository.findAll();
		
		var var2 = pessoas.stream()
				.map(PessoaRs::converter)
				.collect(Collectors.toList());
		
		 return var2;
	}
	
}
