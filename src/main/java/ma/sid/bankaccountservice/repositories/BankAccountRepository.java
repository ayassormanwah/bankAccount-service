package ma.sid.bankaccountservice.repositories;

import ma.sid.bankaccountservice.entites.BankAccount;
import ma.sid.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource(path = "accounts")
public interface  BankAccountRepository extends JpaRepository<BankAccount, String> {
    @RestResource(path = "/type")
    List<BankAccount> findByType(@Param("t") AccountType accountType);



}
