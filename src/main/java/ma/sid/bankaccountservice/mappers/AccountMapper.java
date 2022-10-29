package ma.sid.bankaccountservice.mappers;

import ma.sid.bankaccountservice.dtos.BankAccountRequestDTO;
import ma.sid.bankaccountservice.dtos.BankAccountResponseDTO;
import ma.sid.bankaccountservice.entites.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public BankAccount formBankAccounRequestDTO(BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount bankAccount = new BankAccount();

        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return bankAccount;
    }
}
