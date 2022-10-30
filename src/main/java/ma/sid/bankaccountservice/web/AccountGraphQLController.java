package ma.sid.bankaccountservice.web;

import ma.sid.bankaccountservice.entites.BankAccount;
import ma.sid.bankaccountservice.entites.Customer;
import ma.sid.bankaccountservice.repositories.BankAccountRepository;
import ma.sid.bankaccountservice.repositories.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQLController {
    final BankAccountRepository bankAccountRepository;
    final CustomerRepository customerRepository;

    public AccountGraphQLController(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public List<BankAccount>accounts(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount account(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found",id)));
    }


    @QueryMapping
    public List<Customer>customers(){
        return customerRepository.findAll();
    }
}
