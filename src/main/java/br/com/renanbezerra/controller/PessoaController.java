package br.com.renanbezerra.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.renanbezerra.controller.dto.PessoaRq;
import br.com.renanbezerra.controller.dto.PessoaRs;
import br.com.renanbezerra.model.Pessoa;
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

	@GetMapping("/")
	public List<PessoaRs> findAll() {
		var pessoas = pessoaRepository.findAll();

		return pessoas.stream().map(PessoaRs::converter).collect(Collectors.toList());

	}

	@GetMapping("/{id}")
	public PessoaRs findById(@PathVariable("id") Long id) {
		var pessoa = pessoaRepository.getOne(id);
		return PessoaRs.converter(pessoa);
	}
	
	@PostMapping("/")
	public void savePerson(@RequestBody PessoaRq pessoa) {
		var p = new Pessoa();
		p.setNome(pessoa.getNome());
		p.setSobrenome(pessoa.getSobrenome());
		pessoaRepository.save(p);
					
		
	}
	
	@PutMapping("/{id}")
	public void updatePerson(@PathVariable("id") Long id, @RequestBody PessoaRq pessoa) throws Exception {
		var p = pessoaRepository.findById(id);
		
		if (p.isPresent()) {
			var pessoaSave = p.get();
			pessoaSave.setNome(pessoa.getNome());
			pessoaSave.setSobrenome(pessoa.getSobrenome());
			pessoaRepository.save(pessoaSave);
			
		}else {
			throw new Exception("Pessoa não encontrada");
		}
	}

}
