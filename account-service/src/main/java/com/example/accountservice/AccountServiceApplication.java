package com.example.accountservice;

import com.example.accountservice.entities.Bankaccount;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}


@Bean
CommandLineRunner commandLineRunner(BankAccountRepository accountRepository){
		return args ->{
			Bankaccount bankAccount=Bankaccount.builder()
					.accountId(UUID.randomUUID().toString())
					.balance(9000)
					.currency("MAD")
					.createAt(LocalDate.now())
					.idcustomer(Long.valueOf(2))
					.type(AccountType.SAVING_ACCOUNT)
					.build();
			Bankaccount bankAccount2=Bankaccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAD")
					.balance(8000)
					.createAt(LocalDate.now())
					.idcustomer(Long.valueOf(1))
					.type(AccountType.SAVING_ACCOUNT)
					.build();
	accountRepository.save(bankAccount);
			accountRepository.save(bankAccount2);
		};
}
}
