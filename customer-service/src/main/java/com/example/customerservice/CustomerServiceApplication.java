package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer customer1 =Customer.builder()
                            .firstname("oussama")
                                    .lastname("hll")
                                            .email("haha")
                                                    .build();
            Customer customer2 =Customer.builder()
                    .firstname("ouzssama")
                    .lastname("sshll")
                    .email("hahaq")
                    .build();
            customerRepository.save(customer1);
            customerRepository.save(customer2);
        };
    }
}
