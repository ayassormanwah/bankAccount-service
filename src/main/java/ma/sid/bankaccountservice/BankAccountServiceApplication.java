package ma.sid.bankaccountservice;

import ma.sid.bankaccountservice.entites.BankAccount;
import ma.sid.bankaccountservice.entites.Customer;
import ma.sid.bankaccountservice.enums.AccountType;
import ma.sid.bankaccountservice.repositories.BankAccountRepository;
import ma.sid.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("ayassor", "manwah", "ognak", "alarou").forEach(s -> {
                Customer customer = Customer.builder()
                        .name(s)
                        .build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                for (int i = 0; i < 1 + Math.random() * 10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random() > 0.5 ? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT)
                            .createdAt(new Date())
                            .currency("MAD")
                            .balance(10000 + Math.random() * 90000)
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });
        };
    }

}
