package com.minsait.emprestimo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.emprestimo.entity.Loan;
import com.minsait.emprestimo.service.LoanService;

@RestController
@RequestMapping("api/v1/emprestimo/clients")
public class LoanController {
	private LoanService loanService;

	@Autowired
	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}
	
	@PostMapping("/{cpf}/emprestimos")
	public Loan registerLoan(@PathVariable("cpf") String cpf, @Valid @RequestBody Loan loan)
	{
		loan.setCpfCliente(cpf);
		return this.loanService.registerLoan(loan);
	}
	
	@GetMapping("/{cpf}/emprestimos")
	public List<Loan> returnAllLoan(@PathVariable("cpf") String cpf) {
		return this.loanService.returnAllLoan(cpf);
	}
	
	@GetMapping("/{cpf}/emprestimos/{id}")
	public Loan returnOneLoan(@PathVariable("cpf") String cpf, @PathVariable("id") Long id) {
		return this.loanService.returnOneLoan(cpf, id);
	}
	
	@PutMapping("/{cpf}/emprestimos/{id}")
	public Loan updateLoan(@PathVariable("cpf") String cpf, @PathVariable("id") Long id) {
		return null;
	}
	
	@DeleteMapping("/{cpf}/emprestimos/{id}")
	public Loan deleteLoan(@PathVariable("cpf") String cpf, @PathVariable("id") Long id) {
		return null;
	}

}