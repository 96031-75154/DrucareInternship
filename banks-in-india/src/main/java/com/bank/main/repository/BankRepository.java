package com.bank.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.main.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

	@Query("select b from Bank b where b.ifscCode = :ifscCode")
	Optional<Bank> getBank(String ifscCode);

	@Query("select b.ifscCode from Bank b where b.bankName = :bankName")
	List<String> getIfscList(String bankName);
}
