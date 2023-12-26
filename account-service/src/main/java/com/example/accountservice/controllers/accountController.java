package com.example.accountservice.controllers;

import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.entities.Bankaccount;
import com.example.accountservice.models.Customer;
import com.example.accountservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor

@RestController

public class accountController {
private final BankAccountRepository bankAccountRepository;
private final CustomerRestClient customerRestClient;
@GetMapping("/accounts")
public List<Bankaccount> accountList(){
return bankAccountRepository.findAll();
}
    @GetMapping("/accounts/{id}")
    public Bankaccount bankaccountfindById(@PathVariable String id ){
    Bankaccount bankaccount= bankAccountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bankaccount.getIdcustomer());
        bankaccount.setCustomer(customer);
        return bankaccount;
    }


}
