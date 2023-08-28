package com.bank.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bank.main.model.Bank;
import com.bank.main.repository.BankRepository;

@Service
public class BankService {
	
	@Autowired
	BankRepository bankRepository;

	public Bank saveBank(Bank bank) {
		return bankRepository.save(bank);
	}

	public Bank getByIfsc(String ifscCode) {
		Optional<Bank> bank = bankRepository.getBank(ifscCode);
		if(bank.isPresent())
			return bank.get();
		return null;
	}
	
	public List<Bank> getAll() {
		return bankRepository.findAll();
	}

	public String deleteBank(String ifscCode) {
		Optional<Bank> bank = bankRepository.getBank(ifscCode);
		if (bank.isPresent()) {
			bankRepository.delete(bank.get());
			return "deleted successfully";
		}
		return null;
	}

	public Bank updateBank(Bank bank) {
		Optional<Bank> findBank = bankRepository.findById(bank.getBankId());
		if(findBank.isPresent()) {
			return bankRepository.save(bank);
		}
		return null;
	}
	
	public Page<Bank> getPageByBank(Optional<Integer> pageData, Optional<String> sortBy) {
		return bankRepository.findAll(PageRequest.of(
				pageData.orElse(0),
				2, Direction.DESC, sortBy.orElse("bankId")));
	}

	public List<Bank> getListByBank(String bankName) {
		List<Bank> bankList = bankRepository.findAll();
		return bankList.stream().filter(bank -> bank.getBankName().equals(bankName)).toList();
	}

	public List<String> getIfscByBank(String bankName) {
//		List<Bank> bankList = bankRepository.findAll();
//		List<String> ifscList = bankList
//				.stream()
//				.filter(bank -> bank.getBankName().equals(bankName))
//				.map(b -> b.getIfscCode()).toList();
//		return ifscList;
		
		return bankRepository.getIfscList(bankName);
	}
}
