package com.example.accountservice.repositories;

import com.example.accountservice.entities.Bankaccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<Bankaccount,String> {
}
