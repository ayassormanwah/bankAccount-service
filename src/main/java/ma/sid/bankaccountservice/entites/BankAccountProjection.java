package ma.sid.bankaccountservice.entites;

import ma.sid.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1")
public interface BankAccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
