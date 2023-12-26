package com.example.accountservice.entities;

import com.example.accountservice.enums.AccountType;
import com.example.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Bankaccount {
   @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
  @Enumerated(EnumType.STRING)
    private AccountType type;
  @Transient
  private Customer customer;
    private Long idcustomer;

}
