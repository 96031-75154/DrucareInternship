package com.bank.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.main.model.Bank;
import com.bank.main.service.BankService;

@RestController
public class BankController {
	
	@Autowired
	BankService bankService;
	
	@PostMapping("/bank")
	public Bank saveBank(@RequestBody Bank bank) {
		return bankService.saveBank(bank);
	}
	
	@GetMapping("/bank/getAll")
	public List<Bank> getAll() {
		return bankService.getAll();
	}
	
	@DeleteMapping("/bank/{ifscCode}")
	public String deleteBank(@PathVariable String ifscCode) {
		return bankService.deleteBank(ifscCode);
	}
	
	@GetMapping("/bank/{ifscCode}")
	public Bank getBank(@PathVariable String ifscCode) {
		return bankService.getByIfsc(ifscCode);
	}
	
	@PutMapping("/bank/update")
	public Bank updateBank(@RequestBody Bank bank) {
		return bankService.updateBank(bank);
	}
	
	@GetMapping("/bank/page")
	public Page<Bank> getPageByBank(@RequestParam("pageCount") Optional<Integer> pageData, @RequestParam("sorted") Optional<String> sortBy) {
		return bankService.getPageByBank(pageData, sortBy);
	}
	
	@GetMapping("/bank/bankList/{bankName}")
	public List<Bank> getListByBank(@PathVariable String bankName) {
		return bankService.getListByBank(bankName);
	}
	
	@GetMapping("/bank/ifsc/{name}")
	public List<String> getIfscByBank(@PathVariable String name) {
		return bankService.getIfscByBank(name);
	}
}
